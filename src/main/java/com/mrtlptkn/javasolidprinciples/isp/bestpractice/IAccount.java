package com.mrtlptkn.javasolidprinciples.isp.bestpractice;

import java.math.BigDecimal;


// Interface seggregation Single Responsibilty gibi düşünmmemiz lazım.

// Birşey hesap ise bakiyesi kesinlikle olmalı mı ? tüm hesaplarda ortak mı ?
public interface IAccount {
    BigDecimal getBalance();
    String getAccountNumber();
}
