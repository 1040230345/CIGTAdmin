package com.cigt.service;

import com.cigt.dto.GoodsDto;
import com.cigt.mapper.Goodsmapper;
import com.cigt.my_util.GetTime_util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl  implements GoodsService{

    @Autowired
    private Goodsmapper goodsmapper;
    @Autowired
    private GetTime_util getTime_util;

    /**
     * 查询所有商品
     * @return
     */
    @Override
    public List<GoodsDto> allGoods() {
        List<GoodsDto> list = goodsmapper.findAll();
        if(list != null ){
            return  list;
        }
        return null;
    }

    /**
     * 查询单个商品
     * @param name
     * @return
     */
    @Override
    public GoodsDto findGoodsByName(String name) {
        GoodsDto goodsDto = goodsmapper.findByName(name);
        if ( goodsDto != null){
            return goodsDto;
        }
        return null;
    }

    /**
     * 更新操作
     * @param goodsDto
     * @return
     */
    @Override
    public GoodsDto updateGoods(GoodsDto goodsDto) {
        //赋值更新时间
        goodsDto.setUpdated_at(getTime_util.GetNowTime_util());

        int num = goodsmapper.updateById(goodsDto);
        if ( num > 0 ){
            return goodsDto;
        }
        return null;
    }

    /**
     *插入操作
     * @param goodsDto
     * @return
     */
    @Override
    public GoodsDto register(GoodsDto goodsDto) {
        //赋值更新时间和上传时间
        goodsDto.setTime(getTime_util.GetNowTime_util());
        goodsDto.setUpdated_at(getTime_util.GetNowTime_util());
        int num = goodsmapper.insertGoods(goodsDto);
        if( num > 0 ){
            return goodsDto;
        }
        return null;
    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    @Override
    public boolean delectGoods(int id) {
        int num = goodsmapper.delectGoodsById(id);
        if( num >0 ){
            return true;
        }
        return false;
    }
}
