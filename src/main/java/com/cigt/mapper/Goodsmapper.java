package com.cigt.mapper;

import com.cigt.dto.GoodsDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Goodsmapper {

    /**
     *查询所有商品信息
     */
    @Select(" select * from t_goods ")
    List<GoodsDto> findAll();

    /**
     * 查询单个商品信息
     */
    @Select(" select * from t_goods where name like #{name} ")
    GoodsDto findByName(@Param("name") String name);

    /**
     * 修改单个商品信息
     */
    @Update(" update t_goods SET name=#{name},price=#{price},images=#{images},num=#{num},category=#{category},updated_at=#{updated_at} where id = #{id} ")
    int updateById(GoodsDto goodsDto);

    /**
     * 插入单个商品信息
     */
    @Insert(" INSERT INTO t_goods (name, price, images, time, updated_at, user_id, num, category) VALUES ( #{name}, #{price}, #{images}, #{time}, #{updated_at}, #{user_id}, #{num}, #{category} ) ")
    int insertGoods(GoodsDto goodsDto);

    /**
     * 删除单个商品信息
     */
    @Delete(" DELETE FROM t_goods WHERE id= #{id} ")
    int delectGoodsById(int id);
}
