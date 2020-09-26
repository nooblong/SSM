package github.nooblong.service;

import github.nooblong.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    void saveAccount(Account account);

}
