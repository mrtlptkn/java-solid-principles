package com.mrtlptkn.javasolidprinciples.dip.bestpractice;
import com.mrtlptkn.javasolidprinciples.isp.bestpractice.CheckingAccount;


import java.math.BigDecimal;

// JPARepository Seçtik -> Hibernate -> MongoDB (1000 referances code base)
// Event gönderimi -> RabbitMQ  -> Kafka -> (Kafka Streams, Kakfa Binder)
// FraudDector için ise -> Servis (Manuel bir servis içerisinde yapalım) -> Pyhton tabanlı AI sistemi kullancağız.
// DEadline -> 10 gün  -> Paralelde iş geliştirmesi var.

// Not: DIP diğer tüm solid prensiplerinde farklı oalrak alınan kararlar tüm uygulamada bir refactor süreci başlatır.

// CheckingAccountMoneyTransfer -> DIP göre  IEventPublisher üzerinden bir sınıf ile konuşacak isem
// bu drumda IEventPublisher dan implemente olan herhangi bir sınıf ile rahatça çalışabilirim.
// IEventPublisher yazınca istersem KafkaEventPublisher istersem InMemoryEventPublisher gibi sınıflar ile ve daha fazlasını CheckingAccountMoneyTransfer sınıfı altyapı olarak destekler.

// Hedef -> CheckingAccountMoneyTransfer içerisinde değişiklik yapmadan istedeğim kadar IEventPublisher,ICheckingAccountRepository,IFraudDetector türeyen sınıflar ile iletişim kurabilmek.

public class CheckingAccountMoneyTransfer implements ICheckingAccountMoneyTransfer {

    private final IEventPublisher eventPublisher;
    private final ICheckingAccountRepository checkingAccountRepository;
    private final IFraudDetector fraudDetector;

    public CheckingAccountMoneyTransfer(ICheckingAccountRepository checkingAccountRepository, IEventPublisher eventPublisher, IFraudDetector fraudDetector) {
        this.checkingAccountRepository = checkingAccountRepository;
        this.eventPublisher = eventPublisher;
        this.fraudDetector = fraudDetector;
    }


    @Override
    public void transferMoney(CheckingAccount source, CheckingAccount target, BigDecimal amount) {

        if (fraudDetector.isSuspiciousTransaction("Birikim hesabından vadesiz hesaba para işlemi",amount)) {
            System.out.println("Fraud detected! Transfer aborted.");
            return;
        }
        // 2. Para transferi
        source.debit(amount);
        target.credit(amount);

        // 3. Veritabanına kaydet
        checkingAccountRepository.save(source);
        checkingAccountRepository.save(target);

        // 4. Olay yayınla
        eventPublisher.publishEvent("source : -> " + source.getAccountNumber() + " target : ->" + target.getAccountNumber() + "miktar -> " + amount  + "para transfer edildi");

        System.out.println("Transfer completed successfully.");
    }

    // private final JPAAccountRepository acc = new  JPAAccountRepository();
    // private final RabbitMQEventPublisher eventPublisher = new RabbitMQEventPublisher();
    // private final FraudDetector fraudDetector = new FraudDetector();

    // 1. kayıt altına almamız gerekir -> Repository Pattern (CRUD) -> save,update,delete,find
    // 2. para transfer edilince event tetiklensin sıralı mail atma işlemi yapalım -> EventPublisher
    // 3. Para gönderiminin riskli olup olmadığını kontrol eden bir servis yapısı olduğunu düşünelim -> Dolandırılcık tespiti yapacak bir alt yapıya ihtiyacımız olsun -> FraudDetector

}
