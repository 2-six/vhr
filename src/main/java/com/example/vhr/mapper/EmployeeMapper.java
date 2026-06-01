package com.example.vhr.mapper;

import com.example.vhr.entity.Employee;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface EmployeeMapper {

    // 分页查询员工（关联三张表）
    @Select("SELECT e.*,d.name deptName,j.name levelName,p.name posName " +
            "FROM employee e " +
            "LEFT JOIN department d ON e.department_id = d.id " +
            "LEFT JOIN job_level j ON e.job_level_id = j.id " +
            "LEFT JOIN `position` p ON e.position_id = p.id " +
            "LIMIT #{start}, #{pageSize}")
    List<Employee> getEmpByPage(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    // 总条数
    @Select("SELECT count(*) FROM employee")
    int getTotal();

    @Insert("INSERT INTO employee(name,gender,birth_date,id_card,wedlock,nation,native_place," +
            "politic,email,phone,address,department_id,job_level_id,position_id) " +
            "VALUES(#{name},#{gender},#{birthDate},#{idCard},#{wedlock},#{nation},#{nativePlace}," +
            "#{politic},#{email},#{phone},#{address},#{departmentId},#{jobLevelId},#{positionId})")
    int addEmp(Employee employee);

    @Update("UPDATE employee SET name=#{name},gender=#{gender},birth_date=#{birthDate},id_card=#{idCard}," +
            "wedlock=#{wedlock},nation=#{nation},native_place=#{nativePlace},politic=#{politic}," +
            "email=#{email},phone=#{phone},address=#{address},department_id=#{departmentId}," +
            "job_level_id=#{jobLevelId},position_id=#{positionId} WHERE id=#{id}")
    int updateEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE id=#{id}")
    int deleteEmp(Integer id);
}