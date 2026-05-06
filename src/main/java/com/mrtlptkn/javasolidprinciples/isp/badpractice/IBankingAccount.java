package com.mrtlptkn.javasolidprinciples.isp.badpractice;

import java.math.BigDecimal;


// Bir interface bir sınıfı bir çok davranışı göstermeye zorlarsa bu durumda interface seggragtion prensibine ayrkırı hareket etmiş oluruz.
// Interfacler ne kadar atomic tanımlanırsa okadar iyi. Gerekirse 1 yada 2 ve sadece operasyon ile alakalı olan değerleri interface tanımlayalım

public interface IBankingAccount {

    BigDecimal getBalance();
    void debit(BigDecimal amount);
    void credit(BigDecimal amount);
    void transfer(IBankingAccount source, IBankingAccount target);
    void  applyInterest(float interestRate);

}


// Her hesapda para girişi olacak mı ?  Hayır
// her hesapda para çıkışı olacak mı ?  Hayır
// para transfer süreci bir süreç bir hizmet değil mi ?  Hizmet -> Hayır
// Servis ile Modellerin ayrştırılması gerekmez mi ?  Birim hesabınan yatırım hesabına para gönderme işlemi yürütecek bir servis layer olmalı.
// her hesap türünde faiz uygulanıyor mu ?