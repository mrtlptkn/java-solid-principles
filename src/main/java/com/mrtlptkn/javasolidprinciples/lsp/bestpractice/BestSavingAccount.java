package com.mrtlptkn.javasolidprinciples.lsp.bestpractice;

import java.math.BigDecimal;

public class BestSavingAccount extends BestAccount  implements IInterestable,IDebitable{
    public BestSavingAccount(BigDecimal balance) {
        super(balance);
    }

    @Override
    public void debit(BigDecimal amount) {
        if(amount.equals(BigDecimal.ZERO) || amount.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        if(amount.compareTo(balance) > 0){
            throw new IllegalArgumentException("Amount must be less than balance");
        }

        balance = balance.subtract(amount);
    }

    @Override
    public void applyInterest() {

    }
}
