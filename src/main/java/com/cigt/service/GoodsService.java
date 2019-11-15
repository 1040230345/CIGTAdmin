package com.cigt.service;

import com.cigt.dto.GoodsDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GoodsService {

    /**
     * 查询所有商品信息
     */
    List<GoodsDto> allGoods();

    /**
     *查询单个商品信息
     */
    GoodsDto findGoodsByName(String name);

    /**
     * 修改商品信息
     */
    GoodsDto updateGoods(GoodsDto goodsDto);

    /**
     * 插入数据事务
     */
    GoodsDto register(GoodsDto goodsDto);

    /**
     * 删除商品
     */
    boolean delectGoods(int id);

}
