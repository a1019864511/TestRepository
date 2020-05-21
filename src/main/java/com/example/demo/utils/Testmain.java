package com.example.demo.utils;


import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.example.demo.utils.SendMessageutil.getRandomCode;
import static com.example.demo.utils.SendMessageutil.send;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/4/16
 */
public class Testmain {


    /**
     * @Description:
     * @Author 姓名
     * @Date
     */
    public static void main(String[] args) throws ParseException {
        String str="2020-05-04 15:00:00";
        SimpleDateFormat spf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = spf.parse(str);

        SimpleDateFormat day=new SimpleDateFormat("yyyy-MM-dd");
        day.format(new Date());


        System.out.println(date.toString());
        Date date1 = new Date();
        if(date.getTime()>date1.getTime()){
            System.out.println("咳咳咳");
        }
        System.out.println("比当前时间");

    }
}