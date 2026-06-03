package com.example.vhr.mapper;

import com.example.vhr.entity.Salary;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface SalaryMapper {

    @Select("SELECT * FROM salary")
    List<Salary> getAllSalaries();

    @Insert("INSERT INTO salary(employee_id,base_salary,bonus,deduction,real_salary) " +
            "VALUES(#{employeeId},#{baseSalary},#{bonus},#{deduction},#{realSalary})")
    int addSalary(Salary salary);

    @Update("UPDATE salary SET base_salary=#{baseSalary},bonus=#{bonus},deduction=#{deduction},real_salary=#{realSalary} WHERE id=#{id}")
    int updateSalary(Salary salary);

    @Delete("DELETE FROM salary WHERE id=#{id}")
    int deleteSalary(Integer id);

    @Select("SELECT * FROM salary WHERE employee_id=#{employeeId}")
    Salary getByEmployeeId(Integer employeeId);
}