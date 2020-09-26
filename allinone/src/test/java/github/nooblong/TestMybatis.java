package github.nooblong;

import github.nooblong.dao.AccountDao;
import github.nooblong.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.apache.ibatis.io.Resources;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void run1() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        List<Account> all = dao.findAll();
        for (Account account : all){
            System.out.println(account);
        }
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void run2() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountDao dao = sqlSession.getMapper(AccountDao.class);

        Account account = new Account();
        account.setMoney(100d);
        account.setName("lihua");

        dao.saveAccount(account);

        sqlSession.commit();

        sqlSession.close();
        inputStream.close();
    }
}
