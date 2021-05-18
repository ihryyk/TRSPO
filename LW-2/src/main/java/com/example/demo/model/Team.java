package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    private long id;
    private String name;
    private List<Player> players =new ArrayList<>();
    private Coach coach;

}
