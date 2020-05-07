package com.example.demo;

import com.example.demo.Entity.Mail;
import com.example.demo.Entity.Movie;
import com.example.demo.Mapper.MailMapper;
import com.example.demo.Mapper.MovieMapper;
import com.example.demo.Services.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    MovieMapper movieMapper;
    @Autowired
    MailService mail;

    @Autowired
    MailMapper mailMapper;

    @Test
    void contextLoads() {
      List<Mail> lis= mail.getMailByUrl("https://book.douban.com/subject/24753651/discussion/58975313/");
        List<Mail> lismail=new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat( "yyMMdd" );

    mailMapper.insertMail(lismail);

    }
}
