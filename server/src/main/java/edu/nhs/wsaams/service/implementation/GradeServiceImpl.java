package edu.nhs.wsaams.service.implementation;

import edu.nhs.wsaams.entity.Grade;
import edu.nhs.wsaams.repository.GradeRepository;
import edu.nhs.wsaams.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeRepository repository;

    @Override
    public List<Grade> getByEmployeeId(String id) {
        return repository.findByEmployeeId(id);
    }

    @Override
    public String updateEmployeeId(String id, String employeeId) {
        boolean flag = repository.updateEmployeeId(id, employeeId);
        String successMessage = "Grade's employeeId is updated successfully of ID: " + id;
        String failedMessage = "Grade's employeeId is failed to update";
        return flag ? successMessage : failedMessage;
    }

    @Override
    public String create() {
        boolean flag = repository.create();
        String successMessage = "Table Grade is created successfully";
        String failedMessage = "Table Grade is failed to create";
        return flag ? successMessage : failedMessage;
    }

    @Override
    public List<Grade> getAll() {
        return repository.findAll();
    }

    @Override
    public String save(Grade grade) {
        boolean flag = repository.save(grade);
        String id = ((List<Grade>) this.getByName(grade.getName())).get(0).getId();
        String successMessage = "Grade has been successfully created with ID: " + id;
        String failedMessage = "Grade is failed to create";
        return flag ? successMessage : failedMessage;
    }

    @Override
    public Grade getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Grade> getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Grade> getByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public String delete(String id) {
        boolean flag = repository.delete(id);
        String successMessage = "Grade has been successfully deleted of ID: " + id;
        String failedMessage = "Grade is failed to delete";
        return flag ? successMessage : failedMessage;
    }

    @Override
    public String updateStatus(String id, String status) {
        boolean flag = repository.updateStatus(id, status);
        String successMessage = "Grade's status is update successfully of ID: " + id;
        String failedMessage = "Grade's status is failed to update";
        return flag ? successMessage : failedMessage;
    }

    @Override
    public String deleteAll() {
        int noOfRecordsDeleted = repository.cleanUp();
        return noOfRecordsDeleted + " records has been deleted successfully";
    }

    @Override
    public String init() {
        return repository.create() ? "Table created successfully" : "Failed to create table";
    }
}
