package com.example.demo.Mapper;

import com.example.demo.Entity.Movie;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/3/23
 */
@Repository
public interface MovieMapper {
    @Select("select * from movie")
    List<Movie> getAllMovie();

    @Select("select * from movie where movie_id=#{id}")
    Movie getMovieByid(int id);

    @Update("update movie  set movie_site = #{site} where movie_id = #{id}")
    void updateMovieSite(String site, int id);

    @Select("select * from movie where movie_kind =#{MovieKind};")
    List<Movie> getAllMovieByMovieKind(String MovieKind);


    }
