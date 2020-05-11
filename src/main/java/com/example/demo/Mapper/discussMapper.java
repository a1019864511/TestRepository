package com.example.demo.Mapper;

import com.example.demo.Entity.Discuss;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/4/1
 */
@Repository
public interface discussMapper {

    @Select("select * from discuss as  d,`user` as  u where d.user_id=u.user_id and movie_id=#{movieId}")
    List<Discuss> getAllDiscussByMovieId(int movieId);

    /**
     * @param comment  电影评论内容
     * @param userId    用户ID
     * @param movieId   电影ID
     * @param date      现在的评论日期
     */
    @Insert("insert into discuss values (#{userId},#{movieId},#{comment},#{date})")
    void updateDisscuss(String comment,int userId,int movieId,String date);
}
