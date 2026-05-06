package com.mrtlptkn.javasolidprinciples.isp.bestpractice;

import java.math.BigDecimal;

public class SavingAccount extends BaseAccount implements  ICrediable,IInterest{
    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void credit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    @Override
    public void applyInterest(float interestRate) {
        BigDecimal interestAmount = balance.multiply(BigDecimal.valueOf(interestRate / 100));
        balance = balance.add(interestAmount);
    }

    @Override
    public float getInterestRate() {
        return 0;
    }
}
