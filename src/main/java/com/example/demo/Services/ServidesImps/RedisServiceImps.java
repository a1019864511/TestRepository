package com.example.demo.Services.ServidesImps;

import com.example.demo.Services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Description:RedisService的实现类
 * @Author: Xingliu
 * @Verion: 1.0
 * @TIME:Created in 17:25 2020/4/28
 */
//@Service的注解的意思是告诉sping容器,service的接口实现类是哪一个
@Service
public class RedisServiceImps implements RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean expire(String key, long expire) {
        return stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public Long increment(String key, long delta) {
         return stringRedisTemplate.opsForValue().increment(key,delta);
    }
}
