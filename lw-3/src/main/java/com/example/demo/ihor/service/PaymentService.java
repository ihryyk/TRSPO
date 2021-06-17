package com.example.demo.ihor.service;

import com.example.demo.ihor.dao.PaymentDao;
import com.example.demo.ihor.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentService {
    private PaymentDao paymentDao;

    public List<Payment> findAllPaymentByAccount(String accountCode) {
        return paymentDao.findAllPaymentsByAccount(accountCode);
    }
}
