package github.nooblong.ui;

import github.nooblong.dao.IAccountDao;
import github.nooblong.service.IAccountService;
import github.nooblong.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        //获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取bean对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        IAccountDao ad = (IAccountDao)ac.getBean("accountDao",IAccountDao.class);

        System.out.println(as);
        System.out.println(ad);
        as.saveAccount();
    }
}
