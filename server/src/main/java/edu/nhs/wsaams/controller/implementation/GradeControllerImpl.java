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
        controllers.put("/id", "POST-id");
        controllers.put("/empId", "POST-empId");
        controllers.put("/status", "POST-status");
        controllers.put("/remove", "POST-id");
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
    @GetMapping("/removeAll")
    public String removeAll() {
        return service.deleteAll();
    }

    @Override
    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public String create(@RequestBody Grade grade) {
        return service.save(grade);
    }

    @Override
    @PostMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public Grade viewById(@RequestBody Grade grade) {
        return service.getById(grade.getId());
    }

    @Override
    @PostMapping(path = "/empId", consumes = "application/json", produces = "application/json")
    public List<Grade> viewByEmployeeId(@RequestBody Grade grade) {
        return service.getByEmployeeId(grade.getEmployeeId());
    }

    @Override
    @PostMapping(path = "/status", consumes = "application/json", produces = "application/json")
    public List<Grade> viewByStatus(@RequestBody Grade grade) {
        return service.getByStatus(grade.getStatus());
    }

    @Override
    @PostMapping(path = "/remove", consumes = "application/json", produces = "application/json")
    public String removeById(@RequestBody Grade grade) {
        return service.delete(grade.getId());
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
