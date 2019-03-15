package com.czxy.toumingshiguang.controller;

import com.czxy.dc.pojo.Product;
import com.czxy.dc.pojo.vo.BaseResult;
import com.czxy.toumingshiguang.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 舍頭襘游泳 on 2019/3/6.
 */
@RestController
@RequestMapping
public class ProductController {
    @Resource
    private ProductService productService;

    /**
     * 随机查询三种美食
     * @return
     */
    @GetMapping("/product")
    public ResponseEntity<BaseResult> product (){
        List<Product> products =productService.findProduct();
        return ResponseEntity.ok(new BaseResult(0,"成功").append("data",products));
    }

    /**
     * 通过id查询美食
     * @param product
     * @return
     */
    @PostMapping("/getProductByid")
    public ResponseEntity<Product> getProductByid(@RequestBody Product product){
        Product productById = productService.findProductById(product.getProductId());
        return ResponseEntity.ok(productById);
    }
}
