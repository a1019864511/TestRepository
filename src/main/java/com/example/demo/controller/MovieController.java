package com.example.demo.controller;

import com.example.demo.Entity.Movie;
import com.example.demo.Entity.Order;
import com.example.demo.Mapper.MovieMapper;
import com.example.demo.Mapper.middleMapper;
import com.example.demo.Mapper.orderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/3/26
 */
@Controller
public class MovieController {
    @Autowired
    MovieMapper moviemapper;
    @Autowired
    middleMapper middleMapper;

    @Autowired
    orderMapper orderMapper;


    @RequestMapping("/vidon")
    public String vidon(Model model) {
        model.addAttribute("List",moviemapper.getAllMovie());
        return "vidon";
    }

   @RequestMapping("/shop/{id}")
    public String shop(@PathVariable("id") int id, Model model) {
            model.addAttribute("movie",moviemapper.getMovieByid(id));
            return "addUser";
    }

    @RequestMapping("/shop")
    public String chooseShop(){
            return "shop";
    }
    //插入订单方法

    @ResponseBody
    @RequestMapping("/addSite")
    public String addSite(@RequestParam("movieSite") String movieSite,
                        @RequestParam("id") String id,
                          @RequestParam("userId") String userId,
                          @RequestParam("money") String money){
        int movieId= Integer.parseInt(id);
        try{
           //把String对象转换成int对象

            int userID = Integer.parseInt(userId);
            //往middle表里面插入一条记录
            middleMapper.insertSiteByMovieIdUserid(movieId,userID,movieSite);
            //得到movie表里面的座位信息
            Movie movie=moviemapper.getMovieByid(movieId);
            //更新最新得到的座位信息
            moviemapper.updateMovieSite(movieSite+ movie.getMovieSite(),Integer.parseInt(id));
            //存入订单对象
            Order order = new Order();
            //给订单对象插入userID
            order.setUserId(userID);
            order.setUserPrice(money);
            order.setMovieId(movieId);
            order.setOrderCreateTime(getDate());
            order.setOrderId(getSerialNumber());
            order.setOrderSite(movieSite);
            System.out.println(order.toString());
            orderMapper.insertOrder(order);
            System.out.println(order.toString());
        }catch (Exception e){
            System.out.println(e);
            return "执行失败";
        }
        Movie movie= moviemapper.getMovieByid(movieId);
        return movie.getMovieSite();


    }

    private static java.sql.Timestamp getDate() {
        Date now = new Date();
        java.sql.Timestamp dateTime = new java.sql.Timestamp(now.getTime());
        return dateTime;
    }
    private String getSerialNumber() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");
        String Number = formatter.format(calendar.getTime());
        return Number;
    }
}
