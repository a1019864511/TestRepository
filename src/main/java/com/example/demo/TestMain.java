package com.example.demo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @Description:
 * @Author: Xingliu
 * @Verion: 1.0
 * @TIME:Created in 18:18 2020/5/6
 */
public class TestMain {

        public static void main(String[] args) throws Exception {
            //实例化URL类
            URL url=new URL("https://book.douban.com/subject/24753651/discussion/58975313");
            //取得链接
            URLConnection conn = url.openConnection();
            //取得网页数据
            BufferedReader bufIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            //声明循环结束标记
            String line=null;
            //声明正则
            String emailReg="\\w+@\\w+(\\.\\w+)+";
            //将正则表达式封装成对象patttern
            Pattern p = Pattern.compile(emailReg);
            //循环读取网页数据
            while ((line=bufIn.readLine())!=null){
                //让正则对象和要操作的数据相关联，获取正则匹配引擎。
                Matcher m = p.matcher(line);
                //循环查询匹配
                while (m.find()){
                    //打印匹配后的结果
                    System.out.println(m.group());
                }
            }
        }
    }

