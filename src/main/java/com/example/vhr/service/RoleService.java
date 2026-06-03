package com.example.vhr.service;

import com.example.vhr.entity.Role;
import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    void addRole(Role role);
    void updateRole(Role role);
    void deleteRole(Integer rid);
    void assignMenu(Integer rid, List<Integer> mids);
    List<Integer> getMenuIdsByRid(Integer rid);
}