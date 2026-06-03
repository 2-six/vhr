package com.example.vhr.mapper;

import com.example.vhr.entity.Role;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface RoleMapper {
    @Select("select * from role")
    List<Role> selectAll();

    @Insert("insert into role(name,nameZh) values(#{name},#{nameZh})")
    int insert(Role role);

    @Update("update role set name=#{name},nameZh=#{nameZh} where id=#{id}")
    int update(Role role);

    @Delete("delete from role where id=#{id}")
    int deleteById(Integer id);
}