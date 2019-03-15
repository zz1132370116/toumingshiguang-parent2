package com.czxy.dc.pojo.cart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by 舍頭襘游泳 on 2018/12/27.
 */
@Data
public class CartItem {
    private Integer skuid;
    private Integer spuid;
    @JsonProperty("goods_name")
    private String goodsName;
    private Double price;
    private Integer count;//购买数量
    private Boolean checked;
    private String midlogo;
    @JsonProperty("spec_info")
    private String specInfo;
}
