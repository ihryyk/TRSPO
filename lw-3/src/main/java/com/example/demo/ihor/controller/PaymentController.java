package com.example.demo.ihor.controller;

import com.example.demo.ihor.model.Payment;
import com.example.demo.ihor.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentController {
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> findAllPaymentsByAccount(@PathVariable String accountCode) {
        return paymentService.findAllPaymentByAccount(accountCode);
    }
}
