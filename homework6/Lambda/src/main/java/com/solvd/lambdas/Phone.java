package com.solvd.lambdas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Phone {
    IPHONE("iphone", 3000, Battery.LOW_POWER),
    SAMSUNG("samsung", 2500, Battery.MEDIUM_POWER),
    ONEPLUS("one plus", 2000, Battery.HIGH_POWER);

    private String name;
    private int cost;
    private Battery battery;
}
