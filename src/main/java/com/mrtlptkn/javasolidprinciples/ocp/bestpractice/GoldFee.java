package com.mrtlptkn.javasolidprinciples.ocp.bestpractice;

import java.math.BigDecimal;

public class GoldFee implements IFeeStrategy {
    @Override
    public BigDecimal calculateFee(BigDecimal unitPrice) {
        return unitPrice.multiply(new BigDecimal("0.00075"));
    }
}
