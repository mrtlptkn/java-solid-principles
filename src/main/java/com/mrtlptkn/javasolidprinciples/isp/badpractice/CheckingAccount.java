package com.mrtlptkn.javasolidprinciples.isp.badpractice;

import java.math.BigDecimal;

public class CheckingAccount implements  IBankingAccount{

    private BigDecimal balance;


    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void debit(BigDecimal amount) {

    }

    @Override
    public void credit(BigDecimal amount) {

    }

    @Override
    public void transfer(IBankingAccount source, IBankingAccount target) {

    }

    @Override
    public void applyInterest(float interestRate) {

    }
}
