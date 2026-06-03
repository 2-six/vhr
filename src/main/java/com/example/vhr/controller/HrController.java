package com.example.vhr.controller;

import com.example.vhr.entity.Hr;
import com.example.vhr.service.HrService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hr")
@RequiredArgsConstructor
public class HrController {
    private final HrService hrService;

    // 查询全部管理员
    @GetMapping
    public List<Hr> getAllHr(){
        return hrService.getAllHr();
    }
    // 新增管理员
    @PostMapping
    public Map<String,Object> addHr(@RequestBody Hr hr){
        hrService.addHr(hr);
        return Map.of("code",200,"msg","新增管理员成功");
    }
    // 修改管理员
    @PutMapping
    public Map<String,Object> updateHr(@RequestBody Hr hr){
        hrService.updateHr(hr);
        return Map.of("code",200,"msg","修改管理员成功");
    }
    // 删除管理员
    @DeleteMapping("/{id}")
    public Map<String,Object> deleteHr(@PathVariable Integer id){
        hrService.deleteHr(id);
        return Map.of("code",200,"msg","删除管理员成功");
    }
}