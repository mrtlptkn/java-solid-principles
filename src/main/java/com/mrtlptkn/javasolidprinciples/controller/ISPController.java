package com.mrtlptkn.javasolidprinciples.controller;

import com.mrtlptkn.javasolidprinciples.isp.bestpractice.CheckingAccount;
import com.mrtlptkn.javasolidprinciples.isp.bestpractice.IAccount;
import com.mrtlptkn.javasolidprinciples.isp.bestpractice.ICheckingAccount;
import com.mrtlptkn.javasolidprinciples.isp.bestpractice.IDebitable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;

@RestController
@RequestMapping("api/isp")
public class ISPController {

    @PostMapping("test")
    public String test(){


        ICheckingAccount ca = new CheckingAccount();
        ca.credit(BigDecimal.ZERO);

        IAccount aa = (IAccount) ca;
        aa.getAccountNumber();
        aa.getBalance();

        IDebitable db = (IDebitable) ca;
        db.debit(BigDecimal.ZERO);

        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Java");
        list.remove("World");


        return "ISP Controller";
    }



}



