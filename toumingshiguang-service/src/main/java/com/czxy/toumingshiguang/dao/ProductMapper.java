package com.czxy.toumingshiguang.dao;

import com.czxy.dc.pojo.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by 舍頭襘游泳 on 2019/3/6.
 */
@org.apache.ibatis.annotations.Mapper
public interface ProductMapper extends Mapper<Product> {


   @Select("SELECT * FROM product ORDER BY RAND() LIMIT 3")
   @Results({
           @Result(property ="productId" ,column = "product_id"),
           @Result(property ="productNewprice" ,column = "product_newprice"),
           @Result(property ="productOldprice" ,column = "product_oldprice"),
           @Result(property ="productName" ,column = "product_name"),
           @Result(property ="jifen" ,column = "jifen"),
           @Result(property ="kucun" ,column = "kucun"),
           @Result(property ="number" ,column = "number"),
           @Result(property ="image" ,column = "image"),
           @Result(property ="sid" ,column = "sid"),
           @Result(property ="shop" ,column = "sid",one = @One(select = "com.czxy.toumingshiguang.dao.ShopMapper.selectByPrimaryKey")),

   })
    List<Product> findProduct();
}
