package com.example.vhr.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Employee {
    private Integer id;
    private String name;
    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private String idCard;
    private String wedlock;
    private String nation;
    private String nativePlace;
    private String politic;
    private String email;
    private String phone;
    private String address;

    private Integer departmentId;
    private Integer jobLevelId;
    private Integer positionId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    // 关联外键对应实体（回显用）
    private Department department;
    private JobLevel jobLevel;
    private Position position;
}