package github.nooblong.service.impl;

import github.nooblong.dao.AccountDao;
import github.nooblong.domain.Account;
import github.nooblong.service.AccountService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        System.out.println("service:findAll");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
        System.out.println("service:saveAccount");
    }
}
