package com.sti.bootcamp.servlet.dao;

import com.sti.bootcamp.servlet.model.Account;

import java.util.List;

public interface AccountDao {
    List<Account> getList();
    Account getById(int customerNumber);
    Account save(Account customer);
}
