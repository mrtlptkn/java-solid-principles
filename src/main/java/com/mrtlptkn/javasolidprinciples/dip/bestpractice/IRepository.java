package com.mrtlptkn.javasolidprinciples.dip.bestpractice;


// Generic Repository

public interface IRepository<T> {

    void save(T entity);

    T findById(String id);
}
