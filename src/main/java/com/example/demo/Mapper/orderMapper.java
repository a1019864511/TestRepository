package com.example.demo.Mapper;

import com.example.demo.Entity.Order;
import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/3/27
 */
@Repository
public interface orderMapper {

    @Insert("insert INTO `order` values (#{orderId},#{userId},#{orderCreateTime},#{movieId},#{userPrice},0,#{orderSite})")
    void insertOrder(Order order);

    @Select("select * from `order` where user_id = #{userid}")
    List<Order> getOrderList(String userid);

    @Delete("delete from `order` where order_id =#{orderId}")
    void delOrder(String orderId);
}
