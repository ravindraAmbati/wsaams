package edu.nhs.wsaams.service;

import edu.nhs.wsaams.entity.LoginUser;

import java.util.List;

public interface LoginService {
    LoginUser validate(LoginUser loginUser);

    List<LoginUser> viewLoginUsers();
}
