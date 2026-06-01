package com.example.vhr.controller;

import com.example.vhr.entity.JobLevel;
import com.example.vhr.service.JobLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/joblevel")
@RequiredArgsConstructor
public class JobLevelController {

    private final JobLevelService jobLevelService;

    @GetMapping
    public List<JobLevel> getAll() {
        return jobLevelService.getAll();
    }

    @PostMapping
    public Map<String, Object> add(@RequestBody JobLevel jobLevel) {
        try {
            jobLevelService.add(jobLevel);
            return Map.of("code", 200, "msg", "添加成功");
        } catch (Exception e) {
            return Map.of("code", 500, "msg", e.getMessage());
        }
    }

    @PutMapping
    public Map<String, Object> update(@RequestBody JobLevel jobLevel) {
        jobLevelService.update(jobLevel);
        return Map.of("code", 200, "msg", "修改成功");
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Integer id) {
        jobLevelService.delete(id);
        return Map.of("code", 200, "msg", "删除成功");
    }
}