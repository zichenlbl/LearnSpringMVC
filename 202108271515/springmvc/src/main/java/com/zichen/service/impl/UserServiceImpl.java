package com.zichen.service.impl;

import com.zichen.dao.UserDao;
import com.zichen.service.UserService;

/**
 * 在类中注入其他类
 * @author zc
 * @date 2021-08-27 17:17
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void test() {
        userDao.test();
    }
}
