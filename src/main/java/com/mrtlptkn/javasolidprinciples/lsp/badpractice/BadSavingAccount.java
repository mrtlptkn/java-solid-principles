package com.mrtlptkn.javasolidprinciples.lsp.badpractice;

import java.math.BigDecimal;

public class BadSavingAccount extends LspBadAccount {

    private BigDecimal dailyInterestRate;


    public BadSavingAccount(BigDecimal balance) {
        super(balance);
    }

    public void setDailyInterestRate(BigDecimal dailyInterestRate) {
        this.dailyInterestRate = dailyInterestRate;
    }

    @Override
    public void credit(BigDecimal amount) {

        // para yatrıma işleminde günlük faiz oranımız kadar paranın değerini artıralım
       balance =  amount.multiply(BigDecimal.ONE.add(dailyInterestRate));

    }

    @Override
   public void debit(BigDecimal amount) { // para çıkışı
        if(amount.equals(BigDecimal.ZERO) || amount.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        if(amount.compareTo(balance) > 0){
            throw new IllegalArgumentException("Amount must be less than balance");
        }

        balance = balance.subtract(amount);
    }
}
