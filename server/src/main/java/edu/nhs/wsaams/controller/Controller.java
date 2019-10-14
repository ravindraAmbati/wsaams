package edu.nhs.wsaams.controller;

import java.util.List;

public interface Controller<T> {
    
    String hello();

    String create();
    
    List<T> view(); 
    
    String removeAll();
    
    String create(T t); 
    
    T viewById(String id);
    
    List<T> viewByStatus(String status);
    
    String removeById(String id);

    String updateStatus(T t);
}
