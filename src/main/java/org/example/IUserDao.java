package org.example;

import java.util.List;

/**
 * 持久层
 */

public interface IUserDao {
    /**
     * 查询所有用户
     */

    List<User> findAll();
}
