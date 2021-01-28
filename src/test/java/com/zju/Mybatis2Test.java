package com.zju;


import com.zju.mybatis2.IUserDao2;
import com.zju.mybatis2.QueryVo;
import com.zju.mybatis1.User;
import com.zju.mybatis1.io.Resources;
import com.zju.mybatis1.sqlsession.SqlSession;
import com.zju.mybatis1.sqlsession.SqlSessionFactory;
import com.zju.mybatis1.sqlsession.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 测试mybatis的CRUD操作
 */
public class Mybatis2Test {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao2 userDao2;

    @Test
    public void testFindOne() {
        //执行操作
        User user = userDao2.findByID(42);
        System.out.println(user);
    }

    @Before//在测试方法执行前执行
    public void init() throws Exception {
        //读取配置文件
        in = Resources.getResourceAsStream("sqlMapConfig.xml");

        //创建构造者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //创建SqlSession工厂对象
        factory = builder.build(in);

        //创建SqlSession对象
        session = factory.openSession();

        //创建Dao的代理对象
        userDao2 = session.getMapper(IUserDao2.class);
    }

    @After//在测试方法执行后执行
    public void destroy() throws Exception {
        session.commit();

        //释放资源
        session.close();
        in.close();
    }

    //    @Test
//    public void testSave() {
//        User user = new User();
//        user.setUsername("modify User property");
//        user.setAddress("北京市顺义区");
//        user.setSex("男");
//        user.setBirthday(new Date());
//        System.out.println("保存操作之前:" + user);
//
//        userDao2.saveUser(user);
//        System.out.println("保存操作之后:" + user);
//    }
//
//    @After
//    public void destroy() throws Exception{
//        session.commit();
//
//        session.close();
//        in.close();
//    }
//    @Test
//    public void testUpdate() throws Exception {
//        User user = userDao2.findByID(52);
//
//        user.setAddress("浙江省杭州市区");
//        int res = userDao2.updateUser(user);
//        System.out.println(res);
//    }
//
//    @After
//
//    public void destroy() throws Exception {
//        session.commit();
//        session.close();
//        in.close();
//    }
//
//    @Test
//    public void testDelete() throws Exception{
//        int res=userDao2.deleteUser(52);
//        System.out.println(res);
//    }
    @Test
    public void testFindByName() throws Exception {
        List<User> users = userDao2.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() throws Exception {
        int res = userDao2.findTotal();
        System.out.println(res);
    }

    @Test
    public void testFindByQueryVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);

        List<User> users = userDao2.findByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }
}
