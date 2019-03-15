package com.czxy.toumingshiguang.controller;

import com.czxy.dc.pojo.Address;
import com.czxy.dc.pojo.User;
import com.czxy.dc.pojo.vo.BaseResult;
import com.czxy.toumingshiguang.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 舍頭襘游泳 on 2019/3/5.
 */
@RestController
@RequestMapping
public class AddressController {
    @Resource
    private AddressService addressService;

    /**
     * 查询地址
     * @param user
     * @return
     */
    @PostMapping("/address")
    public ResponseEntity<BaseResult> address (@RequestBody User user){
        List<Address> addresses = addressService.selectAddByphone(user.getPhone());
        return ResponseEntity.ok(new BaseResult(0,"成功").append("data",addresses));
    }

    /**
     * 添加地址
     * @param address
     * @return
     */
    @PostMapping("/addaddress")
    public ResponseEntity<BaseResult> addaddress (@RequestBody Address address){
        addressService.insert(address);
        return ResponseEntity.ok(new BaseResult(0,"成功"));
    }

    /**
     * 修改地址
     * @param address
     * @return
     */
    @PostMapping("/updateaddress")
    public ResponseEntity<BaseResult> updateaddress (@RequestBody Address address){
        addressService.update(address);
        return ResponseEntity.ok(new BaseResult(0,"成功"));
    }

    /**
     * 删除地址
     * @param address
     * @return
     */
    @PostMapping("/deleted")
    public ResponseEntity<BaseResult> deleted (@RequestBody Address address){
        addressService.delete(address);
        return ResponseEntity.ok(new BaseResult(0,"成功"));
    }
}
