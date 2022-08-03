package com.project.dao;

import com.project.pojo.Dept;

import java.util.List;

public interface DeptDao {
    /**
     * read all department information from the table
     * @return all the department info are added to the list
     */
    List<Dept> findAll();

    /**
     * Add a record into Dept table
     * @param dept the data is encapsulated as dept object
     * @return > 0 if success, or return 0
     */
    int addDept(Dept dept);
}
