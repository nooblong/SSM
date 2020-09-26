package github.nooblong.controller;

import github.nooblong.domain.Account;
import github.nooblong.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("controller:findAll");
        List<Account> all = accountService.findAll();
        model.addAttribute("list",all);
        return "list";
    }

    @RequestMapping("/save")
    public void save(Account account, HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println("controller:save");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }

}
