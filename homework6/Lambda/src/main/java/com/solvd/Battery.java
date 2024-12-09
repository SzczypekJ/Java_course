package com.solvd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Battery {

    LOW_POWER(100, "Samsung"),
    MEDIUM_POWER(250, "Apple"),
    HIGH_POWER(500, "Lenovo");

    private int power;
    private String companyName;


}
