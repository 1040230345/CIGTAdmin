package com.cigt.service;

import com.cigt.dto.GoodsDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GoodsService {

    /**
     * 查询所有商品信息
     */
    List<GoodsDto> allGoods(int currPagePara, int pageSizePara);

    /**
     *查询单个商品信息
     */
    List<GoodsDto> findGoodsByName(String name);

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

    /**
     * 查询商品种类
     */
    List<GoodsDto> findCategory();

    /**
     * 插入商品种类
     */
    boolean insertCategory(String category);

    /**
     * 修改商品种类
     */
    GoodsDto updateCategory(GoodsDto goodsDto);

    /**
     * 删除商品种类
     */
    boolean deleteCategory(int id);
}

