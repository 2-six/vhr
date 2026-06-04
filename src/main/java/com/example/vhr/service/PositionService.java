package com.example.vhr.service;

import com.example.vhr.entity.Position;
import java.util.List;

public interface PositionService {
    List<Position> getAllPos();
    int addPos(Position pos);
    int updatePos(Position pos);
    int deleteById(Integer id);
    int deleteBatch(Integer[] ids);
}