package edu.nhs.wsaams.controller.implementation;

import edu.nhs.wsaams.controller.GradeController;
import edu.nhs.wsaams.entity.Grade;
import edu.nhs.wsaams.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/grade")
@CrossOrigin("http://localhost:3000")
public class GradeControllerImpl implements GradeController {

    @Autowired
    private GradeService service;
    private static final Map<String, String> controllers = new HashMap<>();

    static {
        controllers.put("/hello", "GET");
        controllers.put("/init", "GET");
        controllers.put("/view", "GET");
        controllers.put("/removeAll", "GET");
        controllers.put("/create", "POST-Grade");
        controllers.put("/id", "PUT-id");
        controllers.put("/empId", "PUT-empId");
        controllers.put("/status", "PUT-status");
        controllers.put("/remove", "PUT-id");
        controllers.put("/updateEmployeeId", "POST-id | employeeId");
        controllers.put("/updateStatus", "POST-id | status");
    }

    @Override
    @GetMapping("/hello")
    public String hello() {
        return "Welcome to Login Controller and Controllers are" + controllers.toString();
    }

    @Override
    @GetMapping("/init")
    public String create() {
        return service.init();
    }

    @Override
    @GetMapping("/view")
    public List<Grade> view() {
        return service.getAll();
    }

    @Override
    @DeleteMapping("/removeAll")
    public String removeAll() {
        return service.deleteAll();
    }

    @Override
    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public String create(@RequestBody Grade grade) {
        return service.save(grade);
    }

    @Override
    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public Grade viewById(@PathVariable String id) {
        return service.getById(id);
    }

    @Override
    @PutMapping(path = "/empId/{empId}", consumes = "application/json", produces = "application/json")
    public List<Grade> viewByEmployeeId(@PathVariable String empId) {
        return service.getByEmployeeId(empId);
    }

    @Override
    @PutMapping(path = "/status/{status}", consumes = "application/json", produces = "application/json")
    public List<Grade> viewByStatus(@PathVariable String status) {
        return service.getByStatus(status);
    }

    @Override
    @DeleteMapping(path = "/remove/{id}", consumes = "application/json", produces = "application/json")
    public String removeById(@PathVariable String id) {
        return service.delete(id);
    }

    @Override
    @PostMapping(path = "/updateEmpId", consumes = "application/json", produces = "application/json")
    public String updateEmployeeId(@RequestBody Grade grade) {
        return service.updateEmployeeId(grade.getId(), grade.getEmployeeId());
    }

    @Override
    @PostMapping(path = "/updateStatus", consumes = "application/json", produces = "application/json")
    public String updateStatus(@RequestBody Grade grade) {
        return service.updateStatus(grade.getId(), grade.getStatus());
    }

}
