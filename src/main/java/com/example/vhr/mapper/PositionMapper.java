package com.example.vhr.mapper;

import com.example.vhr.entity.Position;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface PositionMapper {

    @Select("select * from `position`")
    List<Position> getAllPositions();

    @Insert("insert into `position`(name) values(#{name})")
    int addPosition(Position position);

    @Update("update `position` set name=#{name} where id=#{id}")
    int updatePosition(Position position);

    @Delete("delete from `position` where id=#{id}")
    int deletePosition(Integer id);
}