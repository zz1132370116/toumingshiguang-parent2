package com.czxy.dc.service;


import com.czxy.dc.client.UserClient;
import com.czxy.dc.config.JwtProperties;
import com.czxy.dc.entity.UserInfo;
import com.czxy.dc.pojo.User;
import com.czxy.dc.util.JwtUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 舍頭襘游泳 on 2018/12/13.
 */
@Service
@EnableConfigurationProperties(JwtProperties.class)
public class AuthService {

    @Resource
    private UserClient userClient;

    @Resource
    private JwtProperties jwtProperties;

    /**
     * 登录操作
     * @param phone  手机号
     * @param password 密码
     * @return  token值
     */
    public String login(String phone , String password){
        try {
            //1 登录--查询
            User user = userClient.queryUser( phone ,password ).getBody();
            //2 如果不为空，生产token
            if(user != null){
                return JwtUtils.generateToken(new UserInfo( user.getUid() ,user.getUsername() ) , jwtProperties.getPrivateKey() ,  jwtProperties.getExpire() );
            }
            //3 如果为空
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;        //没有登录成功
    }

}
