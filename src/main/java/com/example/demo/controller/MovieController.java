package com.example.demo.controller;

import com.example.demo.Entity.Discuss;
import com.example.demo.Entity.Movie;
import com.example.demo.Entity.Order;
import com.example.demo.Mapper.MovieMapper;
import com.example.demo.Mapper.middleMapper;
import com.example.demo.Mapper.orderMapper;
import com.example.demo.Mapper.discussMapper;
import com.example.demo.common.CommonReturnType;
import io.swagger.annotations.ApiOperation;
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
        if (moviekind == null || moviekind.length() == 0) {
            model.addAttribute( "List", moviemapper.getAllMovie() );
            System.out.println( "进入这个方法了" );
        } else {
            model.addAttribute( "List", moviemapper.getAllMovieByMovieKind( moviekind ) );
            System.out.println( "" );
        }
        return "vidon";
        //少思情欲 老酌生死
    }



    @RequestMapping("/shop/{id}")
    public String shop(@PathVariable("id") int id, Model model) {
        //修复当电影座位为空的时候导致前端有bug无法增加座位的bug
        Movie movie=moviemapper.getMovieByid(id );
        if(movie.getMovieSite()==null){
            movie.setMovieSite("");
        };
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
            int userID = Integer.parseInt(userId);
//            //往middle表里面插入一条记录
//            middleMapper.insertSiteByMovieIdUserid( movieId, userID, movieSite );
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

        /**
         * 模糊查询得到当前电影的方法
         * @return
         */

    }
    @ResponseBody
    @RequestMapping("/updateMovieTime")
    public String updateMovieTime() {
        try{
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
            long nowTime=formatter.parse(formatter.format( calendar.getTime() )).getTime();
            List<Movie> lis=moviemapper.getAllMovie();
            for(Movie li:lis){
                long beforeTime =  formatter.parse(li.getMovieTime()).getTime();
                if(nowTime>beforeTime){
                    String updateTime= formatter.format(beforeTime+ 24 * 60 * 60 * 1000L);
                    moviemapper.updateMovieTime(updateTime,li.getMovieId());
                }
            }
        }catch (Exception e){
            return "程序遇到异常,执行失败";
        }
        return "更新时间成功";

    }
    @RequestMapping("obscureGetMovie")
    private String  obscureGetMovie(@RequestParam("movieName") String movieName,
                                    Model model){
        System.out.println("---------------------------");
        model.addAttribute("List",moviemapper.getAllMovieByMovieName("%"+movieName+"%"));
        return "vidon";
    }

    @ApiOperation("增加管理员增加电影的方法")
    @PostMapping("/addMovieByAdmin")
    @ResponseBody
    public CommonReturnType addMovieByAdmin(@RequestBody Movie movie){
        CommonReturnType commonReturnType = new CommonReturnType();
        double d = Math.random();
        String.valueOf(d).substring(3,14);
        movie.setMovieId(Integer.parseInt(String.valueOf(d).substring(3,11)));
        System.out.println(movie.toString());
        if(!moviemapper.addMovieByAdmin(movie)) {
            commonReturnType.setStatus(0);
            commonReturnType.setData("恭喜你,数据插入失败");
            return commonReturnType;
        }
        commonReturnType.setStatus(1);
        commonReturnType.setData("恭喜您,成功插入电影数据");
        return commonReturnType;
    }

    /**
     *
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
        return formatter.format( calendar.getTime() );
    }

//    public String updateMovieTime(){
//      List<Movie> lis=  moviemapper.getAllMovie();
//        SimpleDateFormat spf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date1 = new Date();
//        for(Movie li:lis){
//          try {
//              spf.parse(li.getMovieTime());
//          }catch (Exception e){
//              System.out.println("存在很多问题");
//          }
//
//      }
//        return "";
//    }


}
