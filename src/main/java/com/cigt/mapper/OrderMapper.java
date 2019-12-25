package com.cigt.mapper;


import com.cigt.dto.OrderDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    /**
     * 查询订单
     */
    @Select("select ts.*,tg.name goods_name,tu.real_name user_name from t_shopping ts " +
            "JOIN t_goods tg ON ts.goods_id=tg.id " +
            "JOIN t_user tu ON ts.user_id=tu.id " +
            "where ts.status = 1 ")
    List<OrderDto> allOrder();


    /**
     * 删除订单
     */
    @Delete("DELETE FROM t_shopping WHERE id= #{id}")
    int deleteOrderByid(@Param("id") int id);

    /**
     *模糊查询
     */
    @Select("select ts.*,tg.name,tu.real_name from t_shopping ts  " +
            "JOIN t_goods tg ON ts.goods_id=tg.id  " +
            "JOIN t_user tu ON ts.user_id=tu.id " +
            "where tg.name like CONCAT('%',#{name},'%') ")
    List<OrderDto> findOrderByname(@Param("name") String name);

}
