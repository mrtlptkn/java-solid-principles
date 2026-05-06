package com.mrtlptkn.javasolidprinciples.isp.bestpractice;

import java.math.BigDecimal;

// para çıkışı olan tüm hesaplarda kullanılabilir
public interface IDebitable {
    void debit(BigDecimal amount);
}
