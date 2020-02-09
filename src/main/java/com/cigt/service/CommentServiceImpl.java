package com.cigt.service;

import com.cigt.base.R;
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
     * 模糊查询
     */
    @Override
    public R findCommentByContent(String content){
        List<commentDto> list =commentmapper.findCommentByCotent(content);
        if(list != null ){
            return  R.ok(list);
        }
        return R.error(4001,"搜索结果为空");
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
