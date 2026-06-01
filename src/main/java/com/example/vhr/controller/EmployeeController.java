package com.example.vhr.controller;

import com.example.vhr.entity.Employee;
import com.example.vhr.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // 分页查询
    @GetMapping
    public Map<String, Object> getEmpPage(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer pageSize) {
        return employeeService.getEmpPage(page, pageSize);
    }

    // 新增员工
    @PostMapping
    public Map<String, Object> add(@RequestBody Employee employee) {
        employeeService.add(employee);
        return Map.of("code", 200, "msg", "新增员工成功");
    }

    // 修改员工
    @PutMapping
    public Map<String, Object> update(@RequestBody Employee employee) {
        employeeService.update(employee);
        return Map.of("code", 200, "msg", "修改员工成功");
    }

    // 删除员工
    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Integer id) {
        employeeService.delete(id);
        return Map.of("code", 200, "msg", "删除员工成功");
    }
}