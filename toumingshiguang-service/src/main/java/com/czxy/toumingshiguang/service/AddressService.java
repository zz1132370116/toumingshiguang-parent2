package com.czxy.toumingshiguang.service;

import com.czxy.dc.pojo.Address;
import com.czxy.dc.pojo.User;
import com.czxy.toumingshiguang.dao.AddressMapper;
import com.czxy.toumingshiguang.dao.UserMapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 舍頭襘游泳 on 2019/3/5.
 */
@Service
public class AddressService {
    @Resource
    private AddressMapper addressMapper;
    @Resource
    private UserMapper userMapper;
    public List<Address> selectAddByphone(String phone) {
        //条件查询User
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        //条件查询Address
        Example example2 = new Example(Address.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria.andEqualTo("phone",phone);

        User user = userMapper.selectOneByExample(example);
        criteria2.andEqualTo("userId",user.getUid());
        List<Address> addresses = addressMapper.selectByExample(example2);
        return addresses;

    }

    public void insert(Address address) {
        addressMapper.insert(address);
    }

    public void update(Address address) {
       addressMapper.updateByPrimaryKeySelective(address);

    }

    public void delete(Address address) {
        addressMapper.deleteByPrimaryKey(address);
    }
}
