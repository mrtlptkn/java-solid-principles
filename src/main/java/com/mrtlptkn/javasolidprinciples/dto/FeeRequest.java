package com.mrtlptkn.javasolidprinciples.dto;

import java.math.BigDecimal;

public record FeeRequest(BigDecimal unitPrice,String feeType) {
}
