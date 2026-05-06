package com.mrtlptkn.javasolidprinciples.dip.badpractice;

import com.mrtlptkn.javasolidprinciples.isp.bestpractice.CheckingAccount;

public class MongoDbCheckingAccountRepository {

    public void saveCollection(CheckingAccount checkingAccount) {
        System.out.println("Account saved to database NonRelational: " + checkingAccount.getAccountNumber());
    }

    public CheckingAccount findById(){
        return new CheckingAccount();
    }

}
