package com.example.vhr.service;

import com.example.vhr.entity.Salary;
import com.example.vhr.mapper.SalaryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryService {
    private final SalaryMapper salaryMapper;

    public List<Salary> getAll() {
        return salaryMapper.getAllSalaries();
    }

    public void add(Salary salary) {
        salaryMapper.addSalary(salary);
    }

    public void update(Salary salary) {
        salaryMapper.updateSalary(salary);
    }

    public void delete(Integer id) {
        salaryMapper.deleteSalary(id);
    }

    public Salary getByEmpId(Integer employeeId) {
        return salaryMapper.getByEmployeeId(employeeId);
    }
}