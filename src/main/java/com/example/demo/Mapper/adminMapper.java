package com.example.demo.Mapper;

import com.example.demo.Entity.Admin;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: Xingliu
 * @Verion: 1.0
 * @TIME:Created in 9:10 2020/4/21
 */

@Repository
public interface adminMapper {

    @Select("select * from Admin where admin_username = #{userName}")
    Admin idGetAdmin(String userName);


    @Select("select * from Admin")
    List<Admin> getAllAdmin();

}
