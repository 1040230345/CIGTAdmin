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
    @Select("select id,goods_id,user_id,content,reply_user_id from t_comment")
    List<commentDto> findAllcomment();

    /**
     * 删除评论
     */
    @Delete("delete from t_comment where id =#{id}")
    int deleteComment(@Param("id") int id);

}
