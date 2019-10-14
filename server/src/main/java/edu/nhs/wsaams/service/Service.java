package edu.nhs.wsaams.service;

import java.util.List;

public interface Service<T> {

    String create();

    List<T> getAll();

    String save(T t);

    T getById(String id);

    List<T> getByName(String name);

    List<T> getByStatus(String status);

    String delete(String id);

    String updateStatus(String id, String status);

    String deleteAll();

    String init();
}
