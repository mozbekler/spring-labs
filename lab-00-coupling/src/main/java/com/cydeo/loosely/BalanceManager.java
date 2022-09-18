package com.cydeo.loosely;

import com.cydeo.CustomerBalance;

import java.math.BigDecimal;

public class BalanceManager {
    public boolean checkout(Balance balance, BigDecimal amount){
        return balance.getAmount().subtract(amount)
                .compareTo(BigDecimal.ZERO) > 0;
    }
}
