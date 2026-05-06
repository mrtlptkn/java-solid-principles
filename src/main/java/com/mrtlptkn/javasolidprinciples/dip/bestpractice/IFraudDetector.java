package com.mrtlptkn.javasolidprinciples.dip.bestpractice;

import java.math.BigDecimal;

public interface IFraudDetector {
    boolean isSuspiciousTransaction(String message, BigDecimal amount);
}
