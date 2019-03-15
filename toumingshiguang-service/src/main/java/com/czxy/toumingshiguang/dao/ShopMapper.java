package com.czxy.toumingshiguang.dao;

import com.czxy.dc.pojo.Shop;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by 舍頭襘游泳 on 2019/3/6.
 */
@org.apache.ibatis.annotations.Mapper
public interface ShopMapper extends Mapper<Shop> {
 @Select("SELECT * FROM shop ORDER BY RAND() LIMIT 5")
 @Results({
         @Result(property ="sid" ,column = "sid"),
         @Result(property ="shopName" ,column = "shop_name"),
         @Result(property ="shopAddress" ,column = "shop_address"),
         @Result(property ="shopPhone" ,column = "shop_phone"),
         @Result(property ="shopPrice" ,column = "shop_price"),
         @Result(property ="shopImage" ,column = "shop_image")

 })
    List<Shop> findShop();
}
