package com.zichen.factory;

import com.zichen.dao.UserDao;
import com.zichen.dao.impl.UserDaoImpl;

/**
 * 工厂模式静态方法创建对象
 * @author zc
 * @date 2021-08-27 16:23
 */
public class StaticFactory {

    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }

}
