package com.example.vhr.service;

import com.example.vhr.entity.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary  // 必须加，告诉Spring这是唯一的认证类
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private HrService hrService;  // 注入上面的 HrService

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrService.getHrByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return hr;
    }
}