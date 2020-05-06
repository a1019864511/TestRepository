package com.example.demo.Services;

import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Xingliu
 * @Verion: 1.0
 * @TIME:Created in 16:40 2020/5/6
 */
public interface MailService {
    public boolean sendMain(String title,String content,String targetMail);
}
