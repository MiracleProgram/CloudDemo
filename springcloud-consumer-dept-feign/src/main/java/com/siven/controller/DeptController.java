package com.siven.controller;

import com.siven.pojo.Dept;
import com.siven.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {
    //我们应该通过服务名去调用提供者
  /*
    @Autowired
    RestTemplate restTemplate;
    */
    @Autowired
    DeptClientService deptClientService;
    /**
     * public<T> T getForObject(URI url,class<T> responseType)
     *
     * (String url,Class<T> responseType,Map<String,?> uriVarivables)
     *
     * url: http://localhost:8081/dept/get/list,List.class
     *
     */

    @RequestMapping("/con/dept/get/list")
    public List<Dept> list(){
        return deptClientService.list();
    }

    @RequestMapping("/con/dept/get/{id}")
    public Dept findById(@PathVariable("id") Long id){
        return deptClientService.get(id);
    }

    @RequestMapping("/con/dept/post/add")
    public Boolean dept_add(@RequestBody Dept dept){
        return deptClientService.add(dept);
    }
}
