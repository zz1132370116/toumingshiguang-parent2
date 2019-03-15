package com.czxy.toumingshiguang.service;

import com.czxy.dc.pojo.Product;
import com.czxy.dc.pojo.Shop;
import com.czxy.toumingshiguang.dao.ProductMapper;
import com.czxy.toumingshiguang.dao.ShopMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 舍頭襘游泳 on 2019/3/6.
 */
@Service
public class ProductService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private ShopMapper shopMapper;

    /**
     * 随机查询3条
     * @return
     */
    public List<Product> findProduct() {
      return  productMapper.findProduct();
    }

    /**
     * 通过id查询美食,将对应的商家封装
     * @param productId
     * @return
     */
    public Product findProductById(Long productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        Shop shop = shopMapper.selectByPrimaryKey(product.getSid());
        product.setShop(shop);
        return product;

    }
}
