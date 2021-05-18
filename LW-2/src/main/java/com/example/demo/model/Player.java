package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Player extends Person {

    private int number;
    private String position;
    private int skill;

}
