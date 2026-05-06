package com.mrtlptkn.javasolidprinciples.controller;


import com.mrtlptkn.javasolidprinciples.lsp.badpractice.BadInvesmentAccount;
import com.mrtlptkn.javasolidprinciples.lsp.badpractice.BadSavingAccount;
import com.mrtlptkn.javasolidprinciples.lsp.badpractice.LspBadAccount;
import com.mrtlptkn.javasolidprinciples.lsp.bestpractice.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/lsp")
public class LSPController {


    @PostMapping("/badpractice")
    public String badPractice(){

        LspBadAccount ia = new BadInvesmentAccount(BigDecimal.valueOf(1000));
        // ia.debit(BigDecimal.valueOf(100)); // UnsupportedOperationException hatası fırlatır


        LspBadAccount sa = new BadSavingAccount(BigDecimal.valueOf(1000));
        sa.debit(BigDecimal.valueOf(100)); // günlük faiz oranı kadar paranın değerini artırır



        return "LSP Bad Practice";
    }

     @PostMapping("/bestpractice")
    public String bestPractice() {

         BestAccount ia = new BestInvestmentAccount(BigDecimal.valueOf(1000));
         ia.credit(BigDecimal.valueOf(100)); // para yatırma işlemi başarılı

          // LSP sağlanmış oldu.
         //IDebitable id2 = (IDebitable)ia;
         //id2.debit(BigDecimal.valueOf(50)); // para çekme işlemi başarılı

         BestAccount sa = new BestSavingAccount(BigDecimal.valueOf(1000));
         sa.credit(BigDecimal.valueOf(100)); // para yatırma işlemi başarılı


         IDebitable id = (IDebitable) sa;
         id.debit(BigDecimal.valueOf(50)); // para çekme işlemi başarılı

         IInterestable in  = (IInterestable)sa;
         in.applyInterest(); // faiz uygulama işlemi başarılı




         return "LSP Best Practice";
     }


}
