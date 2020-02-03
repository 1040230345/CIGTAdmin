package com.cigt.controller;

import com.cigt.base.R;
import com.cigt.dto.GoodsDto;
import com.cigt.dto.UserDto;
import com.cigt.mapper.Goodsmapper;
import com.cigt.my_util.PageUtils;
import com.cigt.service.FileUpService;
import com.cigt.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags="商品操作接口（管理员操作）")
public class goodsController {

    @Autowired
    GoodsService goodsService;
    @Autowired
    FileUpService fileUpService;
    @Autowired
    Goodsmapper goodsmapper;

    /**
     * 查询所有商品
     * @return
     */
    @PostMapping("/api/findAllGoodsInfo")
    @ApiOperation(value = "查询所有商品信息",httpMethod = "POST")
    @ResponseBody
    public Map allGoods(int currPage, int pageSize, Model model){
        int totalCount = goodsmapper.countGoods();
        PageUtils pageUtils = new PageUtils(currPage,pageSize,totalCount);
        System.out.println(currPage+"     "+pageUtils.getTotalPage());
        Map map = new HashMap<>();
        List<GoodsDto> list = goodsService.allGoods(currPage,pageSize);
        if(list != null ){
            map.put("findAllGoods",list);
            map.put("currPage",currPage);
            map.put("TotalPage",pageUtils.getTotalPage());
            return map;
        }
        map.put("findAllGoods","false");
        return map;
    }

    /**
     * 查询单个商品
     */
    @PostMapping("/api/findGoodsByNameInfo")
    @ApiOperation(value = "查询单个商品信息",httpMethod = "POST")
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
    @PostMapping("/api/updateGoodsInfo")
    @ApiOperation(value = "修改商品信息",httpMethod = "POST")
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
    @PostMapping("/api/insertGoodsInfo")
    @ApiOperation(value = "插入商品信息",httpMethod = "POST")
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
    @PostMapping("/api/delectGoodsInfo")
    @ApiOperation(value = "删除用户信息",httpMethod = "POST")
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

    /**
     * 查询商品分类
     */
    @GetMapping("/api/findCategoryInfo")
    @ApiOperation(value = "查询商品分类",httpMethod = "Get")
    @ResponseBody
    public  Map findCategory(){
        Map map = new HashMap();
        List<GoodsDto> list = goodsService.findCategory();
        if(list != null ){
            map.put("findCategory",list);
            return map;
        }
        map.put("findCategory","false");
        return map;
    }

    /**
     * 插入商品分类
     */
    @GetMapping("/api/insertCategoryInfo")
    @ApiOperation(value = "插入商品分类",httpMethod = "Get",notes = "传入category")
    @ResponseBody
    public  Map insertCategory(String category){
        Map map = new HashMap();
        try{
            goodsService.insertCategory(category);
            map.put("insertCategory","true");
            return map;
        }catch (Exception e){
            System.out.println(e);
            map.put("insertCategory","false");
            return map;
        }
    }

    /**
     * 修改商品种类
     */
    @GetMapping("/api/updateCategoryInfo")
    @ApiOperation(value = "修改商品分类",httpMethod = "Get",notes = "传入category")
    @ResponseBody
    public Map updateCategory(GoodsDto goodsDto){
        Map map = new HashMap();
        try{
            goodsService.updateCategory(goodsDto);
            map.put("updateCategory","true");
            return map;
        }catch (Exception e){
            System.out.println(e);
            map.put("updateCategory","false");
            return map;
        }
    }

    /**
     * 删除商品种类
     */
    @GetMapping("/api/deleteCategoryInfo")
    @ApiOperation(value = "删除商品种类",httpMethod = "Get",notes = "传入id")
    @ResponseBody
    public  Map deleteCategory(int id){
        Map map = new HashMap();
        try{
            goodsService.deleteCategory(id);
            map.put("deleteCategory","ture");
            return map;
        }catch (Exception e){
            System.out.println(e);
            map.put("deleteCategory","false");
            return map;
        }
    }

    /**
     * 管理员上传图片
     */
    @PostMapping("/upGoodsImage")
    @ApiOperation("管理员上传图片")
    @ResponseBody
    public R upGoodsImage(@RequestParam("fileName")MultipartFile goodsImage,
                          int type){
        return fileUpService.upload(goodsImage,type);
    }
}
