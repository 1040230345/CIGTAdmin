package com.cigt.service;


import com.cigt.base.R;
import com.cigt.dto.commentDto;

import java.util.List;

public interface CommentService {

    /**
     * 查询所有评论
     * @return
     */
    List<commentDto> allComment();

    R findCommentByContent(String content);

    /**
     * 删除评论
     */
    boolean delectComment(int id);
}
