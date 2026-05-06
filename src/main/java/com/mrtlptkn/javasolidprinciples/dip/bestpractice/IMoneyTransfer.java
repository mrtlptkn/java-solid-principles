package com.mrtlptkn.javasolidprinciples.dip.bestpractice;

import com.mrtlptkn.javasolidprinciples.isp.bestpractice.IAccount;

import java.math.BigDecimal;

public interface IMoneyTransfer {

    void transferMoney(IAccount source, IAccount target, BigDecimal amount);

}
