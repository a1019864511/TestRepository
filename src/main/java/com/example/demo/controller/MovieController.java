package com.example.demo.controller;

import com.example.demo.Entity.Discuss;
import com.example.demo.Entity.Movie;
import com.example.demo.Entity.Order;
import com.example.demo.Mapper.MovieMapper;
import com.example.demo.Mapper.middleMapper;
import com.example.demo.Mapper.orderMapper;
import com.example.demo.Mapper.discussMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    @Autowired
    discussMapper discussMapper;

    /**
     * //RequestMapping支持多个参数
     * //返回主页电影方法
     * //一个是vidon后面带电影种类
     * //一个是vidon后面不带电影种类
     *
     * @param moviekind
     * @param model
     * @return
     */

    @RequestMapping(value = {"/vidon/{MovieKind}", "/vidon"})
    public String vidon(@PathVariable(value = "MovieKind", required = false) String moviekind, Model model) {
        System.out.println( "moviekind：" + moviekind );
        //判断电影种类moviekind是否为空
        //如果为空则代表当前是所有电影页面
        //如果加上种类就是电影分类页面
        if (moviekind == null || moviekind.length() == 0) {
            model.addAttribute( "List", moviemapper.getAllMovie() );
            System.out.println( "进入这个方法了" );
        } else {
            model.addAttribute( "List", moviemapper.getAllMovieByMovieKind( moviekind ) );
            System.out.println( "" );
        }
        return "vidon";
    }

    /**
     * 根据电影id进入座位选坐页面
     */


    @RequestMapping("/shop/{id}")
    public String shop(@PathVariable("id") int id, Model model) {
        model.addAttribute( "movie", moviemapper.getMovieByid( id ) );
        model.addAttribute( "discuss", discussMapper.getAllDiscussByMovieId( id ) );
        List<Discuss> lis = discussMapper.getAllDiscussByMovieId( id );
        for (Discuss li : lis) {
            System.out.println( li.getDiscuss() );
        }
        return "addUser";
    }

    //
    @RequestMapping("/shop")
    public String chooseShop() {
        return "shop";
    }

    /**
     * 插入订单方法
     * 增加座位,每次提交数据则往数据库提交数据
     *
     * @param movieSite
     * @param id
     * @param userId
     * @param money
     * @return
     */

    @ResponseBody
    @RequestMapping("/addSite")
    public String addSite(@RequestParam("movieSite") String movieSite,
                          @RequestParam("id") String id,
                          @RequestParam("userId") String userId,
                          @RequestParam("money") String money) {
        int movieId = Integer.parseInt( id );
        try {
            //把String对象转换成int对象
            int userID = Integer.parseInt( userId );
            //往middle表里面插入一条记录
            middleMapper.insertSiteByMovieIdUserid( movieId, userID, movieSite );
            //得到movie表里面的座位信息
            Movie movie = moviemapper.getMovieByid( movieId );
            //更新最新得到的座位信息
            moviemapper.updateMovieSite( movieSite + movie.getMovieSite(), Integer.parseInt( id ) );
            //存入订单对象
            Order order = new Order();
            //给订单对象插入userID
            order.setUserId( userID );
            order.setUserPrice( money );
            order.setMovieId( movieId );
            order.setOrderCreateTime( getDate() );
            order.setOrderId( getSerialNumber() );
            order.setOrderSite( movieSite );
            System.out.println( order.toString() );
            orderMapper.insertOrder( order );
            System.out.println( order.toString() );
        } catch (Exception e) {
            System.out.println( e );
            return "执行失败";
        }
        Movie movie = moviemapper.getMovieByid( movieId );
        return movie.getMovieSite();

    }

    /**
     * 得到当前时间戳的方法
     *
     * @return
     */
    private static java.sql.Timestamp getDate() {
        Date now = new Date();
        java.sql.Timestamp dateTime = new java.sql.Timestamp( now.getTime() );
        return dateTime;
    }

    /**
     * 得到订单编号的方法
     *
     * @return
     */
    private String getSerialNumber() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat( "yyMMddHHmmss" );
        String Number = formatter.format( calendar.getTime() );
        return Number;
    }


}
