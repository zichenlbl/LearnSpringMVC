package com.zichen.test;

import com.zichen.dao.UserDao;
import com.zichen.dao.impl.UserDaoImpl;
import com.zichen.entity.User;
import com.zichen.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author zc
 * @date 2021-08-27 15:45
 */
public class SpringTest {

    @Test
    public void test() {
        // 根路径下加载配置文件
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 磁盘路径下加载配置文件 不常用
//        app = new FileSystemXmlApplicationContext("F:\\study\\SpringMVC\\202108271515\\springmvc\\src\\main\\resources\\applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        userDao.test();
        // 配置文件中 bean 配值 scope="singleton"， 地址一样 spring 中 bean 存在一个, 加载配置文件时创建
        // 配置文件中 bean 配值 scope="prototype"， 地址不一样 spring 中 bean 存在多个， 调用getBean方法时创建
        System.out.println(userDao);
        System.out.println(userDao1);
        // 手动销毁 测试 bean 的初始化和销毁方法
//        ((ClassPathXmlApplicationContext)app).close();

        // 工厂模式静态方法测试
        UserDao userDao2 = (UserDao) app.getBean("userDao2");
        System.out.println(userDao2);

        // 工厂模式实例方法测试
        UserDao userDao3 = (UserDao) app.getBean("userDao3");
        System.out.println(userDao3);

        // 类中注入其他类
        UserService userService = (UserService) app.getBean("userService");
        userService.test();

        // 命名空间 类中注入其他类
        UserService userService1 = (UserService) app.getBean("userService1");
        userService1.test();

        // 构造方法注入类
        UserService userService2 = (UserService) app.getBean("userService2");
        userService2.test();

        // 注入属性
        System.out.println("-----------------------------");
        UserDao userDao4 = (UserDao) app.getBean("userDao4");
        userDao4.test();

        // getBean 传入字节码文件 配置文件中只能有一个相同类型的Bean
        System.out.println("-----------------------------");
        User user = app.getBean(User.class);
        System.out.println(user);
    }

}
