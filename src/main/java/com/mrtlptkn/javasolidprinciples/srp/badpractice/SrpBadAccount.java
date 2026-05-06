package com.mrtlptkn.javasolidprinciples.srp.badpractice;

import lombok.Data;
import lombok.extern.flogger.Flogger;

// Solid ile ilgili kilit sorular
// Kodum test edilebilir mi ?
// Kodum sürdürülebilir mi
// Koduma yeni bir feature rahatlıkla eklenebilir ? Kodum modüler mi ?


import java.math.BigDecimal;

@Data
public class SrpBadAccount {
    private String accountId;
    private BigDecimal balance;

    // Logger ve EmailSender kodları bir sideeffect oluşturur. Ve Bu kodlardaki kırılmalar transfer
    // servisini olumsuz etkiler.

    public void tranfer(BigDecimal amount, String accountId) {

        if(amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("Yetersiz bakiye");
        }

        // Log.warning("LogMessage");
        System.out.println("Transfer işlemi gerçekleştirildi. Miktar: " + amount + ", Hedef Hesap: " + accountId);

        // EmailSender es = new EmailSender();
        // es.to = "ali@test.com"
        // es.from ="cenk@test.com"
        // es.isHtmlBody = true;
        // es.subject = "";
        // es.cc = "t@test.com";
        // es.content = "<div>sadsadsa</div>"
        // es.sendMessage("to","from","Message");
        System.out.println("Email gönderildi: Transfer işlemi başarılı. Miktar: " + amount + ", Hedef Hesap: " + accountId);

        // en düşük transfer limit
        if(amount.compareTo(new BigDecimal("10000")) > 0) {
            System.out.println("SMS gönderildi: Büyük transfer işlemi gerçekleştirildi. Miktar: " + amount + ", Hedef Hesap: " + accountId);
            balance = balance.subtract(amount);
        }
    }



}
