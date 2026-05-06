package com.mrtlptkn.javasolidprinciples.ocp.badpractice;

import java.math.BigDecimal;


// Bir davranış bir duruma göre farklı logiclere şekillerine sahip oluyorsa burada polimorphismden söz edebiliriz. // OCP ile polymorphism doğru orantılı

public class FeeCalculator {

    // Not: Eğer bu tarz yapılarda bu oluşturudcağımı mekaniz genel bir yapı ise interface üzerinden ilerlemek daha esnek bir yaklaşımdır.

    public BigDecimal calculate(String customerType, BigDecimal amount) {

        // Her bir if içerisinde 100 lerce satırı aslında yönettiğimizi düşünelim.

        // OCP -> kodda yeni bir özellik istendiğinde kodu modifiye etme, ama geliştir.
        // Teknik -> bunu yapabilmenin tek yöntemi her logic için ayrı bir class açıp yönetmek
        // Bu classlarda super bir sınıftan türemeli yada interface implemente olmalıdır.
        // Burada bu sorunu çözmek için bir fiyat politikasına ihtiyaç var ?

        if(customerType.equals("STANDARD")){
            return  amount.multiply(new BigDecimal("0.001")); // 0.1% fee for standard customers
        } else if (customerType.equals("PREMIUM")){
            return  amount.multiply(new BigDecimal("0.0005")); // 0.05% fee for premium customers
        } else if (customerType.equals("VIP")) {
            return  amount.multiply(new BigDecimal("0.0015")); // 0.15% fee for premium customers
        } else {
            throw  new IllegalArgumentException("Unknown customer type: " + customerType);
        }
    }
}
