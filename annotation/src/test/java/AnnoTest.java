import github.nooblong.dao.IUserDao;
import github.nooblong.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AnnoTest {
    InputStream in;
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    IUserDao userDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void close() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    public static void main(String[] args) throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
        sqlSession.close();
        in.close();
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("mybatisAnnotation");
        user.setSex("2");
        userDao.saveUser(user);
    }

    @Test
    public void deleteUser(){
        userDao.deleteUser(49);
    }
}
