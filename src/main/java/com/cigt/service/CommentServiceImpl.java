package com.cigt.service;

import com.cigt.dto.commentDto;
import com.cigt.mapper.Commentmapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private Commentmapper commentmapper;

    /**
     * 查询评论
     * @return
     */
    @Override
    public List<commentDto> allComment() {
        List<commentDto> list = commentmapper.findAllcomment();
        if(list != null ){
            return  list;
        }
        return null;
    }

    /**
     * 删除评论
     * @param id
     * @return
     */
    @Override
    public boolean delectComment(int id) {
        int num = commentmapper.deleteComment(id);
        if( num >0 ){
            return true;
        }
        return false;
    }
}
