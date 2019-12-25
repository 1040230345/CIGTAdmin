package com.cigt.service;


import com.cigt.base.R;
import com.cigt.dto.OrderDto;
import com.cigt.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    /**
     * 查询订单事务
     */
    public R allOrder(){
        List<OrderDto> orderDtos = orderMapper.allOrder();
        if( orderDtos != null){
            return R.ok(orderDtos);
        }else {
            return R.error("订单被吃掉了");
        }
    }

    /**
     * 删除订单事务
     */
    public R deleteOrderByid(int id){
        try{
            int num = orderMapper.deleteOrderByid(id);
            return R.ok("删除成功");
        }catch (Exception e){
            System.out.println(e);
            return R.error("裂开");
        }
    }

    /**
     * 模糊查询事务
     */
    public R findOrderByName(String name){
        List<OrderDto> orderDtos = orderMapper.findOrderByname(name);
        if( orderDtos != null){
            return R.ok(orderDtos);
        }else {
            return R.error("用户名不存在");
        }
    }

}
