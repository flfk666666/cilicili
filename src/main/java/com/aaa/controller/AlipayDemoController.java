package com.aaa.controller;

import com.aaa.config.AlipayConfig;
import com.aaa.entity.C_News;
import com.aaa.entity.C_UserAdmin;
import com.aaa.service.C_NewsService;
import com.aaa.service.C_UserAdminService;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
public class AlipayDemoController {

    @Resource
    C_NewsService c_newsService;
    @Resource
    C_UserAdminService c_userAdminService;

    @RequestMapping(value = "/goAlipay", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String goAlipay(HttpServletRequest request, HttpServletRequest response, String price) throws Exception {


        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);



        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = UUID.randomUUID().toString();
        System.out.println("out_trade_no = " + out_trade_no);
        //付款金额，必填
        String total_amount = price;


        //订单名称，必填
        String subject = "购买C币";
        //商品描述，可空
        String body = "";

        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "1c";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+ timeout_express +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        System.out.println("返回页面"+ result);
        return result;
    }

    @RequestMapping("/returnUrl")
    public String returnUrl(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, AlipayApiException {
        response.setContentType("text/html;charset=utf-8");

        boolean verifyResult = rsaCheckV1(request);
        if(verifyResult){
            //验证成功
            //请在这里加上商户的业务逻辑程序代码，如保存支付宝交易号
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            System.out.println("out_trade_no = " + out_trade_no);
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            System.out.println("trade_no = " + trade_no);
            String ids = (String) request.getSession().getAttribute("ids");
            System.out.println("ids = " + ids);
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
            if(total_amount.indexOf(".") !=-1){
                total_amount=total_amount.substring(0,total_amount.indexOf("."));
            }
            C_UserAdmin userAdmin = (C_UserAdmin) (request.getSession().getAttribute("userAdmin"));
            C_News c_news=new C_News();
            c_news.setDatetime(new Date());
            c_news.setNcontext("您充值了"+total_amount+"元");
            c_news.setType("交易记录");
            c_news.setUid(userAdmin.getUid());
            c_newsService.Recharge(c_news);
            c_userAdminService.updateCCoin(userAdmin.getUid(),Integer.parseInt(total_amount));
            if(!StringUtils.isEmpty(ids)){
                String[] split = ids.split(",");
                for (String s : split) {

                }
            }
            return "redirect:view";

        }else{
            return "redirect:error";

        }
    }

    @RequestMapping("toView")
    public String view(String viewName){
        return viewName;
    }

    public boolean rsaCheckV1(HttpServletRequest request){
        // https://docs.open.alipay.com/54/106370
        // 获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }

        try {
            boolean verifyResult = AlipaySignature.rsaCheckV1(params,
                    AlipayConfig.merchant_private_key,
                    AlipayConfig.charset,
                    AlipayConfig.sign_type);

            return verifyResult;
        } catch (AlipayApiException e) {

            return true;
        }
    }

    @RequestMapping("view")
    public String view(HttpSession session){
        C_UserAdmin c_userAdmin=(C_UserAdmin)session.getAttribute("userAdmin");
        C_UserAdmin selone = c_userAdminService.selone(c_userAdmin.getUid());
        session.setAttribute("userAdmin",selone);
        return "redirect:/qt/Voucher_news";
    }

//    @RequestMapping("notify")
//    public String notify(HttpServletRequest request) throws AlipayApiException, UnsupportedEncodingException {
//        // 一定要验签，防止黑客篡改参数
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        StringBuilder notifyBuild = new StringBuilder("/****************************** alipay notify ******************************/\n");
//        parameterMap.forEach((key, value) -> notifyBuild.append(key + "=" + value[0] + "\n") );
////        log.info(notifyBuild.toString());
//
//
//        boolean flag = this.rsaCheckV1(request);
//        if (flag) {
//            /**
//             * TODO 需要严格按照如下描述校验通知数据的正确性
//             *
//             * 商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
//             * 并判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
//             * 同时需要校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email），
//             *
//             * 上述有任何一个验证不通过，则表明本次通知是异常通知，务必忽略。
//             * 在上述验证通过后商户必须根据支付宝不同类型的业务通知，正确的进行不同的业务处理，并且过滤重复的通知结果数据。
//             * 在支付宝的业务通知中，只有交易通知状态为TRADE_SUCCESS或TRADE_FINISHED时，支付宝才会认定为买家付款成功。
//             */
//
//            //交易状态
//            String tradeStatus = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
//            System.out.println("tradeStatus = " + tradeStatus);
//            // 商户订单号
//            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
//            System.out.println("out_trade_no = " + out_trade_no);
//            //支付宝交易号
//            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
//            System.out.println("trade_no = " + trade_no);
//            //付款金额
//            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
//            System.out.println("total_amount = " + total_amount);
//            // TRADE_FINISHED(表示交易已经成功结束，并不能再对该交易做后续操作);
//            // TRADE_SUCCESS(表示交易已经成功结束，可以对该交易做后续操作，如：分润、退款等);
//            if(tradeStatus.equals("TRADE_FINISHED")){
//                //判断该笔订单是否在商户网站中已经做过处理
//                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，
//                // 并判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），并执行商户的业务程序
//                //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
//                //如果有做过处理，不执行商户的业务程序
//
//                //注意：
//                //如果签约的是可退款协议，退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
//                //如果没有签约可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
//            } else if (tradeStatus.equals("TRADE_SUCCESS")){
//                //判断该笔订单是否在商户网站中已经做过处理
//                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，
//                // 并判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），并执行商户的业务程序
//                //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
//                //如果有做过处理，不执行商户的业务程序
//
//                //注意：
//                //如果签约的是可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
//
//                }
//
//            return "redirect:view";
//            }
//
//        return "redirect:view";
//        }

}
