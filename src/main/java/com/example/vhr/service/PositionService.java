package com.example.vhr.service;

import com.example.vhr.entity.Position;
import java.util.List;

public interface PositionService {
    List<Position> getAllPositions();
    int addPosition(Position position);
    int updatePosition(Position position);
    int deletePosition(Integer id);
}