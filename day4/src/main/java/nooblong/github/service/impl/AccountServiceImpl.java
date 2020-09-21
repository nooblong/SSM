package nooblong.github.service.impl;

import nooblong.github.dao.IAccountDao;
import nooblong.github.domain.Account;
import nooblong.github.service.IAccountService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    @Override
    public Account findAccountById(int accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void transfer(String SN, String TN, float money) {
        System.out.println("transfer");
        Account source = accountDao.findAccountByName(SN);
        Account target = accountDao.findAccountByName(TN);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);

        int i = 1/0;

        accountDao.updateAccount(target);
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
