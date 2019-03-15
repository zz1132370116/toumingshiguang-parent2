package com.czxy.toumingshiguang.controller;

import com.czxy.dc.pojo.Shop;
import com.czxy.dc.pojo.vo.BaseResult;
import com.czxy.toumingshiguang.service.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 舍頭襘游泳 on 2019/3/6.
 */
@RestController
@RequestMapping
public class ShopController {
    @Resource
    private ShopService shopService;

    /**
     * 随机查询5个商家
     * @return
     */
    @GetMapping("/shop")
    public ResponseEntity<BaseResult> shop (){
        List<Shop> shops= shopService.findShop();
        for (Shop shop : shops) {
            System.out.println(shop);
        }
        return ResponseEntity.ok(new BaseResult(0,"成功").append("data",shops));

    }

    /**
     * 通过id查询商家
     * @param shop
     * @return
     */
    @PostMapping("/findShopById")
    public ResponseEntity<Shop> findShopById (@RequestBody Shop shop){
       Shop shop1 = shopService.FindShopById(shop.getSid());
        return ResponseEntity.ok(shop1);

    }

}
