package com.example.vhr.mapper;

import com.example.vhr.entity.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface PositionMapper {
    List<Position> getAllPos();
    int addPos(Position pos);
    int updatePos(Position pos);
    int deleteById(Integer id);
    int deleteBatch(@Param("ids") Integer[] ids);
}