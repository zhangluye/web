package com.syxy.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//数据库基础操作类
public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //静态代码块，在类加载的时候就初始化
    static {
        Properties properties = new Properties();
        //通过类加载读取相应资源
        InputStream resourceAsStream = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");

    }

    //获取数据库连接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    //编写查询公共方法
    public static ResultSet execute(Connection connection, String sql,Object[] params,ResultSet resultSet,PreparedStatement preparedStatement) throws SQLException {
        //预编译的sql，在后面直接执行就可以了
        preparedStatement = connection.prepareStatement(sql);

        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                //setObject 占位符从1开始；数组从零开始；
                preparedStatement.setObject(i + 1, params[i]);
            }
        }

        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    //编写增删改公共方法
    public static int execute(Connection connection,String sql,Object[] params,PreparedStatement preparedStatement) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            //setObject,占位符从1开始，但是我们的数组是从0开始！
            preparedStatement.setObject(i+1,params[i]);
        }

        int updateRows = preparedStatement.executeUpdate();
        return updateRows;
    }

    //close释放资源
    public static boolean closeResource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        boolean flag = true;

        if (resultSet!=null){
            try {
                resultSet.close();
                //GC回收
                resultSet = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }

        if (preparedStatement!=null){
            try {
                preparedStatement.close();
                //GC回收
                preparedStatement = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }

        if (connection!=null){
            try {
                connection.close();
                //GC回收
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }

}
