package nooblong.github.service;

import github.nooblong.domain.Account;

public interface IAccountService {

    Account findAccountById(int accountId);

    void transfer(String SN, String TN, float money);

}
