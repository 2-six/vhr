package com.example.vhr.service;

import com.example.vhr.entity.Department;
import com.example.vhr.mapper.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentMapper departmentMapper;

    // 获取树形部门
    public List<Department> getTree() {
        List<Department> list = departmentMapper.getAllDepartments();

        return list.stream()
                .filter(d -> d.getParentId() == null || d.getParentId() == 0)
                .peek(d -> d.setChildren(getChildren(d, list)))
                .collect(Collectors.toList());
    }

    // 递归获取子部门
    private List<Department> getChildren(Department parent, List<Department> list) {
        return list.stream()
                .filter(d -> parent.getId().equals(d.getParentId()))
                .peek(d -> d.setChildren(getChildren(d, list)))
                .collect(Collectors.toList());
    }

    public int add(Department dept) {
        return departmentMapper.addDept(dept);
    }

    public int update(Department dept) {
        return departmentMapper.updateDept(dept);
    }

    public int delete(Integer id) {
        return departmentMapper.deleteDept(id);
    }
}