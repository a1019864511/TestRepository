package com.example.demo.controller;

import com.example.demo.Entity.Movie;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.Table;
import com.example.demo.Mapper.MovieMapper;
import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/3/27
 */
@Controller
public class OrderController {
    @Autowired
    com.example.demo.Mapper.orderMapper orderMapper;

    @Autowired
    MovieMapper movieMapper;

    @RequestMapping("/historyOrder")
    public String getOrder() {
        return "order";
    }




    @ResponseBody
    @RequestMapping("/dataOrder/{id}")
    public Table getOrderListById(@PathVariable("id") String id) {
        List<Order> orderLis = orderMapper.getOrderList( id );
        //循环获取根据电影id获取电影名字
        for (Order order : orderLis) {
            Movie movie = movieMapper.getMovieByid((int) order.getMovieId() );
            String name = movie.getMovieName();
            String Imgsrc = movie.getMovieImgsrc();
            order.setMovieName( name );
            order.setOrderImgsrc( Imgsrc );
        }
        //表单对象存入东西
        Table table = new Table();
        table.setCode( 0 );
        table.setCount( orderLis.size() );
        table.setData(orderLis );
        System.out.println( table.toString() );
        return table;
    }

    @ResponseBody
    @RequestMapping("/pay")
    public String payOrder(@RequestParam("orderID") String orderId) {
        try {
            orderMapper.updateOrder( orderId );
        } catch (Exception e) {
            return "付款失败";
        }
        return "付款成功";
    }


    @ResponseBody
    @RequestMapping("/delorder")
    public String delOrder(@RequestParam("orderID") String orderId,
                           @RequestParam("movieID") String movieId) {
        try {
            Order order = orderMapper.getOrderById( orderId );
            String site = order.getOrderSite();
            Movie movie = movieMapper.getMovieByid( Integer.parseInt( movieId ) );
            String movieSite = movie.getMovieSite();
            movieSite = movieSite.replaceAll( site, "" );
            movieMapper.updateMovieSite( movieSite, Integer.parseInt( movieId ) );
            orderMapper.delOrder( orderId );
        } catch (Exception e) {
            return "执行失败";
        }
        return "执行成功";
    }


    @ResponseBody
    @RequestMapping("/Exitorder")
    public String exitOrder(@RequestParam("orderID") String orderId) {
        try {
            orderMapper.delOrder( orderId );
        } catch (Exception e) {
            return "执行失败";
        }
        return "执行成功";

    }
}
