package com.mrtlptkn.javasolidprinciples.isp.bestpractice;


// İki farklı interface özelliğini başka interface de birleştiriyoruz.

public interface IBalanceTransaction extends ICrediable, IDebitable {
}
