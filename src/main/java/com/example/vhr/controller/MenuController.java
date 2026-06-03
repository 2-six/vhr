package com.example.vhr.controller;

import com.example.vhr.entity.Hr;
import com.example.vhr.entity.Menu;
import com.example.vhr.utils.RespBean;
import com.example.vhr.service.MenuService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menu")
    public RespBean getMenus(Authentication authentication) {
        // 这里拿到的是 Hr，不是 Integer！
        Hr hr = (Hr) authentication.getPrincipal();

        // 调用你真实的方法
        List<Menu> menus = menuService.getMenusByUserId(hr.getId());

        return RespBean.success("菜单获取成功", menus);
    }
}