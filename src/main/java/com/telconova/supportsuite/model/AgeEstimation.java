package com.telconova.supportsuite.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgeEstimation {
    private String name;
    private Integer age;
    private Integer count;
}