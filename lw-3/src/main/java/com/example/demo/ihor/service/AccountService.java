package com.example.demo.ihor.service;

import com.example.demo.ihor.dao.AccountDao;
import com.example.demo.ihor.dao.PaymentDao;
import com.example.demo.ihor.dto.AccountDto;
import com.example.demo.ihor.model.Account;
import com.example.demo.ihor.model.Payment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountDao accountDao;

    public void blockUserAccount(String accountCode) {
        Account account = accountDao.findByUsername(accountCode).orElseThrow();
        account.setIsActive(false);
    }

    public void unblockUserAccount(String accountCode) {
        Account account = accountDao.findByUsername(accountCode).orElseThrow();
        account.setIsActive(true);
    }

    public List<Account> findAllAccounts() {
        return accountDao.findAllAccounts();
    }

    public List<Account> findAllAccountsByUser(Integer id) {
        return accountDao.findAllAccounts().stream().filter(x -> x.getUserId().equals(id)).collect(Collectors.toList());
    }

    public void replenishUserAccount(AccountDto accountDto) throws Exception {
        Account account = accountDao.findByUsername(accountDto.getAccountCode()).orElseThrow();
        if(!account.getIsActive()) {
            throw new Exception("Account is not active");
        }
        account.setBalance(account.getBalance() + accountDto.getSum());
    }

    public void doPayment(AccountDto accountDto) throws Exception {
        Account account = accountDao.findByUsername(accountDto.getAccountCode()).orElseThrow();
        if(!account.getIsActive()) {
            throw new Exception("Account is not active");
        }
        account.setBalance(account.getBalance() - accountDto.getSum());
        PaymentDao.payments.add(new Payment(accountDto.getSum(), LocalDateTime.now(), accountDto.getAccountCode()));
    }
}
