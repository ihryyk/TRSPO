package com.example.ihor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String code;
    private Integer balance;
    private Boolean isActive;
    private Integer userId;
}
