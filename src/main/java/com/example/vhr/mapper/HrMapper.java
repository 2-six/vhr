package com.example.vhr.mapper;

import com.example.vhr.entity.Hr; // 改为 Hr
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HrMapper {

    // 根据用户名查询用户（带角色）
    Hr loadUserByUsername(@Param("username") String username);

    // 关键：表名改为 hr
    @Select("SELECT * FROM hr WHERE username = #{username}")
    Hr getHrByUsername(String username);
}