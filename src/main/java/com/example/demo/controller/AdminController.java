package com.example.demo.controller;

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

    @RequestMapping("/adminindex")
    public String getAdminIndex(){
        return "/Admin/AdminIndex";
    }

    @RequestMapping("/adminshow")
    public String getAdminShow(){
        return "/Admin/AdminShow";
    }

}
