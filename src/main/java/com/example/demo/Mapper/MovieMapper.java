package com.example.demo.Mapper;

import com.example.demo.Entity.Movie;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/3/23
 */
@SuppressWarnings({"ALL", "AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc"})
@Repository
public interface MovieMapper {
    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    @Select("select * from movie")
    List<Movie> getAllMovie();

    @Select("select * from movie where movie_id=#{id}")
    Movie getMovieByid(int id);

    @Update("update movie  set movie_site = #{site} where movie_id = #{id}")
    void updateMovieSite(String site, int id);

    @Select("select * from movie where movie_kind =#{MovieKind};")
    List<Movie> getAllMovieByMovieKind(String MovieKind);

    @Select("select * from movie where  movie_name like #{movieName}")
    List<Movie> getAllMovieByMovieName(String movieName);


    @Insert("INSERT INTO `movie` VALUES (#{movieName}, #{movieId}, #{movieActor}, #{movieIntroduce}, #{movieDirect}, #{siteId}, #{movieArea}, #{movieTime}, #{movieImgsrc}, #{movieSite},#{moviePrice}, #{movieKind})")
    boolean addMovieByAdmin(Movie movie);
    }
