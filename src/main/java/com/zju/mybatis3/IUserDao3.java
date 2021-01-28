package com.zju.mybatis3;

import com.zju.mybatis1.User;

import java.util.List;

public interface IUserDao3 {
    /**
     * 根据用户信息查找用户列表
     */

    List<User> findByUser(User user);

    /**
     *根据id集合查询用户
     */

    List<User> findInIds(QueryVo3 vo3);
}
