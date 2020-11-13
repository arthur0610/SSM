package edu.zxie0018.test;

import edu.zxie0018.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class HelloMybatis {

    @Test
    public void Test1() throws IOException {
        String resource = "configuration.xml";
        //System.out.println(Resources.getResource("/").getPath());

        InputStream in = Resources.getResourceAsStream(resource);

        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

        SqlSessionFactory ssf = ssfb.build(in);

        SqlSession session = ssf.openSession();

        User user = session.selectOne("UserMapper.selectUserById", 11111);

        System.out.println(user);
    }

    @Test
    public void Test2() throws IOException {
        String path = this.getClass().getResource("/").getPath();
        System.out.println(path);
    }
}
