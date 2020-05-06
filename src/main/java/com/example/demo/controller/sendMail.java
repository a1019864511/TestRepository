package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api("这是发送邮件使用的测试类")
@RestController
public class sendMail {

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping(value = "/sendMail")
    public String sendSimpleMail(){

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //发出邮件邮箱地址
            simpleMailMessage.setFrom("1019864511@qq.com");
            //目的地邮箱地址
            simpleMailMessage.setTo("xing.liu@askpcb.com");
            //主题
            simpleMailMessage.setSubject("测试邮件发送");
            //内容
            simpleMailMessage.setText("2019-06-24 发送一封邮件");
            //发送邮件
            mailSender.send(simpleMailMessage);
            return "success";

        }catch(Exception e){
            System.out.println("###邮件发送失败:"+e.getMessage());
            return "error";
        }
    }
}

