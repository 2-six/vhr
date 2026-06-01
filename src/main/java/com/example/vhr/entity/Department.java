package com.example.vhr.entity;

import lombok.Data;
import java.util.List;

@Data
public class Department {
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer isParent;
    private Integer enabled;

    // 子部门（树形结构）
    private List<Department> children;
}