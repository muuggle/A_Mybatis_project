package com.zju.mybatis1;

import java.util.List;

/**
 * 持久层
 */

public interface IUserDao {
    /**
     * 查询所有用户
     */

    List<User> findAll();

    /**
     * 查询所有用户，同时获取每个用户下的所有账户信息
     */
    List<User> findAll2();
}
