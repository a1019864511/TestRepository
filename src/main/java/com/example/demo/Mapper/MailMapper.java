package com.example.demo.Mapper;

import com.example.demo.Entity.Mail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: Xingliu
 * @Verion: 1.0
 * @TIME:Created in 18:45 2020/5/6
 */
@Repository
public interface MailMapper {
    @Insert("<script> insert into mail (date,email) values"+
            "<foreach collection='result' item='item' separator=',' >"+
            " (#{item.date},#{item.email})"+
            "  </foreach> </script>")
    boolean insertMail(@Param(value = "result") List<Mail> result);

    @Select("select * from mail")
    List<Mail> GetAllMail();

    @Select("select * from mail where date=#{date}")
    List<Mail> getTodayMail(String date);
}
