package com.example.vhr.service.impl;

import com.example.vhr.entity.Position;
import com.example.vhr.mapper.PositionMapper;
import com.example.vhr.service.PositionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public List<Position> getAllPos() {
        return positionMapper.getAllPos();
    }

    @Override
    public int addPos(Position pos) {
        return positionMapper.addPos(pos);
    }

    @Override
    public int updatePos(Position pos) {
        return positionMapper.updatePos(pos);
    }

    @Override
    public int deleteById(Integer id) {
        return positionMapper.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return positionMapper.deleteBatch(ids);
    }
}