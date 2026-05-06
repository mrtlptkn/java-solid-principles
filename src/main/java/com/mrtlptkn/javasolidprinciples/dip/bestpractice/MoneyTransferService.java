package com.mrtlptkn.javasolidprinciples.dip.bestpractice;

import com.mrtlptkn.javasolidprinciples.isp.bestpractice.IAccount;

import java.math.BigDecimal;

public class MoneyTransferService implements IMoneyTransfer {

    // private final JPAAccountRepository acc = new  JPAAccountRepository();
    // private final RabbitMQEventPublisher eventPublisher = new RabbitMQEventPublisher();
    // private final FraudDetector fraudDetector = new FraudDetector();

    // 1. kayıt altına almamız gerekir -> Repository Pattern (CRUD) -> save,update,delete,find
    // 2. para transfer edilince event tetiklensin sıralı mail atma işlemi yapalım -> EventPublisher
    // 3. Para gönderiminin riskli olup olmadığını kontrol eden bir servis yapısı olduğunu düşünelim -> Dolandırılcık tespiti yapacak bir alt yapıya ihtiyacımız olsun -> FraudDetector

    @Override
    public void transferMoney(IAccount source, IAccount target, BigDecimal amount) {

        // JPARepository Seçtik -> Hibernate -> MongoDB (1000 referances code base)
        // Event gönderimi -> RabbitMQ  -> Kafka -> (Kafka Streams, Kakfa Binder)
        // FraudDector için ise -> Servis (Manuel bir servis içerisinde yapalım) -> Pyhton tabanlı AI sistemi kullancağız.
        // DEadline -> 10 gün  -> Paralelde iş geliştirmesi var.


        // Not: DIP diğer tüm solid prensiplerinde farklı oalrak alınan kararlar tüm uygulamada bir refactor süreci başlatır.

    }
}
