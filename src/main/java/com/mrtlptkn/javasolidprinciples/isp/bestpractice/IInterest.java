package com.mrtlptkn.javasolidprinciples.isp.bestpractice;

// Faiz uygulanacak tüm hesaplarda çağırılabilir
public interface IInterest {

    void applyInterest(float interestRate);
    float getInterestRate();
}
