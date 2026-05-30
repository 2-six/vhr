package com.example.vhr.mapper;

import com.example.vhr.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    // 根据用户名查询用户（带角色）
    User loadUserByUsername(@Param("username") String username);
}