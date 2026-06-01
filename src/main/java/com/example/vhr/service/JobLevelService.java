package com.example.vhr.service;

import com.example.vhr.entity.JobLevel;
import com.example.vhr.mapper.JobLevelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobLevelService {

    private final JobLevelMapper jobLevelMapper;

    public List<JobLevel> getAll() {
        return jobLevelMapper.getAll();
    }

    @Transactional
    public int add(JobLevel jobLevel) {
        if (jobLevelMapper.countByName(jobLevel.getName()) > 0) {
            throw new RuntimeException("职称名称已存在");
        }
        return jobLevelMapper.add(jobLevel);
    }

    @Transactional
    public int update(JobLevel jobLevel) {
        return jobLevelMapper.update(jobLevel);
    }

    @Transactional
    public int delete(Integer id) {
        return jobLevelMapper.delete(id);
    }
}