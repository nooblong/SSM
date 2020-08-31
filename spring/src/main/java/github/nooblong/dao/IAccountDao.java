package github.nooblong.dao;

import github.nooblong.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {

    /**
     * 模拟保存账户
     */
    void saveAccount(Account account);

    List<Account> findAllAccount();

    Account findAccountById(int id);

    void updateAccount(Account account);

    void deleteAccount(int accountID);

    void transfer(String sourceName, String targetName, Float money);

    Account findAccountByName(String name);

}
