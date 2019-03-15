package com.czxy.toumingshiguang.service;

import com.czxy.toumingshiguang.dao.CartMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: 舍頭襘游泳
 * @Date: 2019/3/12 08:24
 * @Description:
 */
@Service
public class CartService {
    @Resource
    private CartMapper cartMapper;
}
