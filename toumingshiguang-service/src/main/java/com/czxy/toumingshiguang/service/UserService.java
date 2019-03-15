package com.czxy.toumingshiguang.service;

import com.czxy.dc.pojo.User;
import com.czxy.toumingshiguang.dao.UserMapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * Created by 舍頭襘游泳 on 2019/3/5.
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User selectByPhone(String phone) {
        //创建条件
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("phone",phone);
        //通过条件查询一条
        User user = userMapper.selectOneByExample(example);
        return user;
    }

    public void add(User user) {
        userMapper.insert(user);
    }



}
