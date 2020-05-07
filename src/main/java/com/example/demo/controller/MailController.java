package com.example.demo.controller;

import com.example.demo.Mapper.MailMapper;
import com.example.demo.Services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:邮箱控制器
 * @Author: Xingliu
 * @Verion: 1.0
 * @TIME:Created in 8:21 2020/5/7
 */
@Controller
public class MailController {
    @Autowired
    MailMapper mailMapper;

    @Autowired
    MailService mailService;

    @RequestMapping("/MailMarketing")
    public String MailMarket(){

        return "Admin/MailMarketing";
    }

}
