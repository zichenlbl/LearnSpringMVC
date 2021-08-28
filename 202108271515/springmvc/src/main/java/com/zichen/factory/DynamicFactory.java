package com.zichen.factory;

import com.zichen.dao.UserDao;
import com.zichen.dao.impl.UserDaoImpl;

/**
 * 工厂模式实例方法创建对象
 * @author zc
 * @date 2021-08-27 16:23
 */
public class DynamicFactory {

    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

}
