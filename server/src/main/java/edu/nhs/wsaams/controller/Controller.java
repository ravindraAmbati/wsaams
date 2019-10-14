package edu.nhs.wsaams.controller;

import java.util.List;

public interface Controller<T> {
    
    String hello();

    String create();
    
    List<T> view(); 
    
    String removeAll();
    
    String create(T t); 
    
    T viewById(T t);
    
    List<T> viewByStatus(T t);
    
    String removeById(T t);

    String updateStatus(T t);
}
