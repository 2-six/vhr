package com.example.vhr.service;

import com.example.vhr.entity.Hr;
import com.example.vhr.mapper.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HrService implements UserDetailsService {

    @Autowired
    private HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.getHrByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return hr;
    }

    // 给 MenuController 使用
    public Hr getHrByUsername(String username) {
        return hrMapper.getHrByUsername(username);
    }
}