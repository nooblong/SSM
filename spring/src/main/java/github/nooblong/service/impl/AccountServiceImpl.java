package github.nooblong.service.impl;

import github.nooblong.dao.IAccountDao;
import github.nooblong.dao.impl.AccountDaoImpl;
import github.nooblong.service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {


    private String name;
    private Integer age;
    private Date birthday;
    private String[] strings;

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public AccountServiceImpl(){

    }

    public AccountServiceImpl(String name, Integer age, Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private IAccountDao accountDao = new AccountDaoImpl();

    public void  saveAccount(){
        accountDao.saveAccount();
        System.out.println(" name:" + name + " age:" + age + " birthday:" + birthday);
    }

    public void strings(){
        for (String s : strings)
            System.out.println(s);
    }

    public void init(){
        System.out.println("init...");
    }

    public void destroy(){
        System.out.println("destroy...");
    }
}
