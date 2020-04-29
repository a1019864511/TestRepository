package com.example.demo.utils;

import com.example.demo.Services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Timer;
import java.util.TimerTask;

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
        Timer timer  = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                System.out.println("正在执行");
            }
        };
        timer.schedule(tt,2000);
        System.out.println("输出对");
    }
}