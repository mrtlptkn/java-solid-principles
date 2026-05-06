package com.mrtlptkn.javasolidprinciples.controller;

import com.mrtlptkn.javasolidprinciples.dip.badpractice.BadCheckingTransferOrchestrator;
import com.mrtlptkn.javasolidprinciples.dip.bestpractice.CheckingAccountMoneyTransfer;
import com.mrtlptkn.javasolidprinciples.dip.bestpractice.ICheckingAccountRepository;
import com.mrtlptkn.javasolidprinciples.dip.bestpractice.IEventPublisher;
import com.mrtlptkn.javasolidprinciples.dip.bestpractice.IFraudDetector;
import com.mrtlptkn.javasolidprinciples.dip.bestpractice.frauds.ALFraudDetector;
import com.mrtlptkn.javasolidprinciples.dip.bestpractice.frauds.RuleBasedCustomFraudDetector;
import com.mrtlptkn.javasolidprinciples.dip.bestpractice.publishers.InMemoryEventPublisher;
import com.mrtlptkn.javasolidprinciples.dip.bestpractice.publishers.KafkaEventPublisher;
import com.mrtlptkn.javasolidprinciples.dip.bestpractice.repositories.InMemoryCheckingAccountRepository;
import com.mrtlptkn.javasolidprinciples.dip.bestpractice.repositories.NoSqlCheckingAccountRepository;
import com.mrtlptkn.javasolidprinciples.isp.bestpractice.CheckingAccount;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/dip")
public class DIPController {

    @PostMapping("bestpractice")
    public String bestPractice(){

        // 1. variant
        ICheckingAccountRepository ns1 = new NoSqlCheckingAccountRepository();
        IEventPublisher ep1 = new InMemoryEventPublisher();
        IFraudDetector fd1 = new RuleBasedCustomFraudDetector();

      CheckingAccountMoneyTransfer ck = new CheckingAccountMoneyTransfer(ns1,ep1,fd1);
      ck.transferMoney(new CheckingAccount(), new CheckingAccount(), BigDecimal.valueOf(100));

      // Not -> Adapter tasarım deseni yaptık. Yani sürecimizi farklı altyapılara adapte ettik. Buda bir yapısal structural bir tasarım deseni

        // 2. variant
        ICheckingAccountRepository ns2 = new InMemoryCheckingAccountRepository();
        IEventPublisher ep2 = new KafkaEventPublisher();
        IFraudDetector fd2 = new ALFraudDetector();

        CheckingAccountMoneyTransfer ck2 = new CheckingAccountMoneyTransfer(ns2,ep2,fd2);
        ck2.transferMoney(new CheckingAccount(), new CheckingAccount(), BigDecimal.valueOf(100));

        return "Best Practice DIP";
    }



    @PostMapping("badpractice")
    public String badPractice(){

        CheckingAccount source = new CheckingAccount();
        CheckingAccount target = new CheckingAccount();
        BigDecimal amount = BigDecimal.valueOf(100);

        BadCheckingTransferOrchestrator badCheckingTransferOrchestrator = new BadCheckingTransferOrchestrator();
        badCheckingTransferOrchestrator.transfer(source,target, amount);



        return "DIP Bad Practice";
    }


}
