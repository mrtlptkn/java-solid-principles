package com.mrtlptkn.javasolidprinciples.dip.bestpractice.frauds;

import com.mrtlptkn.javasolidprinciples.dip.bestpractice.IFraudDetector;

import java.math.BigDecimal;

public class ALFraudDetector implements IFraudDetector {
    @Override
    public boolean isSuspiciousTransaction(String message, BigDecimal amount) {
        return false;
    }
}
