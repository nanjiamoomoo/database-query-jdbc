package com.project.test;

import com.project.dao.MyConnectionPool;

import java.sql.Connection;

public class ConnectionPoolTest {
    public static void main(String[] args) {
        Connection connection1 = MyConnectionPool.getConnection();
        Connection connection2 = MyConnectionPool.getConnection();
        Connection connection3 = MyConnectionPool.getConnection();
        Connection connection4 = MyConnectionPool.getConnection();
        Connection connection5 = MyConnectionPool.getConnection();
        Connection connection6 = MyConnectionPool.getConnection();
        Connection connection7 = MyConnectionPool.getConnection();
        Connection connection8 = MyConnectionPool.getConnection();
        Connection connection9 = MyConnectionPool.getConnection();
        Connection connection10 = MyConnectionPool.getConnection();
        Connection connection11 = MyConnectionPool.getConnection();

        MyConnectionPool.returnConnection(connection1);
        MyConnectionPool.returnConnection(connection2);
        MyConnectionPool.returnConnection(connection3);
        MyConnectionPool.returnConnection(connection4);
        MyConnectionPool.returnConnection(connection5);
        MyConnectionPool.returnConnection(connection6);
        MyConnectionPool.returnConnection(connection7);
        MyConnectionPool.returnConnection(connection8);
        MyConnectionPool.returnConnection(connection9);
        MyConnectionPool.returnConnection(connection10);
        MyConnectionPool.returnConnection(connection11);
    }

}
