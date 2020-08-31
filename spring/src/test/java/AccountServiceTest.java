import github.nooblong.config.Config;
import github.nooblong.dao.IAccountDao;
import github.nooblong.domain.Account;
import github.nooblong.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class AccountServiceTest {
//    @Autowired
//    ApplicationContext ac;
    @Autowired
    IAccountService as;

//    void init(){
//        ac = new ClassPathXmlApplicationContext("bean.xml");
//        as = ac.getBean("accountService",IAccountService.class);
//    }

    @Test
    public void findAll() {
//        init();
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts)
            System.out.println(account);
    }

    @Test
    public void testTransfer(){
        as.transfer("aaa", "bbb", 100f);
    }
}
