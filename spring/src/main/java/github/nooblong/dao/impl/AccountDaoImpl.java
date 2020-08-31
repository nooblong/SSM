package github.nooblong.dao.impl;

import github.nooblong.dao.IAccountDao;
import github.nooblong.domain.Account;
import github.nooblong.utils.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private ConnectionUtil connectionUtil;

    @Autowired
    private QueryRunner runner;

    public  void saveAccount(Account account){
        try {
            runner.update(connectionUtil.getConnection(),"insert into day2 (name, money) values (?,?);"
                    ,account.getName(),account.getMoney());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Account> findAllAccount() {
        try {
            return runner.query(connectionUtil.getConnection(),"select * from day2", new BeanListHandler<Account>(Account.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public Account findAccountById(int id) {
        try {
            return runner.query(connectionUtil.getConnection(),"select * from day2 where id = ?", new BeanHandler<Account>(Account.class),id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtil.getConnection(),"update day2 set name = ?, money = ? where id = ?"
                    ,account.getName(),account.getMoney(),account.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteAccount(int accountID) {
        try {
            runner.update(connectionUtil.getConnection(),"delete from day2 where id = ?",accountID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void transfer(String sourceName, String targetName, Float money) {

    }

    public Account findAccountByName(String name) {
        try {
            List<Account> accounts = runner.query(connectionUtil.getConnection(),"select * from day2 where name = ?",
                    new BeanListHandler<Account>(Account.class), name);
            if (accounts == null || accounts.size() == 0)
                return null;
            if (accounts.size() > 1)
                throw new RuntimeException("数据有问题");
            return accounts.get(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }
}
