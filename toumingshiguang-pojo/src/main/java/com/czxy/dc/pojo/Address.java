package com.czxy.dc.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by 舍頭襘游泳 on 2019/1/2.
 */
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    //用户ID
    @Column(name="userId")
    private Integer userId;
    //收货人姓名
    @Column(name="shr_name")
    @JsonProperty("shr_name")
    private String shrName;
    //收货人手机
    @Column(name="shr_phone")
    @JsonProperty("shr_phone")
    private String shrPhone;
    //收货人详情地址
    @Column(name="shr_address")
    @JsonProperty("shr_address")
    private String shrAddress;


}
