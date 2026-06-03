package com.example.vhr.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Salary {
    private Integer id;
    private Integer employeeId; // 关联员工
    private BigDecimal baseSalary; // 基本工资
    private BigDecimal bonus; // 奖金
    private BigDecimal deduction; // 扣款
    private BigDecimal realSalary; // 实发工资
    private LocalDateTime createTime;
}