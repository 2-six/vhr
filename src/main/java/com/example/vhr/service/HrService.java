package com.example.vhr.service;

import com.example.vhr.entity.Hr;
import com.example.vhr.mapper.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HrService {

    @Autowired
    private HrMapper hrMapper;

    // 给 MenuController 使用
    public Hr getHrByUsername(String username) {
        return hrMapper.getHrByUsername(username);
    }

    public void updateHr(Hr hr) {
        hrMapper.updateHr(hr);
    }

    public void addHr(Hr hr) {
        hrMapper.addHr(hr);
    }

    public List<Hr> getAllHr() {
        return hrMapper.getAllHr();
    }

    public void deleteHr(Integer id) {
        hrMapper.deleteHr(id);
    }
}