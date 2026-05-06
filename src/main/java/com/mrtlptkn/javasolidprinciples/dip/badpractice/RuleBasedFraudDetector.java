package com.mrtlptkn.javasolidprinciples.dip.badpractice;

import java.math.BigDecimal;

public class RuleBasedFraudDetector {

    public boolean isSuspiciousTransaction(String message, BigDecimal amount) {
        // Basit bir kural: 10.000'den fazla para transferi şüpheli olarak kabul edilir
        return amount.compareTo(BigDecimal.valueOf(10000)) > 0;
    }

}
