package com.example.vhr.mapper;

import com.example.vhr.entity.Hr;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface HrMapper {

    @Select("select * from hr where username=#{username}")
    Hr getHrByUsername(String username);

    @Insert("insert into hr(username,password,name,phone,address,enabled) " +
            "values(#{username},#{password},#{name},#{phone},#{address},#{enabled})")
    void addHr(Hr hr);

    @Update("update hr set username=#{username},name=#{name},phone=#{phone},address=#{address} where id=#{id}")
    void updateHr(Hr hr);

    @Delete("delete from hr where id=#{id}")
    void deleteHr(Integer id);

    @Select("select * from hr")
    List<Hr> getAllHr();
}