package com.example.demo.Mapper;

import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/3/2
 */
@Repository
public interface UserMapper {
    @Select("select * from user")
    List<User> getallUser();

    @Insert("insert into user values (#{userId},#{userEmail},#{userPwd},#{userName},#{userPhone},#{userMoney},#{userGender})")
    void insertUser(User user);


    @Select("select * from user where user_id = #{id}")
    User getUserByid(String id);

}
