package com.mrtlptkn.javasolidprinciples.srp.bestpractice;


// SRPAccounting'e özgü bir kod değil istenilen her yerde çağırılabilir.
// Tek başına test edilebilir.

import org.springframework.stereotype.Component;


public class Logger {
    public void log(String message) {
        // Loglama işlemi burada gerçekleştirilir
        System.out.println("Log: " + message);
    }
}
