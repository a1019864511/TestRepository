package com.example.demo.Mapper;

import com.example.demo.Entity.Discuss;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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

}
