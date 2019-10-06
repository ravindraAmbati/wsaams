package edu.nhs.wsaams.service;

import edu.nhs.wsaams.entity.LoginUser;
import edu.nhs.wsaams.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository repository;

    @Override
    public LoginUser validate(LoginUser loginUser) {
        loginUser.setValidLoginUser(repository.findLoginUser(loginUser.getUsername()));
        loginUser.setValidAuthentication(loginUser.isValidLoginUser() ? repository.findLoginUser(loginUser.getUsername(), loginUser.getPassword()) : false);
        return loginUser;
    }

    @Override
    public List<LoginUser> viewLoginUsers() {
        return repository.findAll();
    }

}
