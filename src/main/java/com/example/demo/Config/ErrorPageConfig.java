package com.example.demo.Config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @Description:配置错误页面跳转
 * @Author: Xingliu
 * @Verion: 1.0
 * @TIME:Created in 8:09 2020/4/21
 */
@Configuration
public class ErrorPageConfig  implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        //配置404错误
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND,"/error/404");
        //配置500错误
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error/500");
        registry.addErrorPages(e404,e500);
    }
}
