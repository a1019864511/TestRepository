package com.example.demo.controller;

import com.example.demo.Entity.*;
import com.example.demo.Mapper.MailMapper;
import com.example.demo.Mapper.MovieMapper;
import com.example.demo.Mapper.adminMapper;
import com.example.demo.Services.MailService;
import com.example.demo.Services.RedisService;
import com.example.demo.common.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;




/**
 * @Description:
 * @Author: Xingliu
 * @Verion: 1.0
 * @TIME:Created in 16:45 2020/4/20
 */

@Controller
public class AdminController {
    @Autowired
    private RedisService redisService;
    @Autowired
    MovieMapper movieMapper;

    @Autowired
    adminMapper adminMapper;

    @Autowired
    MailMapper mailMapper;
    @Autowired
    private MailService mailService;

    @RequestMapping("/adminindex")
    public String getAdminIndex(){
        redisService.set("11","从缓存获取数据");
        System.out.println(redisService.get("11"));
        return "/Admin/AdminIndex";
    }

    @RequestMapping("/adminshow")
    public String getAdminShow(){
        return "/Admin/AdminShow";
    }

    @RequestMapping("/adminAddMovie")
    public String getAdminAddMovie(){
        return "/Admin/AdminAddmovie";
    }

    @ResponseBody
    @PostMapping("/updateMovieByAdmin")
    public CommonReturnType updateMovieByAdmin(@RequestBody Movie movie){
        CommonReturnType commonReturnType = new CommonReturnType();
        movieMapper.deleteMovieByAdmin( Integer.parseInt(String.valueOf(movie.getMovieId())));
        movieMapper.addMovieByAdmin(movie);
        return  commonReturnType;
    }



    @ResponseBody
    @PostMapping("/AdminLogin")
    public CommonReturnType AdminLogin(@RequestBody Admin admin){
        System.out.println("输出admin属性信息为"+admin.toString());
        CommonReturnType commonReturnType = new CommonReturnType();
       Admin  admin1= adminMapper.idGetAdmin(admin.getAdminUsername());
        if(admin1 == null){
            commonReturnType.setData("您好,尊敬的管理员用户,你的账号不存在,请检查后重新输入");//设置提示消息
            commonReturnType.setStatus(0);//0状态码,代表账号不存在
            return commonReturnType;
        }
        if(admin1.getAdminPassword().equals(admin.getAdminPassword())){
            commonReturnType.setStatus(2);//2状态码,代表登录成功
            return commonReturnType;
        }
        commonReturnType.setData("您好,尊敬的管理员用户,您的密码输入错误,请仔细检查完毕后重新输入");//设置提示消息
        commonReturnType.setStatus(1);//密码错误,请重新输入
        return commonReturnType;

    }

    @RequestMapping("/Cinemaline")
    public String getCinemaline(){
        return "/Admin/Cinemaline";
    }

    @ResponseBody
    @RequestMapping("/movieAreaView/{Id}")
    public Table<MovieArea> movieAreaView(@PathVariable("Id") String id){
        Table<MovieArea> table = new Table<>();
        List<MovieArea> list=movieMapper.getAllMovieArea(id);
       for(MovieArea li:list){
           //4排4座,所以一个座位占的长度都为4
           int pursesite=0;
           if(li.getMovieSite()==null){
              li.setMovieSite("");
           }
           pursesite= li.getMovieSite().length()/4;
          li.setPurchseTicket(String.valueOf(pursesite));
          li.setMovieSite(String.valueOf(40-pursesite));
       }
        table.setCode(0);
        table.setCount(list.size());
        table.setData(list);
        return  table;
    }

    @GetMapping("adminLookAdmin")
    public String  adminLookAdmin(){
        return "Admin/AdminLookAdmin";
    }
    @ResponseBody
    @PostMapping(value="/sendMail",produces="text/plain;charset=UTF-8")
    public void sendMail(@RequestBody String sendTitle){
        Calendar calendar = Calendar.getInstance();
         String content=java.net.URLDecoder.decode(sendTitle);
        SimpleDateFormat formatter = new SimpleDateFormat( "yyMMdd" );
        String data=formatter.format(calendar.getTime());
         List<Mail> lis=  mailMapper.getTodayMail(data);
         for (Mail li:lis){
             mailService.sendMain(sendTitle,content,li.getEmail());
             System.out.println(li.getEmail()+"已经成功发送");
         }
    }
}
