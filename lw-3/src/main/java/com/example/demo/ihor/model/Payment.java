package com.example.demo.ihor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Integer sum;
    private LocalDateTime dateTime;
    private String accountCode;
}
