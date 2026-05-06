package com.mrtlptkn.javasolidprinciples.lsp.bestpractice;


import java.math.BigDecimal;

// LSP -> bu sınfın böyle modellenmesine karar verebilme beceresi alsında LSP olmuş oluyor
// debit, applyIntrest gibi özellikler interface ile diğer account sınıflarına kazandırılmalı.

// bakiye ve hesaba para girişi dışındaki özellikler, diğer accountlar için uygun olmuyor bu sebeple kalıtım zincirini bozmamk geri kalan özellikleri sınıflara interface vasıtası ile aktarmayı düşüneceğiz.

public abstract class BestAccount {

    protected BigDecimal balance;

    public BestAccount(BigDecimal balance) {
        this.balance = balance;
    }


    public void credit(BigDecimal amount){

        if(amount.equals(BigDecimal.ZERO) || amount.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        this.balance = balance.add(amount);
    }

}
