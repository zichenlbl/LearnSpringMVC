package com.zichen.web;

import com.zichen.config.SpringConfiguration;
import com.zichen.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zc
 * @date 2021-08-29 17:54
 */
public class UserController {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = app.getBean(UserService.class);
        UserService userService1 = app.getBean(UserService.class);
        System.out.println(userService);
        // 测试 @Scope("prototype") 多例
        System.out.println(userService1);
        userService.test();
        // 单例可以手动销毁 多例执行垃圾回收机制
        app.close();
    }

}
