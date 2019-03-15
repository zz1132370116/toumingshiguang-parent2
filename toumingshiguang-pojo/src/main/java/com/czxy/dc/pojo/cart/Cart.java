package com.czxy.dc.pojo.cart;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 舍頭襘游泳 on 2018/12/27.
 */
@Data
public class Cart {
    private Map<Integer , CartItem > data = new HashMap<>();
    private Double totle;

    public void addCart(CartItem cartItem) {
        CartItem temp = data.get(cartItem.getSkuid());
        if(temp == null) {
            data.put( cartItem.getSkuid() , cartItem);
        } else {
            temp.setCount( cartItem.getCount() + temp.getCount() );
        }
    }
    public void updateCart(Integer skuid, Integer count , Boolean checked) {
        CartItem temp = data.get(skuid);
        if (temp != null) {
            temp.setCount(count);
            temp.setChecked(checked);
        }
    }
    public void deleteCart(Integer skuid) {
        data.remove( skuid );
    }
    public Double getTotal() {
        double sum = 0.0;
        for (CartItem cartItem : data.values()) {
            //只统计勾选的价格
            if (cartItem.getChecked()) {
                sum += (cartItem.getPrice() * cartItem.getCount());
            }
        }
        return sum;
    }
}
