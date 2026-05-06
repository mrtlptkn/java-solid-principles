package com.mrtlptkn.javasolidprinciples.isp.bestpractice;

import java.math.BigDecimal;



// GoldCheckingAccount, SilverCheckingAccount  implements -> ICheckingAccount

public class CheckingAccount extends  BaseAccount implements ICheckingAccount{

    @Override
    public void credit(BigDecimal amount) {
        // Para yatırma işlemi
    }

    @Override
    public void debit(BigDecimal amount) {
        // Para çekme işlemi
    }

    @Override
    public void applyInterest(float interestRate) {
        // Faiz uygulama işlemi
    }

    @Override
    public float getInterestRate() {
        // Faiz oranını döndürme işlemi
        return 0;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}
