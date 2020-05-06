package com.example.demo.Services.ServidesImps;

import com.example.demo.Services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @Description:
 * @Author: Xingliu
 * @Verion: 1.0
 * @TIME:Created in 16:43 2020/5/6
 */
public class MailServiceImps implements MailService {
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public boolean sendMain(String title,String content,String targetMail) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //发出邮件邮箱地址
            simpleMailMessage.setFrom("1019864511@qq.com");
            //目的地邮箱地址
            simpleMailMessage.setTo(targetMail);
            //主题
            simpleMailMessage.setSubject(title);
            //内容
            simpleMailMessage.setText(content);
            //发送邮件
            mailSender.send(simpleMailMessage);
           return true;

        }catch(Exception e){
            System.out.println("###邮件发送失败:"+e.getMessage());
            return false;
        }

    }
}
