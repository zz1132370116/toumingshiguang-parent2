package com.czxy.toumingshiguang.controller;

import com.czxy.dc.pojo.Address;
import com.czxy.dc.pojo.User;
import com.czxy.dc.pojo.vo.BaseResult;
import com.czxy.toumingshiguang.config.GetRandomCodeUtil;
import com.czxy.toumingshiguang.config.SmsUtil;
import com.czxy.toumingshiguang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by 舍頭襘游泳 on 2019/3/5.
 */
@RestController
@RequestMapping
public class UserController {
    @Resource
    private UserService userService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/regist")
    public ResponseEntity<BaseResult> regist (@RequestBody User user){
        //通过手机号查询当前手机号是否注册
        User user1 =userService.selectByPhone(user.getPhone());
        if (user1 == null){
            //如果为空,证明可以注册
            userService.add(user);
            return ResponseEntity.ok(new BaseResult(0,"注册成功"));
        }else{
            return ResponseEntity.ok(new BaseResult(1,"注册失败"));
        }

    }
    /**
     * 发短信
     * @param
     * @return
     */
    @PostMapping("/sms")
    public ResponseEntity<BaseResult> sms (@RequestBody User user) {
        System.out.println(user.getPhone());
        //生成短信验证码
        String randomCode = GetRandomCodeUtil.getNumber();
        // 将短信验证码 保存到session
        //session.setAttribute("randomCode", randomCode);
        redisTemplate.opsForValue().set(user.getPhone(), randomCode, 24, TimeUnit.HOURS);
        System.out.println("生成手机验证码为：" + randomCode);
        User user1 = userService.selectByPhone(user.getPhone());
        if (user1 == null) {
            try {
                SmsUtil.sendSms(user.getPhone(), null, randomCode, null, null);
                // 表示发送成功
                return ResponseEntity.ok(new BaseResult(0, "发送成功"));
            } catch (Exception e) {
                e.printStackTrace();
                // 表示发送成功
                return ResponseEntity.ok(new BaseResult(1, "发送失败"));
            }
        }else{
            // 表示手机号已存在
            return ResponseEntity.ok(new BaseResult(1, "手机号存在"));

        }
    }
    /**
     * 通过手机号和密码进行查询
     * @param phone
     * @param password
     * @return
     */
    @GetMapping("/query")
    public ResponseEntity<User> queryUser(@RequestParam("phone") String phone , @RequestParam("password") String password){
        //通过手机号查询用户
        User byMobile = userService.selectByPhone(phone);
        if (byMobile == null || !byMobile.getPassword().equals(password)){
            //密码不对
            return ResponseEntity.ok(null);
        }else{
            //正确
            return ResponseEntity.ok( byMobile );
        }

    }

    /**
     * 通过手机号查询用户
     * @param user
     * @return
     */
    @PostMapping("/getUser")
    public ResponseEntity<User> getUser(@RequestBody User user){
        //通过手机号查询用户
        User user1 = userService.selectByPhone(user.getPhone());
        //返回用户信息
        return ResponseEntity.ok(user1);
    }
}
