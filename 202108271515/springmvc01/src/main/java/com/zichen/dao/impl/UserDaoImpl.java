package com.zichen.dao.impl;

import com.zichen.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @ Component 替换bean配置 @Repository("userDao") Repository数据存储 可读性
 * <bean id="userDao" class="com.zichen.dao.impl.UserDaoImpl"/>
 * @author zc
 * @date 2021-08-29 17:48
 */
//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void test() {
        System.out.println("test...");
    }
}
