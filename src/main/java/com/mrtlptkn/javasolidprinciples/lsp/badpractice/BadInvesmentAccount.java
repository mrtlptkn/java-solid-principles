package com.mrtlptkn.javasolidprinciples.lsp.badpractice;

import java.math.BigDecimal;

public class BadInvesmentAccount extends  LspBadAccount{



    public BadInvesmentAccount(BigDecimal balance) {
        super(balance);
    }

    @Override
    public void debit(BigDecimal amount) {
        throw new UnsupportedOperationException("Debit operation is not supported for Investment Account");
    }

     @Override
    public void credit(BigDecimal amount) {
         if (amount.equals(BigDecimal.ZERO) || amount.compareTo(BigDecimal.ZERO) < 0) {
             throw new IllegalArgumentException("Amount must be greater than zero");
         }
     }
}
