package com.project.views;

import com.project.dao.DeptDao;
import com.project.dao.EmpDao;
import com.project.dao.impl.DeptDaoImpl;
import com.project.dao.impl.EmpDaoImpl;
import com.project.pojo.Dept;
import com.project.pojo.Emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmpManageSystem {
    private static Scanner sc = new Scanner(System.in);
    private static EmpDao empDao = new EmpDaoImpl();;
    private static DeptDao deptDao = new DeptDaoImpl();
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        o: while (true) {
            showMenu();
            System.out.println("Please enter your option: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    case1();
                    break;
                case 2:
                    case2();
                    break;
                case 3:
                    case3();
                    break;
                case 4:
                    case4();
                    break;
                case 5:
                    case5();
                    break;
                case 6:
                    case6();
                    break;
                case 7:
                    break o;
                default:
                    System.out.println("Please enter collection option");
            }
        }
        sc.close();
    }

    private static void case1() {
        List<Emp> all = empDao.findAll();
        all.forEach(System.out::println);
    }

    private static void case2() {
        List<Dept> deptAll = deptDao.findAll();
        deptAll.forEach(System.out::println);
    }

    private static void case3() {
        System.out.println("Please enter the employee number you want to delete:");
        int empno = sc.nextInt();
        empDao.deleteByEmpno(empno);
    }

    private static void case4() {
        System.out.println("Please enter employee number:");
        int empno = sc.nextInt();
        System.out.println("Please enter employee name:");
        String ename = sc.next();
        System.out.println("Please enter employee job:");
        String job = sc.next();
        System.out.println("Please enter employee manager:");
        int mgr = sc.nextInt();
        System.out.println("Please enter employee hire date,format is yyyy-MM-dd:");
        Date hiredate = null;
        try {
            hiredate = simpleDateFormat.parse(sc.next());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Please enter employee salary:");
        double sal = sc.nextDouble();
        System.out.println("Please enter employee commissions:");
        double comm = sc.nextDouble();
        System.out.println("Please enter employee department number:");
        int deptno = sc.nextInt();
        Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
        empDao.updateEmp(emp);
    }

    private static void case5() {
        System.out.println("Please enter employee name:");
        String ename = sc.next();
        System.out.println("Please enter employee job:");
        String job = sc.next();
        System.out.println("Please enter employee manager:");
        int mgr = sc.nextInt();
        System.out.println("Please enter employee hire date,format is yyyy-MM-dd:");
        Date hiredate = null;
        try {
            hiredate = simpleDateFormat.parse(sc.next());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Please enter employee salary:");
        double sal = sc.nextDouble();
        System.out.println("Please enter employee commissions:");
        double comm = sc.nextDouble();
        System.out.println("Please enter employee department number:");
        int deptno = sc.nextInt();
        Emp emp = new Emp(null, ename, job, mgr, hiredate, sal, comm, deptno);
        empDao.addEmp(emp);
    }

    private static void case6() {
        System.out.println("Please enter department number:");
        Integer deptno = sc.nextInt();
        System.out.println("Please enter department name:");
        String dname = sc.next();
        System.out.println("Please enter department address:");
        String loc = sc.next();
        Dept dept = new Dept(deptno, dname, loc);
        deptDao.addDept(dept);
    }


    public static void showMenu() {
        System.out.println("*********************************************");
        System.out.println("* 1. Check all employee information");
        System.out.println("* 2. Check all department information");
        System.out.println("* 3. Delete employee based on employee number");
        System.out.println("* 4. Modify employee information");
        System.out.println("* 5. Add new employee");
        System.out.println("* 6. Add new department");
        System.out.println("* 7. Exit");
        System.out.println("*********************************************");
    }
}
