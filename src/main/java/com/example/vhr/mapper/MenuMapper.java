package com.example.vhr.mapper;

import com.example.vhr.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> getAllMenus();
    List<Menu> getMenusByUserId(Integer userId);
}