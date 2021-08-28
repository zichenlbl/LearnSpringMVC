package com.zichen.dao.impl;

import com.zichen.dao.UserDao;
import com.zichen.entity.User;

import java.util.Map;

/**
 * @author zc
 * @date 2021-08-27 15:25
 */
public class UserDaoImpl implements UserDao {
    private Map<String, User> userMap;

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void test() {
        System.out.println(userMap);
        System.out.println("test...");
    }
    public void init() {
        System.out.println("初始化...");
    }
    public void destory() {
        System.out.println("销毁...");
    }
}
