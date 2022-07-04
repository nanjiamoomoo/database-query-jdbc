package com.msb.dao;

import com.msb.pojo.Dept;

import java.util.List;

public interface DeptDao {
    List<Dept> findAll();

    int addDept(Dept dept);
}
