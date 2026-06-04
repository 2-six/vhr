package com.example.vhr.controller;

import com.example.vhr.entity.Position;
import com.example.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping("/list")
    public List<Position> list() {
        return positionService.getAllPos();
    }

    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody Position pos) {
        Map<String, Object> map = new HashMap<>();
        int rows = positionService.addPos(pos);
        if (rows > 0) {
            map.put("code", 200);
            map.put("msg", "添加成功");
        } else {
            map.put("code", 500);
            map.put("msg", "添加失败");
        }
        return map;
    }

    @PutMapping("/update")
    public Map<String, Object> update(@RequestBody Position pos) {
        Map<String, Object> map = new HashMap<>();
        int rows = positionService.updatePos(pos);
        if (rows > 0) {
            map.put("code", 200);
            map.put("msg", "修改成功");
        } else {
            map.put("code", 500);
            map.put("msg", "修改失败");
        }
        return map;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> delete(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        int rows = positionService.deleteById(id);
        if (rows > 0) {
            map.put("code", 200);
            map.put("msg", "删除成功");
        } else {
            map.put("code", 500);
            map.put("msg", "删除失败");
        }
        return map;
    }

    @DeleteMapping("/batch")
    public Map<String, Object> batchDel(@RequestBody Integer[] ids) {
        Map<String, Object> map = new HashMap<>();
        int rows = positionService.deleteBatch(ids);
        if (rows > 0) {
            map.put("code", 200);
            map.put("msg", "批量删除成功");
        } else {
            map.put("code", 500);
            map.put("msg", "批量删除失败");
        }
        return map;
    }
}