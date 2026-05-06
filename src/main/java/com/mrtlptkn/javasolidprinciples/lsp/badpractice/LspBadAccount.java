package com.mrtlptkn.javasolidprinciples.lsp.badpractice;



// SavingAccount (Tasaruf Hesabı) -> Döviz, Altın, Gümüş (Daha kısa vadede bozulabilir), Belirli bir faiz oranı vardır.
// faiz uygulanabilir (credit -> para girişi, debit -> para çıkışı), birleşik faiz

// Senaryo olarak -> Account Abstract sınıf açılmış ve içerisinde para çekme, para yatırma, faiz uygulama

// Yeni bir tane hesap tanımı yapıcaz, bunun adı yatırım hesabı ama yatırım hesabında faiz uygulama olayı yok. Para çekme olayı yok. Para yatırma var (credit) -> para yatırma debit ile faiz yok.

// InventmentAcount (Yatırım Hesabı) -> Genel olarak uzun süren yatırımlar için , yatırım fonu, hisse senedi -> bunun bozulmasıda uzun vadelidir.
// kısa vadede bozulursa değer kaybına uğratır
// faiz uygulanabilir olmasın

// Liskov kalıtım alan bir sınıf kalıtım altığı sınıfın is olarak verdiği tüm özellikleri göstermeli dummy code oluşmamalıdır.
// Bir programda S tipi nesneler, T tipi nesnelerin yetine geçtiğinde programın doğruluğu bozulmamalıdır.
// SavingAccount -> InventmentAcount yerine geçtiğinde savingAccount çalışna herşey InventmentAcount içinde geçerli olmalıdır.

import java.math.BigDecimal;

public abstract class LspBadAccount {

    protected BigDecimal balance;

    public LspBadAccount(BigDecimal balance) {
        this.balance = balance;
    }

    public void credit(BigDecimal amount){

        if(amount.equals(BigDecimal.ZERO) || amount.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        balance = balance.add(amount);
    }

    public abstract void debit(BigDecimal amount);

    BigDecimal getBalance;

}
