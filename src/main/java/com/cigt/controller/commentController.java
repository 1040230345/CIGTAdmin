package com.cigt.controller;

import com.cigt.base.R;
import com.cigt.dto.commentDto;
import com.cigt.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags="评论操作接口（管理员操作）")
@RequestMapping("/api")
public class commentController {

    @Autowired
   CommentService commentService;

    /**
     * 查询所有评论
     * @return
     */
    @PostMapping("/findAllcommentInfo")
    @ApiOperation(value = "查询所有评论信息",httpMethod = "POST")
    @ResponseBody
    public Map findALLcomment(){
        Map map = new HashMap();
        List<commentDto> list = commentService.allComment();
        if(list != null ){
            map.put("findAllcomment",list);
            return map;
        }
        map.put("findAllcomment","false");
        return map;
    }

    /**
     * 模糊查询
     */
    @PostMapping("/findCommentByContentInfo")
    @ApiOperation(value = "模糊查询评论信息",httpMethod = "POST")
    @ResponseBody
    public R findCommentByContent(String content){ return commentService.findCommentByContent(content); }

    /**
     * 删除评论
     */
    @PostMapping("/delectCommentInfo")
    @ApiOperation(value = "删除评论信息",httpMethod = "POST")
    @ResponseBody
    public Map delectComment(int id){
        Map map = new HashMap();
        try{
            commentService.delectComment(id);
            map.put("delectComment","ture");
            return map;
        }catch (Exception e){
            System.out.println(e);
            map.put("delectComment","false");
            return map;
        }
    }
}
