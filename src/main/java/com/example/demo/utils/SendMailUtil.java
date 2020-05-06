package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @Description:
 * @Author: Xingliu
 * @Verion: 1.0
 * @TIME:Created in 16:38 2020/5/6
 */
public class SendMailUtil {
    @Autowired
    private JavaMailSender mailSender;


}
