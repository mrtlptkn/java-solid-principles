package com.mrtlptkn.javasolidprinciples.isp.bestpractice;

import java.math.BigDecimal;

public abstract class BaseAccount implements IAccount {

    protected BigDecimal balance;
    protected String accountNumber;

}
