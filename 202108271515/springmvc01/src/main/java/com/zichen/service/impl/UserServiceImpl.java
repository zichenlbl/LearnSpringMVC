package com.zichen.service.impl;

import com.zichen.dao.UserDao;
import com.zichen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Autowired 自动注入对象 Qualifier("userDao") 要注入的bean的id
 * <bean id="userService" class="com.zichen.service.impl.UserServiceImpl"/>
 * Resource = Autowired + Qualifier
 * Scope("prototype") 多例， @Scope("singleton") 单例
 * Value 注入普通属性
 *
 * @author zc
 * @date 2021-08-29 17:50
 */
//@Component("userService")
@Service("userService")
// 多例
//@Scope("prototype")
// 单例
@Scope("singleton")
public class UserServiceImpl implements UserService {
    // <property name="userDao" ref="userDao"/>
//    @Autowired // 按照数据类型从spring容器中匹配 只有一个UserDao时只写Autowired
//    @Qualifier("userDao") // 按照id的值进行匹配 与Autowired一起使用
    @Resource(name = "userDao")
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    // 注入普通属性
    @Value("zichen")
    private String name;

    @Value("${jdbc.driver}")
    private String driver;

    public void test() {
        System.out.println(driver);
        System.out.println(name);
        userDao.test();
    }

    // 构造器(Construct)之后 初始化
    @PostConstruct
    public void init() {
        System.out.println("初始化...");
    }

    // 销毁(Destroy)之前 销毁
    @PreDestroy
    public void destroy() {
        System.out.println("销毁...");
    }

}

