package com.mrtlptkn.javasolidprinciples.dip.badpractice;


// Source: SavingAccount -> Vadesiz hesabıumızdan başkasının vadesiz hesabına  para aktarımı yapıyoruz.

import com.mrtlptkn.javasolidprinciples.isp.bestpractice.CheckingAccount;

import java.math.BigDecimal;

// Transfer Orchectrator -> High level module
// MongoDbCheckingAccountRepository -> low Level
// Low Level High levela bağımlı olmayacak.

// Transfer sürecini yöneten servis olsun
public class BadCheckingTransferOrchestrator {
    //private final JpaCheckingAccountRepository checkingAccountRepository = new JpaCheckingAccountRepository();

    private final MongoDbCheckingAccountRepository checkingAccountRepository = new MongoDbCheckingAccountRepository();

    private final RuleBasedFraudDetector fraudDetector = new RuleBasedFraudDetector();
    private final RabbitMqEventPublisher eventPublisher = new RabbitMqEventPublisher();

    public void transfer(CheckingAccount source, CheckingAccount target, BigDecimal amount) {
        // 1. Fraud kontrolü
        if (fraudDetector.isSuspiciousTransaction("Birikim hesabından vadesiz hesaba para işlemi",amount)) {
            System.out.println("Fraud detected! Transfer aborted.");
            return;
        }
        // 2. Para transferi
        source.debit(amount);
        target.credit(amount);

        // 3. Veritabanına kaydet
        checkingAccountRepository.saveCollection(source);
        checkingAccountRepository.saveCollection(target);

        // 4. Olay yayınla
        eventPublisher.publishEvent("source : -> " + source.getAccountNumber() + " target : ->" + target.getAccountNumber() + "miktar -> " + amount  + "para transfer edildi");

        System.out.println("Transfer completed successfully.");
    }



}
