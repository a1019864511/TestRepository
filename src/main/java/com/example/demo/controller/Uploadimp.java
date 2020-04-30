package com.example.demo.controller;

import com.example.demo.Entity.Movie;
import com.example.demo.Entity.Table;
import com.example.demo.Mapper.MovieMapper;
import com.example.demo.Mapper.UserMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * layui文件上传接口和文件上传接口
 *
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/4/14
 */
@SuppressWarnings({"ALL", "AlibabaAvoidCommentBehindStatement"})
@Controller
public class Uploadimp {
    @Autowired
    UserMapper userMapper;
    @Autowired
    MovieMapper movieMapper;

    @ResponseBody
    @RequestMapping("/upload")
    public String uploadImp(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();
        String userId = request.getParameter( "id" );

        String path = request.getSession().getServletContext().getRealPath( "img" ) + "\\";
        String name = file.getOriginalFilename();//获取上传的文件名字
        String suffixName = name.substring( name.lastIndexOf( "." ) );//截取当前文件名字的后缀
        String hash = Integer.toHexString( new Random().nextInt() );//生成随机文件名
        String fileName = hash + suffixName;//文件名字
        String pathtwo = "C:\\Users\\xin.liu\\Desktop\\demo\\src\\main\\resources\\static\\img" + "\\";
//        String pathtwo = "D:\\TestRepository\\src\\main\\resources\\static\\img"+"\\";
        File tempFile = new File( pathtwo + fileName );//新建文件名字
        file.transferTo( tempFile );//写入文件到指定的路径
        if(!(userId == null || userId =="")){
            userMapper.updateImgSrc( fileName, userId );
        }
       //给用户更新指定的用户id
        File filepath = new File( path, fileName );
        // System.out.println("随机数文件名称"+filepath.getName());
        //判断路径是否存在，没有就创建一个
        if (!filepath.getParentFile().exists()) {
            System.out.println( "进入创建文件夹方法" );
            filepath.getParentFile().mkdirs();
        }
        tempFile = new File( path + fileName );
        try {
            file.transferTo( tempFile );
        } catch (Exception e) {
            System.out.println( "这句话出现问题了" );
        }

        resUrl.put( "src", tempFile.getPath() );
        res.put( "code", 0 );
        res.put( "msg", fileName);
        res.put( "data", resUrl );

        return res.toString();
    }

    @ResponseBody
    @GetMapping("/adminOperaMovie")
    public Table adminOperaMovie(){
        Table table = new Table();
        List<Movie> allMovie = movieMapper.getAllMovie();
        table.setData(allMovie);
        table.setCount(allMovie.size());
        table.setCode(0);
        return table;
    }
}
