package github.nooblong.dao;

import github.nooblong.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {

    @Select("select * from ssm")
    List<Account> findAll();

    @Insert("insert into ssm (name,money) values (#{name}, #{money})")
    void saveAccount(Account account);

}
