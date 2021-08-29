package com.zichen.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
 * @author zc
 * @date 2021-08-28 17:49
 */
public class DataSourceTest {

    /**
     * spring配置连接数据库
     */
    @Test
    public void test() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = app.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    /**
     * 通过配置文件连接数据库
     */
    @Test
    public void test01() throws PropertyVetoException, SQLException {
        // 读取配置文件
        ResourceBundle jdbc = ResourceBundle.getBundle("jdbc");
        String driver = jdbc.getString("jdbc.driver");
        String url = jdbc.getString("jdbc.url");
        String username = jdbc.getString("jdbc.username");
        String password = jdbc.getString("jdbc.password");
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }

    /**
     * d3p0连接数据库
     */
    @Test
    public void test02() throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///zichen?serverTimezone=Asia/Shanghai");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }

    /**
     * druid连接数据库
     */
    @Test
    public void test03() throws SQLException {
        final DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/zichen?serverTimezone=Asia/Shanghai");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        final DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
