package com.example.vhr.controller;

import com.example.vhr.entity.Position;
import com.example.vhr.service.PositionService;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {

    @Resource
    private PositionService positionService;

    @GetMapping("/")
    public List<Position> getAll() {
        return positionService.getAllPositions();
    }

    @PostMapping("/")
    public String add(@RequestBody Position position) {
        if (positionService.addPosition(position) > 0) {
            return "添加成功";
        }
        return "添加失败";
    }

    @PutMapping("/")
    public String update(@RequestBody Position position) {
        if (positionService.updatePosition(position) > 0) {
            return "修改成功";
        }
        return "修改失败";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        if (positionService.deletePosition(id) > 0) {
            return "删除成功";
        }
        return "删除失败";
    }
}