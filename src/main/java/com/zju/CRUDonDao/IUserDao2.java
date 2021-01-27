package com.zju.CRUDonDao;

import com.zju.mybatis.User;

import java.util.List;

public interface IUserDao2 {
    /**
     * 查询所有用户
     */

    List<User> findAll();

    /**
     * 根据ID查询
     *
     * @param userId
     * @return
     */
    User findByID(Integer userId);

    /**
     * 保存用户
     */

    int saveUser(User user);

    /**
     * 更新
     */

    int updateUser(User user);

    /**
     * 删除
     */

    int deleteUser(Integer userId);

    /**
     * 根据名称模糊查询
     */
    List<User> findByName(String username);

    /**
     * 查询总记录体条数
     */
    int findTotal();

    /**
     * 根据QueryVo中的条件查询用户
     */
    List<User> findByVo(QueryVo vo);


}

