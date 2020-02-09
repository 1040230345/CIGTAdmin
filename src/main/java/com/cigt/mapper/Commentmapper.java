package com.cigt.mapper;

import com.cigt.dto.commentDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Commentmapper {

    /**
     * 查询所有评论
     */
    @Select("select tc.id,tg.name goods_name,tu.name user_name,content,pid " +
            "from t_comment tc JOIN t_goods tg ON tc.goods_id=tg.id " +
            "JOIN t_user tu ON tc.user_id=tu.id")
    List<commentDto> findAllcomment();

    /**
     * 模糊查询
     */
    @Select("select * from t_comment where content like '%${content}%'")
    List<commentDto> findCommentByCotent(@Param("content") String content);

    /**
     * 删除评论
     */
    @Delete("delete from t_comment where id =#{id} or pid = #{id}")
    int deleteComment(@Param("id") int id);

}
