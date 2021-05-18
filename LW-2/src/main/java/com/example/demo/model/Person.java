package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private double salary;


}
