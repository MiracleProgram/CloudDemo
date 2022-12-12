package com.siven.controller;

import com.siven.pojo.Dept;
import com.siven.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    DeptService deptService;

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long deptNo) {
        return deptService.findById(deptNo);
    }
    @PostMapping("/dept/post/add")
    public Boolean post(@RequestBody Dept dept){
        return deptService.add(dept);
    }
    @GetMapping("/dept/get/list")
    public List<Dept> list() {
        return deptService.findAll();
    }
}
