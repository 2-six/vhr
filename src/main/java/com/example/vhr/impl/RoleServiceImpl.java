package com.example.vhr.service.impl;

import com.example.vhr.entity.Role;
import com.example.vhr.mapper.RoleMapper;
import com.example.vhr.mapper.RoleMenuMapper;
import com.example.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleMenuMapper roleMenuMapper;

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.selectAll();
    }

    @Override
    public void addRole(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.update(role);
    }

    @Override
    @Transactional
    public void deleteRole(Integer rid) {
        roleMenuMapper.deleteByRid(rid);
        roleMapper.deleteById(rid);
    }

    @Override
    @Transactional
    public void assignMenu(Integer rid, List<Integer> mids) {
        roleMenuMapper.deleteByRid(rid);
        if (mids != null && !mids.isEmpty()) {
            roleMenuMapper.insertBatch(rid, mids);
        }
    }

    @Override
    public List<Integer> getMenuIdsByRid(Integer rid) {
        return roleMenuMapper.selectMenuIdsByRid(rid);
    }
}