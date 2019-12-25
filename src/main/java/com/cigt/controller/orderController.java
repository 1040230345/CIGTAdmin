package com.cigt.controller;


import com.cigt.base.R;
import com.cigt.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/order")
@Api(tags="订单接口（管理员操作）")
public class orderController {

    @Autowired
    OrderService orderService;

    /**
     * 查询所有订单接口
     * @return
     */
    @GetMapping("/allOrderInfo")
    @ApiOperation(value = "查询所有订单信息")
    @ResponseBody
    public R allOrder(){ return orderService.allOrder(); }

    /**
     * 删除订单接口
     */
    @PostMapping("/deleteOrderInfo")
    @ApiOperation(value = "删除订单信息")
    @ResponseBody
    public R deleteOrder(int id){ return orderService.deleteOrderByid(id); }

    /**
     * 模糊查询接口
     */
    @PostMapping("/findOrderByNameInfo")
    @ApiOperation(value = "模糊查询订单信息")
    @ResponseBody
    public R findOrderByName(String user_name){ return orderService.findOrderByName(user_name); }
}
