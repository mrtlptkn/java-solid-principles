package com.mrtlptkn.javasolidprinciples.dip.bestpractice;

import com.mrtlptkn.javasolidprinciples.isp.bestpractice.CheckingAccount;
import com.mrtlptkn.javasolidprinciples.isp.bestpractice.IAccount;

import java.math.BigDecimal;

// SavingAccountda olabilir, Checking kullanabilir.
public interface ICheckingAccountMoneyTransfer {

    void transferMoney(CheckingAccount source, CheckingAccount target, BigDecimal amount);

}
