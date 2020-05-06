package com.example.demo.utils;

import com.example.demo.Services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

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
    @Autowired
    private RedisService redisService;

    /**
     * @Description:
     * @Author 姓名
     * @Date
     */
    public static void main(String[] args) {
           send("a1019864511",
                   "d41d8cd98f00b204e980",
                   "13189275226",
                   "");

    }
}