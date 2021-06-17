package com.example.demo;

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
