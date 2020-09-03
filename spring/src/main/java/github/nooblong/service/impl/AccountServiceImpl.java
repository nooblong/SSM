package github.nooblong.service.impl;

import github.nooblong.dao.IAccountDao;
import github.nooblong.dao.impl.AccountDaoImpl;
import github.nooblong.domain.Account;
import github.nooblong.service.IAccountService;
import github.nooblong.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 账户的业务层实现类
 */

@Service(value = "accountService")
public class AccountServiceImpl implements IAccountService {

    @Resource(name = "transactionManager")
    private TransactionManager tm;

    private String name;
    private Integer age;
    private Date birthday;
    private String[] strings;

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public AccountServiceImpl() {

    }

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

//    @Qualifier(value = "accountDao")
//    @Autowired
    @Resource(name = "accountDao")
    private IAccountDao accountDao;

    public void saveAccount(Account account) {
        try {
            /**
             * 开启事务
             * 执行操作
             * 提交事务
             * 返回结果
             */
            tm.begin();
            accountDao.saveAccount(account);
            tm.commit();
        } catch (Exception e){
            //回滚
            tm.rollback();
        } finally {
            //释放
            tm.release();
        }
    }

    public void strings() {
        if (strings != null)
            for (String s : strings)
                System.out.println(s);
    }

    public List<Account> findAllAccount() {
        try {
            /**
             * 开启事务
             * 执行操作
             * 提交事务
             * 返回结果
             */
            tm.begin();

        } catch (Exception e){
            //回滚

        } finally {
            //释放

        }
        return accountDao.findAllAccount();
    }

    public Account findAccountById(int id) {
        try {
            /**
             * 开启事务
             * 执行操作
             * 提交事务
             * 返回结果
             */
            tm.begin();
            Account account = accountDao.findAccountById(id);
            tm.commit();
            return account;
        } catch (Exception e){
            //回滚
            tm.rollback();
            throw new RuntimeException();
        } finally {
            //释放
            tm.release();
        }
    }

    public void updateAccount(Account account) {
        try {
            /**
             * 开启事务
             * 执行操作
             * 提交事务
             * 返回结果
             */
            tm.begin();

        } catch (Exception e){
            //回滚

        } finally {
            //释放

        }
        accountDao.updateAccount(account);
    }

    public void deleteAccount(int accountID) {
        try {
            /**
             * 开启事务
             * 执行操作
             * 提交事务
             * 返回结果
             */
            tm.begin();
            accountDao.deleteAccount(accountID);
            tm.commit();
        } catch (Exception e){
            //回滚
            tm.rollback();
        } finally {
            //释放
            tm.release();
        }
    }

    public void transfer(String sourceName, String targetName, Float money) {
        try {
            /**
             * 开启事务
             * 执行操作
             * 提交事务
             * 返回结果
             */
            tm.begin();
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            accountDao.updateAccount(source);
//            int i = 1/0;
            accountDao.updateAccount(target);
            tm.commit();
        } catch (Exception e){
            //回滚
            tm.rollback();
            System.out.println("rollBack");
        } finally {
            //释放
            tm.release();
        }

    }

    public Account findAccountByName(String name) {
        try {
            /**
             * 开启事务
             * 执行操作
             * 提交事务
             * 返回结果
             */
            tm.begin();

        } catch (Exception e){
            //回滚

        } finally {
            //释放

        }
        return accountDao.findAccountByName(name);
    }


    public void init() {
        System.out.println("init...");
    }

    public void destroy() {
        System.out.println("destroy...");
    }

    public void setTr(TransactionManager tm) {
        this.tm = tm;
    }
}
