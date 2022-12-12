package com.siven.dao;

import com.siven.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {
    boolean add(Dept dept);
    Dept findById(Long deptNo);
    List<Dept> findAll();
}
