package com.msb.dao.impl;

import com.msb.dao.BaseDao;
import com.msb.dao.DeptDao;
import com.msb.pojo.Dept;
import com.msb.pojo.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl extends BaseDao implements DeptDao {

    @Override
    public List<Dept> findAll() {
            String sql = "select * from dept";
            return baseQuery(Dept.class, sql);
    }

    @Override
    public int addDept(Dept dept) {
        String sql = "insert into dept values(?, ?, ?)";
        return baseUpdate(sql, dept.getDeptno(), dept.getDname(), dept.getLoc());
    }
}
