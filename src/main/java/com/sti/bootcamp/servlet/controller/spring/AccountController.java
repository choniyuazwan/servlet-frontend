package com.sti.bootcamp.servlet.controller.spring;

import com.sti.bootcamp.servlet.dao.AccountDao;
import com.sti.bootcamp.servlet.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AccountController {
    @Autowired(required=false)
    private Account account;

    @Autowired
    private AccountDao accountDao;

    @RequestMapping("/account-list")
    public ModelAndView getAccounts() {
        List<Account> data = accountDao.getList();
        System.out.println(data.size());
        return new ModelAndView("account-list", "data", data);
    }
}
