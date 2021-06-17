package com.example.demo.ihor.controller;

import com.example.demo.ihor.dto.AccountDto;
import com.example.demo.ihor.model.Account;
import com.example.demo.ihor.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private AccountService accountService;

    @GetMapping
    public List<Account> findAllAccounts() {
        return accountService.findAllAccounts();
    }

    @GetMapping("/{id}")
    public List<Account> findAllAccountsByUser(@PathVariable Integer id) {
        return accountService.findAllAccountsByUser(id);
    }

    @PostMapping("/block")
    public void blockUserAccount(@RequestParam String accountCode) {
        accountService.blockUserAccount(accountCode);
    }

    @PostMapping("/unblock")
    public void unblockUserAccount(@RequestParam String accountCode) {
        accountService.unblockUserAccount(accountCode);
    }

    @PostMapping("/replenish")
    public void replenishUserAccount(@RequestBody AccountDto accountDto) throws Exception {
        accountService.replenishUserAccount(accountDto);
    }

    @PostMapping("/payment")
    public void doPayment(@RequestBody AccountDto accountDto) throws Exception {
        accountService.doPayment(accountDto);
    }
}
