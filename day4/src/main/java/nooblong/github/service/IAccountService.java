package nooblong.github.service;

import nooblong.github.domain.Account;

public interface IAccountService {

    Account findAccountById(int accountId);

    void transfer(String SN, String TN, float money);

}
