package com.solvd.lambdas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CreditCard {
    VISA("Visa", "credit card", 5000),
    MASTER_CARD("Master card", "debet card", 3000);

    private String name;
    private String typeOdCard;
    private int amount;
}
