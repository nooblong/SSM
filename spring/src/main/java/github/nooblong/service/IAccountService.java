package github.nooblong.service;

import github.nooblong.domain.Account;

import java.util.List;

/**
 * 账户业务层的接口
 */
public interface IAccountService {

    /**
     * 模拟保存账户
     */
    void saveAccount(Account account);

    void strings();

    List<Account> findAllAccount();

    Account findAccountById(int id);

    void updateAccount(Account account);

    void deleteAccount(int accountID);

    void transfer(String sourceName, String targetName, Float money);

    Account findAccountByName(String name);
}
