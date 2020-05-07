package com.example.demo.Services.ServidesImps;

import com.example.demo.Entity.Mail;
import com.example.demo.Services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: Xingliu
 * @Verion: 1.0
 * @TIME:Created in 16:43 2020/5/6
 */
@Service
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

    @Override
    public List<Mail> getMailByUrl(String url) {
        List<String> lis  = new ArrayList<>();
        List<Mail> lisMail = new ArrayList<>();
        String date = getDate();
        try{
            URL url1=new URL(url);
            URLConnection conn = url1.openConnection();
            //取得网页数据
            BufferedReader bufIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            //声明循环结束标记
            String line=null;
            //声明正则
            String emailReg="\\w+@\\w+(\\.\\w+)+";
            //将正则表达式封装成对象patttern
            Pattern p = Pattern.compile(emailReg);
            //循环读取网页数据
            while ((line=bufIn.readLine())!=null){
                //让正则对象和要操作的数据相关联，获取正则匹配引擎。
                Matcher m = p.matcher(line);
                //循环查询匹配
                while (m.find()){
                    //打印匹配后的结果
                lis.add(m.group());

                }
            }
            for(String li:lis){
                Mail mail = new Mail();
                mail.setDate(date);
                mail.setEmail(li);
                lisMail.add(mail);
            }

        }catch (Exception e){

        }

        return  lisMail;
    }

    private String getDate(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat( "yyMMdd" );
        return formatter.format(calendar.getTime());
    }
}
