package com.mrtlptkn.javasolidprinciples.controller;


import com.mrtlptkn.javasolidprinciples.dto.FeeRequest;
import com.mrtlptkn.javasolidprinciples.dto.Money;
import com.mrtlptkn.javasolidprinciples.ocp.bestpractice.FeeEngine;
import com.mrtlptkn.javasolidprinciples.ocp.bestpractice.PremiumFee;
import com.mrtlptkn.javasolidprinciples.ocp.bestpractice.StandartFee;
import com.mrtlptkn.javasolidprinciples.ocp.bestpractice.VipFee;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.MBeanExportOperations;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/ocp")
public class OCPController {

    // DI ile IoC tanıtılmış olan FeeEngine erişip
    private final FeeEngine feeEngine;
    private final MBeanExportOperations mBeanExportOperations;

    public OCPController(FeeEngine feeEngine, MBeanExportOperations mBeanExportOperations) {
        this.feeEngine = feeEngine;
        this.mBeanExportOperations = mBeanExportOperations;
    }



    @PostMapping("fee")
    public ResponseEntity<String> calculateFee(@RequestBody FeeRequest request) {
        // DDD yoksa çok kullanılmaz ama Domain Driven Design varsa yaygın kullanım adı ValueObjectir.
//        Money money = new Money(request.unitPrice(), "USD");
//        Money money1 = new Money(request.unitPrice(), "TL");
//
//
//        money1.equals(money); // value olarak 100 $ ile 100 TL aynı şey olmadığında değer false döner.


       BigDecimal listPrice = feeEngine.calculateFee(request.feeType(), request.unitPrice());
        return ResponseEntity.ok("Calculated Fee" + listPrice);
    }



}
