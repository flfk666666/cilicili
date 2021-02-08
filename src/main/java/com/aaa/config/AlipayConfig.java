package com.aaa.config;
import java.io.FileWriter;
import java.io.IOException;
/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101100658443";
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCt553SISJ4y04jQTRyZngewx2kCfKQ3E7BbSnMC9CDGhrhvIg3x3N56VQioYNRnurQnO37YEev6RsdVLxOgBtaPzxi0iL8m6F7vh4VYLSkEuj8MVWKkaO5xpZbAoJbglN3xIQoSRIc0eYaGq/GhJMonE18r5A9q90hTg8uhWI8ZNxDGMzoYsmMpE/kEaPr1JlJnanzPJF4nE4FNDVkyXPPSylDl7U9MygairSF2Z6d7ghahquQDWQl2tocNpp7bxc1RhyjMO9KdWYe1mzioYK3CGY4Yzg109Atd9dp0lVfwptJTzw/2GSIPd5L4KZ91QzMu75N4WFVbwKg1MzOgA5TAgMBAAECggEANmBRzL5nlPWc/REKYSsBLD0+K2ig3ALG7VxA0XhwPk4PUb4tqaNHzDrU/+8YrJDQQ2KOVyeHws1UmRtBthoAc3uKWivynKHdIGAV8AFI+nSfPRv/71ASragWo2ZpdEuP5ccgu6f9bd2D4W2uwJf7m5sj73TF2UK/5gYOYTF7wf4TYr56DVjLZ001Cb0wpdS2dy2C9dsNEOz/BH3CmTFbXAHhDdyvN/Sf7rDwfrN87mum4ptNZocb7v1EjVGb83AERtx4N8B7+1FQBrLzW+mqvYo/Jl1RJHDgm5Zs8K2s4cIUqYnFzxlVnTerucYaMPfNPdNKDRfxecB59vZLmzURIQKBgQDf3ZuLn/6i9vHcLmkmtvwjqcxSVmipKzvRPjqXllLfTDPgiDfEI5SO1RvQmJnPm5atlFTgM5hFsIOeu0Y9upG9QGT22HtRN48OLsbLaQ4P8ZAfQbSFsQurC9yH2nuiXyMWLKvlV/Tv49OxNYwLdeTiaJx08sc2tYIZAamQ4nydlwKBgQDG3hhndm28WIZ5ODQtaljhaZmMVvGNtKP/ocmBiUEaxC/01ZZyRDJQRcWmUT2qG16IuBNP6R5jl3SroWyS28ydYY51JH+ApL+GQqzpsmE+nKGk822xDC1fZC4Eqj1+lxkRiMtS/0kWUMw09u0REs6Oww9Y8SOtxtQH3G4DSUzkpQKBgHbjpTjYxo3bogTyLOvfoDZ8dcOAmmLFUCZG6y0YK3jlamOjVCJ5VusoKHZ2pLEKC1KyBQVwwTy5ip0hDiO4Uq/0Y+poe81dOT8p/m+Gom47NvQym+Gobe7wBLWthZ1s8yBSpxPMy4sfLozdSDvJ572KGxVM3hmi+a24IUqNzeqPAoGAS3RFSixTIp1sGF5M3dZ19sD8c5UhfaTGfN3D+RQ80Y0SrRDFToG1nWN7xMkaXoqX6cP9/9nxn9P9fol3Cpm/Hw++34+DmSnpSWXO+bSm1PzVECMUwZJfPMxj8X0ua/OknVSL4OffsUni0U3HUS0TlnNIRXTpFqxUEs9+Jl0PgckCgYAmfAqfiZVtYWvhiM9rvhVnBka0mc/jVq9AV0vopqpA6ESBc9Qhk6z4IMvVWOsHatrtGK2W5LxN6kTsy1Gxm6tijDer4j4WTYcFhRMLyMpDFeXMk9DJF5+oQtVeyA3Dr5tc4MnWWJlJJ0iE9vERBw/ANIFCDBmFptDy7vj5Fs00rQ==";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiu0SpeDZVmJFIWMG3bSKlXlmqFzwM98nI/Je9Vo/gY7RSasv9kHlp/bn30leMRQ85Kxxt8ffTHR8BUrdwDtsgCbF6OfhmQjGPGbBP2UxFqPTugXbX2zd2PbDc4yh/w4iiRTnNZ71kYPuwvAPKyyufuizGHOASOAuJvL5+tERoRqH0KJO6XXbosrbYCYJ/1qjUS8b7nfRYUL4NdaKXblcKmbLrmAx8pTmB6/LfX+Z8fqUZNcIpKuGfquTaBMSdIyA5doNtvTNoRQTfRSnAsewA/B8OxOm5D3VpJZhuY39fz5zULzF/U+u/1Pe5rF4K4PgmfIyv94Lcp5+wJVe4gIflwIDAQAB";
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String notify_url = "http://127.0.0.1:8080/eight/app/list.form/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";
    public static String notify_url = "http://127.0.0.1:8080/notify";
    //public static String notify_url = "http://www.baidu.com";
    
	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/returnUrl";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

