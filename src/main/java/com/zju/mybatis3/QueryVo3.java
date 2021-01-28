package com.zju.mybatis3;

import com.zju.mybatis1.User;

import java.io.Serializable;
import java.util.List;

/**
 * 查询条件对象
 */
public class QueryVo3 implements Serializable {
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
