package com.example.vhr.service;

import com.example.vhr.entity.Hr;
import com.example.vhr.mapper.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HrService {  // 这里删掉 implements UserDetailsService

    @Autowired
    private HrMapper hrMapper;

    // 给 MenuController 使用
    public Hr getHrByUsername(String username) {
        return hrMapper.getHrByUsername(username);
    }
}