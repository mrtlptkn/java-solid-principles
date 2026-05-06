package com.mrtlptkn.javasolidprinciples.dip.bestpractice.repositories;

import com.mrtlptkn.javasolidprinciples.dip.bestpractice.ICheckingAccountRepository;
import com.mrtlptkn.javasolidprinciples.isp.bestpractice.CheckingAccount;

public class InMemoryCheckingAccountRepository implements ICheckingAccountRepository {
    @Override
    public void save(CheckingAccount entity) {
        System.out.println("Account saved to memory: " + entity.getAccountNumber());
    }

    @Override
    public CheckingAccount findById(String id) {
        return new CheckingAccount();
    }
}
