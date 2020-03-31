package com.example.demo;

import com.example.demo.Entity.Movie;
import com.example.demo.Mapper.MovieMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    MovieMapper movieMapper;


    @Test
    void contextLoads() {
       movieMapper.updateMovieSite("123",1);
    }
}
