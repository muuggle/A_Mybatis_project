package com.zju.mybatis3;

import java.util.List;

/**
 * 持久层接口
 */
public interface IRoleDao {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
