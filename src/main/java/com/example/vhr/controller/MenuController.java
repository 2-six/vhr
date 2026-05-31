package com.example.vhr.controller;

import com.example.vhr.entity.Menu;
import com.example.vhr.entity.Hr;       // 这里改：User → Hr
import com.example.vhr.service.MenuService;
import com.example.vhr.service.HrService;    // 这里改：UserService → HrService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private HrService hrService;    // 这里改：UserService → HrService

    @GetMapping("/menu")
    public List<Menu> getMenus() {
        // 获取当前登录用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // 真·从数据库 hr 表查用户
        Hr hr = hrService.getHrByUsername(username);  // 这里改：User → Hr

        // 真·从数据库查菜单
        return menuService.getMenusByUserId(hr.getId());
    }
}