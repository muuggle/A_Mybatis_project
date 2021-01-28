package com.zju;

import com.zju.mybatis1.IUserDao;
import com.zju.mybatis1.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 一对多的操作
 */
public class UserTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Test
    public void tesFindAll(){
        List<User> users =userDao.findAll2();
        for (User user:users){
            System.out.println("每个用户的内容");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
}
