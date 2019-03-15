package com.czxy.toumingshiguang.service;

import com.czxy.dc.pojo.Product;
import com.czxy.dc.pojo.Shop;
import com.czxy.toumingshiguang.dao.ProductMapper;
import com.czxy.toumingshiguang.dao.ShopMapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 舍頭襘游泳 on 2019/3/6.
 */
@Service
public class ShopService {
    @Resource
    private ShopMapper shopMapper;
    @Resource
    private ProductMapper productMapper;

    /**
     * 随机查询商家
     * @return
     */
    public List<Shop> findShop() {
        return shopMapper.findShop();

    }

    /**
     * 查询商家通过id
     * @param sid
     * @return
     */
    public Shop FindShopById(Long sid) {
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sid",sid);
        List<Product> products = productMapper.selectByExample(example);
        Shop shop = shopMapper.selectByPrimaryKey(sid);
        shop.setProducts(products);
         return shop;

    }
}
