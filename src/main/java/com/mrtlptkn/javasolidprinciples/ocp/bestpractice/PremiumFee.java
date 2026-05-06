package com.mrtlptkn.javasolidprinciples.ocp.bestpractice;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class PremiumFee implements IFeeStrategy {
    @Override
    public BigDecimal calculateFee(BigDecimal unitPrice) {

        log.info("PremiumFee hesaplanıyor...");

        return unitPrice.multiply(new BigDecimal("0.0005"));
    }
}
