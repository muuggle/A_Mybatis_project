package com.zju.mybatis3;

import com.zju.mybatis1.User;

import java.util.List;

/**
 * 持久层接口
 */
public interface IAccountDao {
    /**
     * 查询所有账户 同时获取账户所属的用户名称以及地址信息
     */
    List<AccountUser> findAll();

}
