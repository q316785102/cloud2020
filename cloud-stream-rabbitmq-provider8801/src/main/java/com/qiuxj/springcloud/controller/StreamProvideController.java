package com.qiuxj.springcloud.controller;

import com.qiuxj.springcloud.service.StreamProvideService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StreamProvideController {
    @Resource
    StreamProvideService service;
    @GetMapping("send")
    public String send(){
        boolean flag = service.sendMessage();
        return "StreamProvide8801 send message result:"+flag;
    }
}
