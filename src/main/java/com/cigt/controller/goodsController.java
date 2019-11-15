package com.cigt.controller;

import com.cigt.dto.GoodsDto;
import com.cigt.dto.UserDto;
import com.cigt.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class goodsController {

    @Autowired
    GoodsService goodsService;

    /**
     * 查询所有商品
     * @return
     */
    @PostMapping("/findAllGoodsInfo")
    @ResponseBody
    public Map allGoods(){
        Map map = new HashMap<>();
        List<GoodsDto> list = goodsService.allGoods();
        if(list != null ){
            map.put("findAllGoods",list);
            return map;
        }
        map.put("findAllGoods","false");
        return map;
    }

    /**
     * 查询单个商品
     */
    @PostMapping("/findGoodsByNameInfo")
    @ResponseBody
    public Map findGoodsByName(String name){
        Map map = new HashMap();
        GoodsDto goodsDto = goodsService.findGoodsByName(name);
        if (goodsDto != null ){
            map.put("findGoodsByid",goodsDto);
            return map;
        }
        map.put("findGoodsByid","false");
        return map;
    }

    /**
     * 修改商品信息
     */
    @PostMapping("/updateGoodsInfo")
    @ResponseBody
    public Map updateGoods(GoodsDto goodsDto){
        Map map = new HashMap();
      try{
         goodsService.updateGoods(goodsDto);
         map.put("updateGoods","true");
         return map;

      }catch (Exception e){
          System.out.println(e);
          map.put("updateGoods","false");
          return map;
      }

    }

    /**
     * 插入商品信息
     */
    @PostMapping("/insertGoodsInfo")
    @ResponseBody
    public Map insertGoods(GoodsDto goodsDto){
        Map map = new HashMap();
        try{
          goodsService.register(goodsDto);
          map.put("insertGoods","true");
          return map;
        }catch (Exception e){
            System.out.println(e);
            map.put("insertGoods","false");
            return map;

        }
    }

    /**
     * 删除商品信息
     */
    @PostMapping("/delectGoodsInfo")
    @ResponseBody
    public Map delectGoods(int id){
        Map map = new HashMap();
        try{
            goodsService.delectGoods(id);
            map.put("delectGoods","ture");
            return map;
        }catch (Exception e){
            System.out.println(e);
            map.put("delectGoods","false");
            return map;
        }
    }
}
