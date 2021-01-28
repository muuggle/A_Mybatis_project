package com.zju;

import com.zju.mybatis1.User;
import com.zju.mybatis3.IUserDao3;
import com.zju.mybatis3.QueryVo3;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Mybatis3Test {
    private IUserDao3 userDao3;

    @Test
    public void testSql() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();

        List<User> list = session.selectList("findUserById", 41);
        System.out.println(list.size());
    }

    @Test
    public void testFindByUser() {
        User u = new User();
        u.setUsername("%%朱");
        u.setAddress("%hangzhou%");

        List<User> users = userDao3.findByUser(u);
        System.out.println(users);
    }

    @Test
    public void testFindInIds() {
        QueryVo3 vo = new QueryVo3();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(43);
        ids.add(46);
        ids.add(57);
        vo.setIds(ids);
        List<User> users = userDao3.findInIds(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
