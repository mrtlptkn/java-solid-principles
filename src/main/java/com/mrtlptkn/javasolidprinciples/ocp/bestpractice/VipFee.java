package com.mrtlptkn.javasolidprinciples.ocp.bestpractice;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class VipFee implements  IFeeStrategy{
    @Override
    public BigDecimal calculateFee(BigDecimal unitPrice) {
        log.info("StandartFee hesaplanıyor...");
        return unitPrice.multiply(new BigDecimal("0.0015"));
    }
}
