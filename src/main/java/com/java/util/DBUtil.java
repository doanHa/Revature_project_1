package com.java.util;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import java.sql.*;

public class DBUtil {
    private static BasicDataSource connectionPool = new BasicDataSource();

    static {
            connectionPool.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            connectionPool.setUrl("jdbc:oracle:thin:@project1.ckcej44l8ngn.us-east-2.rds.amazonaws.com:1521:ORCL");
            connectionPool.setUsername("doanAdmin");
            connectionPool.setPassword("Minhdoan2210!");
            connectionPool.setMaxTotal(100);
            connectionPool.setDefaultAutoCommit(false);
    }

    public static Connection getInstance() {

        try {
            return connectionPool.getConnection();
        } catch (SQLException e) {
            System.out.println("Unable to connect, please try again later");
        }
        return null;
    }
}