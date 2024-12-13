package com.solvd.lambdas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.function.Function;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Bank {
    ALIOR_BANK("Alior Bank", 50000, CreditCard.MASTER_CARD, balance -> balance > 50000),
    M_BANK("M bank", 100000, CreditCard.VISA, balance -> balance > 50000);

    private String name;
    private int balance;
    private CreditCard card;
    private Function<Integer, Boolean> loanChecker;

    public boolean checkIfICanTookALoan() {
        return loanChecker.apply(balance);
    }
}
