package com.msb.dao;

import com.msb.pojo.Emp;

import java.util.List;

public interface EmpDao {
    /**
     * Add a record into Emp table
     * @param emp the data is encapsulated as emp object
     * @return > 0 if success, or return 0
     */
    int addEmp(Emp emp);

    /**
     * Delete a recode from emptable based on the emp number
     * @param empno empno is the unique identification of each employee
     * @return if > 0 return the affected rows, if = 0, return 0
     */
    int deleteByEmpno(int empno);

    /**
     * read all employee information from the table
     * @return all the emp info are added to the list
     */
    List<Emp> findAll();

    /**
     * update corresponding empno info based on emp object passed in
     * @param emp empno with other fields in the emp object
     * @return > 0 if success, return 0 if failed
     */
    int updateEmp(Emp emp);

    /**
     * add employee int the database based on the info in the emp object
     * @param emp all the emp info wrapped in the emp object
     * @return if success return 1, if not return 0
     */


}
