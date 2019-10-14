package edu.nhs.wsaams.service.implementation;

import edu.nhs.wsaams.entity.Loginuser;
import edu.nhs.wsaams.repository.LoginRepository;
import edu.nhs.wsaams.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository repository;

    @Override
    public String validate(String username, String password) {
        boolean isValidLoginuser;
        try {
            isValidLoginuser = repository.isValidUser(username) ? repository.isValidUser(username, password) : false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Something went wrong" + e.getMessage();
        }
        return isValidLoginuser ? username + " is valid username" : "wrong credentials";
    }

    @Override
    public String create() {
        boolean flag = repository.create();
        String successMessage = "Table Grade is created successfully";
        String failedMessage = "Table Grade is failed to create";
        return flag ? successMessage : failedMessage;
    }

    @Override
    public List<Loginuser> getAll() {
        return repository.findAll();
    }

    @Override
    public String save(Loginuser loginUser) {
        boolean flag = repository.save(loginUser);
        String id = this.getByUsername(loginUser.getUsername()).getId();
        String successMessage = "Login User has been successfully created with ID: " + id;
        String failedMessage = "Login User is failed to create";
        return flag ? successMessage : failedMessage;
    }

    @Override
    public Loginuser getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Loginuser> getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Loginuser getByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public List<Loginuser> getByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public List<Loginuser> getByLastAttemptStatus(String lastAttemptStatus) {
        return repository.findByLastAttemptStatus(lastAttemptStatus);
    }

    @Override
    public String delete(String id) {
        boolean flag = repository.delete(id);
        String successMessage = "Login User has been successfully deleted of ID: " + id;
        String failedMessage = "Login User is failed to delete";
        return flag ? successMessage : failedMessage;
    }

    @Override
    public String updatePassword(String id, String password) {
        boolean flag = repository.updatePassword(id, password);
        String successMessage = "Login User's password is update successfully of ID: " + id;
        String failedMessage = "Login User's password is failed to update";
        return flag ? successMessage : failedMessage;
    }

    @Override
    public String updateStatus(String id, String status) {
        boolean flag = repository.updateStatus(id, status);
        String successMessage = "Login User's status is update successfully of ID: " + id;
        String failedMessage = "Login User's status is failed to update";
        return flag ? successMessage : failedMessage;
    }

    @Override
    public String deleteAll() {
        int noOfRecordsDeleted = repository.cleanUp();
        return noOfRecordsDeleted + " records has been deleted successfully";
    }

    @Override
    public String init() {
        return repository.create() ? "Table is created successfully" : "failed to create";
    }

}
