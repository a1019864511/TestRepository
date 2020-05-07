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
    void contextLoads() throws  Exception{
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        long nowTime=formatter.parse(formatter.format( calendar.getTime() )).getTime();
        List<Movie> lis=movieMapper.getAllMovie();
        for(Movie li:lis){
            long beforeTime =  formatter.parse(li.getMovieTime()).getTime();
            if(nowTime>beforeTime){
               String updateTime= formatter.format(beforeTime+ 24 * 60 * 60 * 1000L);
               movieMapper.updateMovieTime(updateTime,li.getMovieId());
            }
        }



    }
}
