package com.example.vhr.mapper;

import com.example.vhr.entity.Department;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface DepartmentMapper {

    @Select("SELECT id,name,parent_id,is_parent,enabled FROM department WHERE enabled=1")
    List<Department> getAllDepartments();

    // 关键：补上 enabled，默认设为1
    @Insert("INSERT INTO department(name,parent_id,is_parent,enabled) " +
            "VALUES(#{name},#{parentId},#{isParent},1)")
    int addDept(Department dept);

    @Update("UPDATE department SET name=#{name} WHERE id=#{id}")
    int updateDept(Department dept);

    @Delete("DELETE FROM department WHERE id=#{id}")
    int deleteDept(Integer id);
}