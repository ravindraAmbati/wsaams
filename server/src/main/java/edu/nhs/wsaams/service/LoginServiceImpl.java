package edu.nhs.wsaams.service;

import edu.nhs.wsaams.entity.Loginuser;
import edu.nhs.wsaams.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository repository;

    @Override
    public String validate(Loginuser loginUser) {
        boolean isValidLoginuser;
        try {
            isValidLoginuser = repository.isValidUser(loginUser.getUsername()) ? repository.isValidUser(loginUser.getUsername(), loginUser.getPassword()) : false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Something went wrong" + e.getMessage();
        }
        return isValidLoginuser ? loginUser.getUsername() + " is valid username" : "wrong credentials";
    }

    @Override
    public List<Loginuser> getAll() {
        return repository.findAll();
    }

    @Override
    public String save(Loginuser loginUser) {
        boolean flag = repository.save(loginUser);
        String id = this.getByUsername(loginUser).getId();
        String successMessage = "Login User has been successfully created with ID: " + id;
        String failedMessage = "Login User is failed to create";
        return flag ? successMessage : failedMessage;
    }

    @Override
    public Loginuser getById(Loginuser loginUser) {
        return repository.findById(loginUser.getId());
    }

    @Override
    public Loginuser getByUsername(Loginuser loginUser) {
        return repository.findByUsername(loginUser.getUsername());
    }

    @Override
    public List<Loginuser> getByStatus(Loginuser loginUser) {
        return repository.findByStatus(loginUser.getStatus());
    }

    @Override
    public List<Loginuser> getByLastAttemptStatus(Loginuser loginUser) {
        return repository.findByLastAttemptStatus(loginUser.getLastAttemptStatus());
    }

    @Override
    public String delete(Loginuser loginUser) {
        boolean flag = repository.delete(loginUser.getId());
        String successMessage = "Login User has been successfully deleted of ID: " + loginUser.getId();
        String failedMessage = "Login User is failed to delete";
        return flag ? successMessage : failedMessage;
    }

    @Override
    public String updatePassword(Loginuser loginUser) {
        boolean flag = repository.updatePassword(loginUser.getId(), loginUser.getPassword());
        String successMessage = "Login User's password is update successfully of ID: " + loginUser.getId();
        String failedMessage = "Login User's password is failed to update";
        return flag ? successMessage : failedMessage;
    }

    @Override
    public String updateStatus(Loginuser loginUser) {
        boolean flag = repository.updateStatus(loginUser.getId(), loginUser.getStatus());
        String successMessage = "Login User's status is update successfully of ID: " + loginUser.getId();
        String failedMessage = "Login User's status is failed to update";
        return flag ? successMessage : failedMessage;
    }

    @Override
    public String deleteAll() {
        int noOfRecordsDeleted = repository.cleanUp();
        return noOfRecordsDeleted + " records has been deleted successfully";
    }

}
