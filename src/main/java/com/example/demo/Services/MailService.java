package com.example.demo.Services;

import com.example.demo.Entity.Mail;

import java.util.List;

/**
 * @Description:
 * @Author: Xingliu
 * @Verion: 1.0
 * @TIME:Created in 16:40 2020/5/6
 */
public interface MailService {
    public boolean sendMain(String title,String content,String targetMail);
    public List<Mail> getMailByUrl(String url);
}
