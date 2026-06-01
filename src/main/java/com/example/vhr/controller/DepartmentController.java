package com.example.vhr.controller;

import com.example.vhr.entity.Department;
import com.example.vhr.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    // 获取树形部门
    @GetMapping("/tree")
    public List<Department> getTree() {
        return departmentService.getTree();
    }

    @PostMapping
    public Map<String, Object> add(@RequestBody Department dept) {
        departmentService.add(dept);
        return Map.of("code",200,"msg","添加成功");
    }

    @PutMapping
    public Map<String, Object> update(@RequestBody Department dept) {
        departmentService.update(dept);
        return Map.of("code",200,"msg","修改成功");
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Integer id) {
        departmentService.delete(id);
        return Map.of("code",200,"msg","删除成功");
    }
}