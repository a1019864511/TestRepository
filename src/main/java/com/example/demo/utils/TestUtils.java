package com.example.demo.utils;

import java.sql.*;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/4/8
 */
public class TestUtils {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;
    private final static String DB_URL = "jdbc:sqlserver://192.168.11.7:1433;DatabaseName=EMHR2011";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "ask-yiyang-2011";


    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            System.out.println("加载驱动失败!");
            e.printStackTrace();
        }
        return connection;
    }


    /**
     * 关闭数据库
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public static void close(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet) {
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
