package com.example.vhr.controller;

import com.example.vhr.entity.Role;
import com.example.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Role> getAllRole() {
        return roleService.getAllRoles();
    }

    @PostMapping
    public Map<String, Object> addRole(@RequestBody Role role) {
        roleService.addRole(role);
        return Map.of("code", 200, "msg", "新增成功");
    }

    @PutMapping
    public Map<String, Object> updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
        return Map.of("code", 200, "msg", "修改成功");
    }

    @DeleteMapping("/{rid}")
    public Map<String, Object> deleteRole(@PathVariable Integer rid) {
        roleService.deleteRole(rid);
        return Map.of("code", 200, "msg", "删除成功");
    }

    @PutMapping("/menus/{rid}")
    public Map<String, Object> assignMenu(@PathVariable Integer rid, @RequestBody List<Integer> mids) {
        roleService.assignMenu(rid, mids);
        return Map.of("code", 200, "msg", "授权成功");
    }

    @GetMapping("/menus/{rid}")
    public List<Integer> getMenuIdsByRid(@PathVariable Integer rid) {
        return roleService.getMenuIdsByRid(rid);
    }
}