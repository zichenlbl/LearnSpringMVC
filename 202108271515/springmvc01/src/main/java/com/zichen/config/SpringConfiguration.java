package com.zichen.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Configuration 标志该类是Spring的核心配置类
 * 核心配置
 *
 * @author zc
 * @date 2021-08-29 19:23
 */
@Configuration
//<context:component-scan base-package="com.zichen"/>
@ComponentScan("com.zichen")
// 导入其他配置类
@Import({DataSourceConfiguration.class})
////<context:property-placeholder location="classpath:jdbc.properties"/>
//@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {

    // 提取的数据源配置类
//    @Value("${jdbc.driver}")
//    private String driver;
//
//    @Value("${jdbc.url}")
//    private String url;
//
//    @Value("${jdbc.username}")
//    private String username;
//
//    @Value("${jdbc.password}")
//    private String password;
//
//    /**
//     * Spring会将当前方法的返回值以指定名称存储到Spring容器中
//     * @return DataSource
//     * @throws PropertyVetoException PropertyVetoException
//     * @throws SQLException SQLException
//     */
//    @Bean("dataSource")
//    public DataSource getDataSource() throws PropertyVetoException, SQLException {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setDriverClass(driver);
//        dataSource.setJdbcUrl(url);
//        dataSource.setUser(username);
//        dataSource.setPassword(password);
//        Connection conn = dataSource.getConnection();
//        return dataSource;
//    }

}
