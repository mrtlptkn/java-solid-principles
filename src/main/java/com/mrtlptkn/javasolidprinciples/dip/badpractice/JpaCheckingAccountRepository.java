package com.mrtlptkn.javasolidprinciples.dip.badpractice;

import com.mrtlptkn.javasolidprinciples.isp.bestpractice.CheckingAccount;

public class JpaCheckingAccountRepository {

    public void save(CheckingAccount checkingAccount) {
        System.out.println("Account saved to database Relational: " + checkingAccount.getAccountNumber());
    }

    public CheckingAccount findById(){
        return new CheckingAccount();
    }
}
