package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


// Alt+enter
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> queryList() {
        return userMapper.selectList(null);
    }

    @Override
    public int addOrUpdateUser(UserEntity userEntity) {
        if (userEntity.getId() != null) {
            userMapper.updateById(userEntity);
        } else {
            userMapper.insert(userEntity);
        }
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        userMapper.deleteById(id);
        return 0;
    }

    @Override
    public UserEntity queryById(Integer id) {
        return userMapper.selectById(id);
    }
}