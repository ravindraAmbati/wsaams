package edu.nhs.wsaams.repository;

import edu.nhs.wsaams.entity.Loginuser;

import java.util.List;

public interface LoginRepository extends Repository<Loginuser>{

    boolean isValidUser(String username);

    boolean isValidUser(String username, String password);

    Loginuser findByUsername(String username);

    List<Loginuser> findByLastAttemptStatus(String lastAttemptStatus);

    boolean updatePassword(String id, String password);
}
