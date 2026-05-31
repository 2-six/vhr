package com.example.vhr.controller;

import com.example.vhr.entity.LoginParam;
import com.example.vhr.entity.RespBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public RespBean login(@RequestBody LoginParam param) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(param.getUsername(), param.getPassword())
            );
            return RespBean.success("登录成功");
        } catch (AuthenticationException e) {
            return RespBean.error("用户名或密码错误");
        }
    }
}