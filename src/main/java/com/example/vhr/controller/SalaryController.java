package com.example.vhr.controller;

import com.example.vhr.entity.Salary;
import com.example.vhr.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/salary")
@RequiredArgsConstructor
public class SalaryController {
    private final SalaryService salaryService;

    @GetMapping
    public List<Salary> getAll() {
        return salaryService.getAll();
    }

    @PostMapping
    public Map<String, Object> add(@RequestBody Salary salary) {
        salaryService.add(salary);
        return Map.of("code", 200, "msg", "添加薪资成功");
    }

    @PutMapping
    public Map<String, Object> update(@RequestBody Salary salary) {
        salaryService.update(salary);
        return Map.of("code", 200, "msg", "修改薪资成功");
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Integer id) {
        salaryService.delete(id);
        return Map.of("code", 200, "msg", "删除薪资成功");
    }

    @GetMapping("/employee/{employeeId}")
    public Salary getByEmp(@PathVariable Integer employeeId) {
        return salaryService.getByEmpId(employeeId);
    }
}