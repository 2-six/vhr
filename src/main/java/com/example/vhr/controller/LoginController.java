package com.example.vhr.controller;

import com.example.vhr.entity.LoginParam;
import com.example.vhr.entity.RespBean;
import com.example.vhr.utils.JwtUtil;  // 等下我给你这个类
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
    private final JwtUtil jwtUtil;  // 加了 JWT 工具

    // 构造函数注入
    public LoginController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public RespBean login(@RequestBody LoginParam param) {
        try {
            // 1. 验证账号密码
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(param.getUsername(), param.getPassword())
            );

            // 2. 生成 Token（关键！）
            String token = jwtUtil.generateToken(param.getUsername());

            // 3. 返回 Token 给前端
            return RespBean.success("登录成功", token);

        } catch (AuthenticationException e) {
            return RespBean.error("用户名或密码错误");
        }
    }
}