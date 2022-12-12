package com.siven.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long deptNo) {
        Dept dept = deptService.findById(deptNo);
        if(dept==null){
            throw new RuntimeException("id:"+deptNo+",该用户不存在，或者信息无法找到");
        }
        return dept;
    }
    /*根据id查询备选方案--熔断*/
    public Dept hystrixGet(@PathVariable("id") Long deptNo){
        return new Dept().setDeptNo(deptNo).setDname("这个id=>"+deptNo+",没有找到对应的信息").setDb_source("no this database");
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
