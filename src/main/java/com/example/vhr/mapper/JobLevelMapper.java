package com.example.vhr.mapper;

import com.example.vhr.entity.JobLevel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface JobLevelMapper {

    @Select("select * from job_level order by create_time desc")
    List<JobLevel> getAll();

    @Insert("insert into job_level(name, title_level) values(#{name}, #{titleLevel})")
    int add(JobLevel jobLevel);

    @Update("update job_level set name=#{name}, title_level=#{titleLevel} where id=#{id}")
    int update(JobLevel jobLevel);

    @Delete("delete from job_level where id=#{id}")
    int delete(Integer id);

    @Select("select count(*) from job_level where name=#{name}")
    int countByName(String name);
}