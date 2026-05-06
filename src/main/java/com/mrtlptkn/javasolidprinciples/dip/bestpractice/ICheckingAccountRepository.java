package com.mrtlptkn.javasolidprinciples.dip.bestpractice;

import com.mrtlptkn.javasolidprinciples.isp.bestpractice.CheckingAccount;


// Not: com.mrtlptkn.javasolidprinciples.isp.badpractice ve bestpractice de var. Bu sebeple biz bestpractice örneğindekini seçtik.  CheckingAccount

public interface ICheckingAccountRepository extends IRepository<CheckingAccount> {

}
