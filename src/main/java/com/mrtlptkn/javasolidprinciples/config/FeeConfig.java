package com.mrtlptkn.javasolidprinciples.config;

import com.mrtlptkn.javasolidprinciples.ocp.bestpractice.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// Uygulama çalıştığı anda bizim uygulama içerisindeki tüm hardcoded olarak yazılmış olan Fee sınıflarımız önce FeeEngine içerisine register olur. daha sonra istediğimiz yerde feeEngine içerisinde herhangi bir Fee sınıfını çağırarak hesaplamayı polimorifk yapmamızı sağlar. Bunu bu sebeple Spring Context'a bean olarak verdik.

@Configuration
public class FeeConfig {

    @Bean
    public FeeEngine feeEngine(){
        StandartFee standartFee = new StandartFee();
        VipFee vipFee = new VipFee();
        PremiumFee premiumFee = new PremiumFee();
        IFeeStrategy goldFee = new GoldFee();

        FeeEngine feeEngine = new FeeEngine();
        feeEngine.register("STANDARD",standartFee);
        feeEngine.register("VIP",vipFee);
        feeEngine.register("PREMIUM",premiumFee);
        feeEngine.register("GOLD",goldFee);

        return feeEngine;
    }

}
