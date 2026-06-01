package com.example.vhr.service.impl;

import com.example.vhr.entity.Position;
import com.example.vhr.mapper.PositionMapper;
import com.example.vhr.service.PositionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

// 必须加 @Service！！！
@Service
public class PositionServiceImpl implements PositionService {

    @Resource
    private PositionMapper positionMapper;

    @Override
    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }

    @Override
    public int addPosition(Position position) {
        return positionMapper.addPosition(position);
    }

    @Override
    public int updatePosition(Position position) {
        return positionMapper.updatePosition(position);
    }

    @Override
    public int deletePosition(Integer id) {
        return positionMapper.deletePosition(id);
    }
}