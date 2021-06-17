package com.example.demo.ihor.dao;

import com.example.demo.ihor.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AccountDao {
    public static List<Account> accounts = new ArrayList<>();

    static {
        accounts.add(new Account("1", 100, true, 1));
    }

    public Optional<Account> findByUsername(String accountCode) {
        return accounts.stream().filter(x -> x.getCode().equals(accountCode)).findFirst();
    }

    public List<Account> findAllAccounts() {
        return accounts;
    }
}
