package com.example.demo.service;

import com.example.demo.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> queryList();


    int addOrUpdateUser(UserEntity userEntity);


    int deleteById(Integer id);


    UserEntity queryById(Integer id);
}
