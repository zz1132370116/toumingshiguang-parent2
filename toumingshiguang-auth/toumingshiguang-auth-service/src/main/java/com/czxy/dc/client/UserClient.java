package com.czxy.dc.client;

import com.czxy.dc.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 舍頭襘游泳 on 2018/12/13.
 */

@FeignClient("web-service")
// @Component
public interface UserClient {
    @GetMapping("query")
    ResponseEntity<User> queryUser(@RequestParam("phone") String mobile,
                                   @RequestParam("password") String password);
}