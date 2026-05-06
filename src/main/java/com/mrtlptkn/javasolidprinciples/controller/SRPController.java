package com.mrtlptkn.javasolidprinciples.controller;

import com.mrtlptkn.javasolidprinciples.srp.bestpractice.EmailSender;
import com.mrtlptkn.javasolidprinciples.srp.bestpractice.Logger;
import com.mrtlptkn.javasolidprinciples.srp.bestpractice.SrpBestAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.math.BigDecimal;

@RestController("api/srp")
public class SRPController {

    // Senaryo : -> "God Object" -> Transfer nesnesi içerisinde bir çok şeyi yönetmeye çalışıtık.
    // Product Owner bizden Transfer ederken email template değişecek diye bir talepde bulundu
    // Değişiklik yapılıp sistem canlıya alındı, bir baktık ki akşam slack alarm düşmüş.
    // Bunun sebebi nedir ?


    // @Service anatasyonu ile yazınca -> defaulton singleton Intance -> Spring Context içerisinde sadece SrpBestAccount tipte bir unique instance oluşur. Uygulama run olduğu süre bu intance üzerinden çalışır. -> Uygulama ayağa kalktığı ilk an bu instance oluşur taki uygulama down edilene kadar yaşama devam eder. Bu yaşam süresini spring context yönetir.
    // GC üzerinden pressure baskı maliyet azdır.
//    private final SrpBestAccount srpBestAccount;
//
//    public SRPController(SrpBestAccount srpBestAccount) { // Spring Context DI
//        this.srpBestAccount = srpBestAccount;
//    }

    // Ioc -> Inversion Of Controller -> Kontrollerin developerdan alıp sisteme devredilmesi.

    @PostMapping
    public ResponseEntity<String> test() {
        // User creation logic

        // test methodu her tetiklendiğinde heap de yep yeni bir referans oluşur @srpBestAccount1
        // Request bitince refernce null döner GC bunu işaretler temizlemek için.
        SrpBestAccount sa = new SrpBestAccount(new EmailSender(), new Logger()); // DI
        sa.setBalance(new BigDecimal("20000"));
        sa.tranfer(new java.math.BigDecimal("15000"), "878711212-21212");


        return ResponseEntity.ok("User created successfully");
    }

}
