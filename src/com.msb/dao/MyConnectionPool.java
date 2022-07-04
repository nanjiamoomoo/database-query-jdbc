package com.msb.dao;

import com.msb.util.PropertiesUtil;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyConnectionPool {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private static int initSize;
    private static int maxSize;
    private static Logger logger;

    private static LinkedList<Connection> pool;


    static {
        logger = Logger.getLogger(MyConnectionPool.class);
        PropertiesUtil propertiesUtil = new PropertiesUtil("/jdbc.properties");
        driver = propertiesUtil.getProperties("driver");
        url = propertiesUtil.getProperties("url");
        user = propertiesUtil.getProperties("user");
        password = propertiesUtil.getProperties("password");
        initSize = Integer.parseInt(propertiesUtil.getProperties("initSize"));
        maxSize = Integer.parseInt(propertiesUtil.getProperties("maxSize"));
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            logger.fatal("Cannot Find DataBase Driver Class" + driver, e);
        }

        pool = new LinkedList<>();
        //create 5 connection objects
        for (int i = 0; i < initSize; i++) {
            Connection connection = initConnection();
            if (connection != null) {
                pool.add(connection);
                logger.info("Initial Connection " + connection.hashCode() + " is added in the pool");
            }
        }
    }

    private static Connection initConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            logger.fatal("Initialize Connection Exception", e);
        }
        return null;
    }

    //provide connection object to caller
    public static Connection getConnection() {
        Connection connection = null;
        if (pool.size() > 0) {
            connection = pool.removeFirst();
            logger.info("Obtained one connection from pool: " + connection.hashCode());
        } else {
            connection = initConnection();
            logger.info("pool is empty, generated new connection: " + connection.hashCode());
        }
        return connection;
    }

    //return connection
    public static void returnConnection(Connection connection) {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    if (pool.size() < maxSize) {
                        try {
                            connection.setAutoCommit(true);
                            logger.debug("connection " + connection.hashCode() + " is set to autoCommit");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        pool.addLast(connection);
                        logger.info("Connection "+ connection.hashCode() + " is returned successfully");
                    } else {
                        try {
                            connection.close();
                            logger.info("pool is full, connection closed");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    logger.info("connection " + connection.hashCode() +" has been closed, no need to close again");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            logger.warn("connection is null, unable to return");
        }
    }
}
