package com.zju.mybatis2;

import com.zju.mybatis1.User;

import java.io.Serializable;

/**
 * 查询条件对象
 */
public class QueryVo implements Serializable {
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

}
