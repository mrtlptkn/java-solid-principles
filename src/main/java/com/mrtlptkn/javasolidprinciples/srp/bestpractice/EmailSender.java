package com.mrtlptkn.javasolidprinciples.srp.bestpractice;

// herhangi bir servis email logic yöntemek amaçlı çağırılabilir.

import org.springframework.stereotype.Component;


public class EmailSender {

    public void sendMessage(String to, String from, String message) {
        // Email gönderme işlemi burada gerçekleştirilir
        System.out.println("Email gönderildi: " + message + " To: " + to + " From: " + from);
    }

}
