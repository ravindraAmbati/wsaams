package edu.nhs.wsaams.repository;

import edu.nhs.wsaams.entity.Loginuser;

import java.util.List;

public interface Repository<T> {

    boolean create();

    List<T> findAll();

    boolean save(T t);

    T findById(String id);

    List<T> findByName(String name);

    List<T> findByStatus(String status);

    boolean delete(String id);

    boolean updateStatus(String id, String status);

    int cleanUp();
}
