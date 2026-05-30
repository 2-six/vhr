package com.example.vhr.mapper;

import com.example.vhr.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<Role> getRolesByUserId(Integer userId);
}