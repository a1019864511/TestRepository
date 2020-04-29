package com.example.demo.controller;

import com.example.demo.Services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: Xingliu
 * @Verion: 1.0
 * @TIME:Created in 16:45 2020/4/20
 */

@Controller

public class AdminController {
    @Autowired
    private RedisService redisService;
    @RequestMapping("/adminindex")
    public String getAdminIndex(){
        redisService.set("11","从缓存获取数据");
        System.out.println(redisService.get("11"));
        return "/Admin/AdminIndex";
    }

    @RequestMapping("/adminshow")
    public String getAdminShow(){
        return "/Admin/AdminShow";
    }

        @RequestMapping("/adminAddMovie")
    public String getAdminAddMovie(){
        return "/Admin/AdminAddmovie";
    }
}
