package com.mrtlptkn.javasolidprinciples.ocp.bestpractice;

import java.math.BigDecimal;

public interface IFeeStrategy {

    BigDecimal calculateFee(BigDecimal unitPrice); // belirli bir birim fiyat üzerinden ürün hizmete göre bir fiyat biçin liste fiyatı üretmemizi sağlayacak.
}
