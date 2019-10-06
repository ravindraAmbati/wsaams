package edu.nhs.wsaams.repository;

import edu.nhs.wsaams.entity.LoginUser;

import java.util.List;

public interface LoginRepository {
    boolean findLoginUser(String username);

    boolean findLoginUser(String username, String password);

    List<LoginUser> findAll();
}
