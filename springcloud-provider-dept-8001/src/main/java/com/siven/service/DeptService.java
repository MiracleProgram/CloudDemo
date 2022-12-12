package com.siven.service;

import com.siven.pojo.Dept;

import java.util.List;

public interface DeptService {
    boolean add(Dept dept);
    Dept findById(Long deptNo);
    List<Dept> findAll();
}
