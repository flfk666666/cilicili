package com.aaa.controller;

import com.aaa.service.C_FolkoperaService;
import com.aaa.service.C_VideoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("tj")
public class ReportformController {

    @Resource
    C_VideoService c_videoService;

    @Resource
    C_FolkoperaService c_folkoperaService;

    @RequestMapping("VideoPlayback")
    @ResponseBody
    public List<Map<String,Object>> VideoPlayback(){
        return c_videoService.queryTop5();
    }

    @RequestMapping("FolkoperaPlayback")
    @ResponseBody
    public List<Map<String,Object>> FolkoperaPlayback(){
        return c_folkoperaService.query5ByPlaybackValue();
    }
}
