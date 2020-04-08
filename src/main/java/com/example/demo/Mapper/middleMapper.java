package com.example.demo.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/3/27
 */
@Repository
public interface middleMapper {

   @Update("update middle set site =#{site} where movie_id = #{movieId} and user_id =#{userId}")
   void updateSiteByMovieIdUserid(int movieId,String userId,String site);

   @Insert("insert into middle VALUES(#{movieId},#{site},#{userId})")
   void insertSiteByMovieIdUserid(int movieId,int userId,String site);
}
