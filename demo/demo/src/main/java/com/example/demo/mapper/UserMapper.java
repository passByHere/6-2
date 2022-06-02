package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Component;


@Component
public interface UserMapper extends BaseMapper<UserEntity> {
}
