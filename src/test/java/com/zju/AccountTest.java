package com.zju;

import com.zju.mybatis3.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao iAccountDao;
    private IAccountDao2 iAccountDao2;

    @Test
    public void TestFindAll() {
        List<AccountUser> accountUsers = iAccountDao.findAll();
        for (AccountUser accountUser : accountUsers) {
            System.out.println(accountUser);
        }
    }

    @Before
    public void init() throws Exception {
        //读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //创建构建者对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //创建工厂对象
        factory = sqlSessionFactoryBuilder.build(in);

        //创建SqlSession对象
        session = factory.openSession();

        //创建Dao代理对象
        iAccountDao = session.getMapper(IAccountDao.class);
    }

    @After
    public void destroy() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAll() {
        List<Account2> accounts = iAccountDao2.findAll();
        for (Account2 account2:accounts) {
            System.out.println(account2);
            System.out.println(account2.getUser());
        }
    }

}
