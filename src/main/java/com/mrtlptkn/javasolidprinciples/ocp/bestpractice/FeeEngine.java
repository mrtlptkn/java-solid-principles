package com.mrtlptkn.javasolidprinciples.ocp.bestpractice;


// Tüm Feeler buraya register olurlar. Aynı IoC Container gibi
// o ilgili fee ismine göre bu fee strategy çağırıp kullanmak istiyoruz

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

// Neden bu sınıf var -> Çünkü service yada controller katmanında FeeEngine ile konuulacak ve kullanıcın arayzüden yaptığı seçime göre bir ücret hesaplama algoritmasını polimorfik bir şekilde çalıştırmak istiyoruz. Hemde yeni ücret politikaları geldikçe kodumuzda bir kırılma olmamasını istiyoruz.

public class FeeEngine {

    private final Map<String, IFeeStrategy> feeStrategies;


    public FeeEngine() {
        this.feeStrategies = new HashMap<>();
    }

    // bunu config üzeirnden dolduruyoruz. Uygulama ilk çalıştığında.
    public void  register(String key,IFeeStrategy feeStrategy){

        if(this.feeStrategies.containsKey(key)){
            throw new IllegalArgumentException("Bu key zaten kayıtlı: " + key);
        }

        this.feeStrategies.put(key,feeStrategy);
    }

    public BigDecimal calculateFee(String key, BigDecimal unitPrice){
        IFeeStrategy feeStrategy = this.feeStrategies.get(key);

        if(feeStrategy == null){
            throw new IllegalArgumentException("Bu key için bir fee strategy bulunamadı: " + key);
        }

        return feeStrategy.calculateFee(unitPrice);
    }

}
