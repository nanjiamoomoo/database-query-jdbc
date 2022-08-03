package com.project.dao.impl;

import com.project.dao.BaseDao;
import com.project.dao.EmpDao;
import com.project.pojo.Emp;

import java.util.List;

public class EmpDaoImpl extends BaseDao implements EmpDao {

    @Override
    public int addEmp(Emp emp) {
        String sql = "insert into emp values(DEFAULT, ?, ?, ?, ?, ?, ?, ?)";
        return baseUpdate(sql, emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(), emp.getSal(), emp.getComm(), emp.getDeptno());
    }

    @Override
    public int deleteByEmpno(int empno) {
        String sql = "delete from emp where empno = ?";
        return baseUpdate(sql, empno);
    }

    @Override
    public List<Emp> findAll() {
        String sql = "select * from emp";
        return baseQuery(Emp.class, sql);
    }

    @Override
    public int updateEmp(Emp emp) {

        String sql = "update emp set ename = ?, job = ?, mgr = ?, hiredate = ?, sal = ?, comm =?, deptno = ? where empno = ?";
        return baseUpdate(sql, emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(), emp.getSal(), emp.getComm(), emp.getDeptno(), emp.getEmpno());
    }

}
