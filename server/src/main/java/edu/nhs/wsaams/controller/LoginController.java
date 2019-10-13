package edu.nhs.wsaams.controller;

import edu.nhs.wsaams.entity.Loginuser;
import edu.nhs.wsaams.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:3000")
public class LoginController {

    @Autowired
    private LoginService service;
    private static final Map<String, String> controllers = new HashMap<>();

    static {
        controllers.put("/hello", "GET");
        controllers.put("/view", "GET");
        controllers.put("/removeAll", "GET");
        controllers.put("/validate", "POST-Loginuser");
        controllers.put("/create", "POST-Loginuser");
        controllers.put("/id", "POST-id");
        controllers.put("/username", "POST-id");
        controllers.put("/status", "POST-status");
        controllers.put("/lastAttemptStatus", "POST-lastAttemptStatus");
        controllers.put("/remove", "POST-id");
        controllers.put("/updatePassword", "POST-id | password");
        controllers.put("/updateStatus", "POST-id | status");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Welcome to Login Controller and Controllers are" + controllers.toString();
    }

    @GetMapping("/view")
    public List<Loginuser> view() {
        return service.getAll();
    }

    @GetMapping("/removeAll")
    public String removeAll() {
        return service.deleteAll();
    }

    @PostMapping(path = "/validate", consumes = "application/json", produces = "application/json")
    public String isValidUser(@RequestBody Loginuser loginUser) {
        return service.validate(loginUser);
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public String create(@RequestBody Loginuser loginUser) {
        return service.save(loginUser);
    }

    @PostMapping(path = "/id", consumes = "application/json", produces = "application/json")
    public Loginuser viewById(@RequestBody Loginuser loginUser) {
        return service.getById(loginUser);
    }

    @PostMapping(path = "/username", consumes = "application/json", produces = "application/json")
    public Loginuser viewByUsername(@RequestBody Loginuser loginUser) {
        return service.getByUsername(loginUser);
    }

    @PostMapping(path = "/status", consumes = "application/json", produces = "application/json")
    public List<Loginuser> viewByStatus(@RequestBody Loginuser loginUser) {
        return service.getByStatus(loginUser);
    }

    @PostMapping(path = "/lastAttemptStatus", consumes = "application/json", produces = "application/json")
    public List<Loginuser> viewByLastAttemptStatus(@RequestBody Loginuser loginUser) {
        return service.getByLastAttemptStatus(loginUser);
    }

    @PostMapping(path = "/remove", consumes = "application/json", produces = "application/json")
    public String removeById(@RequestBody Loginuser loginUser) {
        return service.delete(loginUser);
    }

    @PostMapping(path = "/updatePassword", consumes = "application/json", produces = "application/json")
    public String updatePassword(@RequestBody Loginuser loginUser) {
        return service.updatePassword(loginUser);
    }

    @PostMapping(path = "/updateStatus", consumes = "application/json", produces = "application/json")
    public String updateStatus(@RequestBody Loginuser loginUser) {
        return service.updateStatus(loginUser);
    }
}
