package com.setu.splitwise.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Currency {
    INR("INR"),
    EURO("EURO");

    private String symbol;
}
