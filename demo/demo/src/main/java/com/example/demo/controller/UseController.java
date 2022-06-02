package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.UserEntity;

import com.example.demo.service.RedisService;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags= "UserController", description = "用户管理模块")
@Controller
@RequestMapping("/user")
public class UseController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @ApiOperation("获取用户列表")
    @GetMapping("list")
    @ResponseBody
    public List<UserEntity> getUserList() {
        List<UserEntity> userEntities = userService.queryList();
        return userEntities;
    }

    @ApiOperation("更新或者保存用户")
    @PostMapping("addOrUpdate")
    @ResponseBody
    public UserEntity addOrUpdate(@RequestBody UserEntity user) {
        userService.addOrUpdateUser(user);
        return user;
    }

    @GetMapping("redis/{id}")
    @ResponseBody
    public UserEntity testRedis(@PathVariable Integer id) {
        String userStr = redisService.get("userId" + id.toString());
        if (userStr == null) {
            UserEntity userEntity = userService.queryById(id);
            System.out.println(JSON.toJSONString(userEntity));
            if (userEntity != null) {
                redisService.set("userId" + id.toString(), JSON.toJSONString(userEntity));
            }
            return userEntity;
        }
        return JSONObject.parseObject(userStr,UserEntity.class);
    }
}