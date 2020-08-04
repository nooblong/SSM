package github.nooblong.service.impl;

import github.nooblong.dao.IAccountDao;
import github.nooblong.dao.impl.AccountDaoImpl;
import github.nooblong.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
