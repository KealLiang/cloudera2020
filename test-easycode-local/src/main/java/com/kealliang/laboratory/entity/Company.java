package com.kealliang.laboratory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company{
    private String name;
    private Integer duration;
    private Date setUpTime;

    private final String lable = "WIN WIN WIN!";
}