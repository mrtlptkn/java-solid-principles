package com.mrtlptkn.javasolidprinciples.srp.bestpractice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

// @RequiredArgsConstructor -> DI için doğru bulmuyorum -> Not: final yapmıyor


public class SrpBestAccount {

    // yanlış kullanım -> çünkü srpBestAccount'a iki sınıfda instance alma sorumluluğunu verdik.
    // constructor üzerinden gönderilen değerler değişirse kod değişir.
    // direk sınıflara bağımlı olduğundan sınıflardaki herhangi bir değişiklik srpBestAccount'ı etkiler.
    //private EmailSender emailSender = new EmailSender();
    //private Logger logger = new Logger();
    private final  EmailSender emailSender;
    private final  Logger logger;
    private BigDecimal balance;

    public SrpBestAccount(EmailSender emailSender,Logger logger) {
        this.emailSender = emailSender;
        this.logger = logger;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void tranfer(BigDecimal amount, String accountId) {

        if (amount.compareTo(balance) > 0) {
            this.logger.log("Yetersiz bakiye ile transfer girişimi. Miktar: " + amount + ", Hedef Hesap: " + accountId);
            throw new IllegalArgumentException("Yetersiz bakiye");
        }

        // en düşük transfer limit
        if(amount.compareTo(new BigDecimal("10000")) > 0) {
            this.emailSender.sendMessage("to","from","Büyük transfer işlemi gerçekleştirildi. Miktar: " + amount + ", Hedef Hesap: " + accountId);
            balance = balance.subtract(amount); // bakiyeden düştük
        }

    }

}
