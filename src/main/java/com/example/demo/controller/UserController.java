package com.example.demo.controller;

import com.example.demo.Entity.Movie;
import com.example.demo.Entity.ReturnData;
import com.example.demo.Entity.User;
import com.example.demo.Mapper.MovieMapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Mapper.discussMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/2/28
 */
@Controller
public class UserController {
    //userMapper
    @Autowired
    UserMapper usermaaper;
    @Autowired
    discussMapper discussMapper;

    //首页
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    //跳转到注册页面
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    //增加用户
    @RequestMapping("/addUser")
    public String addUser() {
        return "addUser";
    }

    //注册用户填写的方法
    @ResponseBody
    @PostMapping("/resist")
    public ReturnData resist(@RequestBody User user) {
        ReturnData data = new ReturnData();
        try {
            usermaaper.insertUser( user );
            data.setCode( "0" );//0代表插入成功
            data.setMessage( "注册成功" );
            return data;
        } catch (Exception e) {
            if (usermaaper.getUserByid( user.getUserId() ) != null) {
                data.setCode( "1" );//2代表当前用户已经存在
                data.setMessage( "该用户名已经存在,请重新输入" );
                return data;
            }
            ;

            String message = e.toString();
            if (message.contains( "user_email" ) || message.contains( "user_phone" )) {
                message = "你的邮箱或者电话号码已经存在,";
            }
            data.setCode( "2" );
            data.setMessage( message );
            return data;
        }

    }


    @ResponseBody
    @PostMapping("/login")
    public ReturnData login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        ReturnData data = new ReturnData();
        User checkUser = usermaaper.getUserByid( username );
        if (checkUser == null) {
            data.setMessage( "你的账户名不存在，请重新检查您的账户名" );
            data.setCode( "0" );
            return data;
        }
        if (checkUser.getUserPwd().equals( password )) {
            session.setAttribute( "name", "login" );
            session.setAttribute( "user", checkUser.getUserName() );
            session.setAttribute( "userbyid", checkUser.getUserId() );
            session.setAttribute( "userImgsrc", checkUser.getUserImgsrc() );
            data.setMessage( "成功登陆" );
            data.setCode( "1" );
            return data;
        }
        data.setMessage( "密码错误" );
        data.setCode( "2" );
        return data;
    }

    @RequestMapping("/updateUser/{UserID}")
    public String updateUser(@PathVariable("UserID") String id, Model model) {
        System.out.println( "ID为" + id );
        User user = usermaaper.getUserByid( id );
        System.out.println( user.toString() );
        model.addAttribute( "usershow", user );
        return "UserUpdate";
    }

    /**
     * 个人用户信息修改页面api
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateUser")
    public String updateUserbyid(@RequestBody User user){
        System.out.println("updateUser数据为"+user.toString());
        return "";
    }
    @RequestMapping("/UserUpdateImg/{UserID}")
    public String updateUserImg(@PathVariable("UserID") String id, Model model) {
        System.out.println( "ID为" + id );
        User user = usermaaper.getUserByid( id );

        model.addAttribute( "usershow", user );
        return "UserUpdate";
    }
}