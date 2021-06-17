package com.example.demo.ihor.dao;

import com.example.demo.ihor.model.Payment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentDao {
    public static List<Payment> payments = new ArrayList<>();

    static {
        payments.add(new Payment(50, LocalDateTime.of(2014, 9, 19, 14, 5), "1"));
    }

    public List<Payment> findAllPaymentsByAccount(String accountCode) {
        return payments.stream().filter(x -> x.getAccountCode().equals(accountCode)).collect(Collectors.toList());
    }
}
