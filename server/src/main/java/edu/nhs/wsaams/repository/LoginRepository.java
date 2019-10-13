package edu.nhs.wsaams.repository;

import edu.nhs.wsaams.entity.Loginuser;

import java.util.List;

public interface LoginRepository {

    boolean isValidUser(String username);

    boolean isValidUser(String username, String password);

    List<Loginuser> findAll();

    boolean save(Loginuser loginUser);

    Loginuser findById(String id);

    Loginuser findByUsername(String username);

    List<Loginuser> findByStatus(String status);

    List<Loginuser> findByLastAttemptStatus(String lastAttemptStatus);

    boolean delete(String id);

    boolean updatePassword(String id, String password);

    boolean updateStatus(String id, String status);

    int cleanUp();
}
