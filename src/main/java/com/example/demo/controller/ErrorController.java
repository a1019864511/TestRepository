package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:错误页面拦截器
 * @Author: Xingliu
 * @Verion: 1.0
 * @TIME:Created in 8:13 2020/4/21
 */

@Controller
@RequestMapping("/error")
public class ErrorController {
    @GetMapping(value = "/404")
    public String error_400(){
        return "comm/error_404";
    }


    @GetMapping(value = "/500")
    public String error_500(){
        return "comm/error_500";
    }
}
