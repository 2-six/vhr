package com.example.vhr.service;

import com.example.vhr.entity.Employee;
import com.example.vhr.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeMapper employeeMapper;

    // 分页查询
    public Map<String, Object> getEmpPage(Integer page, Integer pageSize) {
        int start = (page - 1) * pageSize;
        List<Employee> list = employeeMapper.getEmpByPage(start, pageSize);
        int total = employeeMapper.getTotal();
        Map<String, Object> result = new HashMap<>();
        result.put("data", list);
        result.put("total", total);
        return result;
    }

    @Transactional
    public int add(Employee employee) {
        return employeeMapper.addEmp(employee);
    }

    @Transactional
    public int update(Employee employee) {
        return employeeMapper.updateEmp(employee);
    }

    @Transactional
    public int delete(Integer id) {
        return employeeMapper.deleteEmp(id);
    }
}