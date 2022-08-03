package com.project.dao.impl;

import com.project.dao.BaseDao;
import com.project.dao.DeptDao;
import com.project.pojo.Dept;

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
