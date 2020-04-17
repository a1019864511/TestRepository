package com.example.demo.Config;

import com.example.demo.Handler.LoginHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/3/3
 */
//遇到
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( new LoginHandler() ).addPathPatterns( "/**" ).excludePathPatterns( "/login", "/shop", "/webjars/**", "/img/**", "/css/**", "/js/**", "/register", "/index" );
    }
}
