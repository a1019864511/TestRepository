package com.example.demo.utils;

import com.example.demo.Services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.*;

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
        double d = Math.random();
        String.valueOf(d).substring(3,14);
    }
}