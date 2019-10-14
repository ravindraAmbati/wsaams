package edu.nhs.wsaams.controller.implementation;

import edu.nhs.wsaams.controller.LoginController;
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
public class LoginControllerImpl implements LoginController {

    @Autowired
    private LoginService service;
    private static final Map<String, String> controllers = new HashMap<>();

    static {
        controllers.put("/hello", "GET");
        controllers.put("/init", "GET");
        controllers.put("/view", "GET");
        controllers.put("/removeAll", "GET");
        controllers.put("/validate", "POST-Loginuser");
        controllers.put("/create", "POST-Loginuser");
        controllers.put("/id", "PUT-id");
        controllers.put("/username", "PUT-username");
        controllers.put("/status", "PUT-status");
        controllers.put("/lastAttemptStatus", "PUT-lastAttemptStatus");
        controllers.put("/remove", "PUT-id");
        controllers.put("/updatePassword", "POST-id | password");
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
        return service.create();
    }

    @Override
    @GetMapping("/view")
    public List<Loginuser> view() {
        return service.getAll();
    }

    @Override
    @DeleteMapping("/removeAll")
    public String removeAll() {
        return service.deleteAll();
    }

    @Override
    @PostMapping(path = "/validate", consumes = "application/json", produces = "application/json")
    public String isValidUser(@RequestBody Loginuser loginUser) {
        return service.validate(loginUser.getUsername(), loginUser.getPassword());
    }

    @Override
    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public String create(@RequestBody Loginuser loginUser) {
        return service.save(loginUser);
    }

    @Override
    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public Loginuser viewById(@PathVariable String id) {
        return service.getById(id);
    }

    @Override
    @PutMapping(path = "/username/{username}", consumes = "application/json", produces = "application/json")
    public Loginuser viewByUsername(@PathVariable String username) {
        return service.getByUsername(username);
    }

    @Override
    @PutMapping(path = "/status/{status}", consumes = "application/json", produces = "application/json")
    public List<Loginuser> viewByStatus(@PathVariable String status) {
        return service.getByStatus(status);
    }

    @Override
    @PutMapping(path = "/lastAttemptStatus/{lastAttemptStatus}", consumes = "application/json", produces = "application/json")
    public List<Loginuser> viewByLastAttemptStatus(@PathVariable String lastAttemptStatus) {
        return service.getByLastAttemptStatus(lastAttemptStatus);
    }

    @Override
    @DeleteMapping(path = "/remove/{id}", consumes = "application/json", produces = "application/json")
    public String removeById(@PathVariable String id) {
        return service.delete(id);
    }

    @Override
    @PostMapping(path = "/updatePassword", consumes = "application/json", produces = "application/json")
    public String updatePassword(@RequestBody Loginuser loginUser) {
        return service.updatePassword(loginUser.getId(), loginUser.getPassword());
    }

    @Override
    @PostMapping(path = "/updateStatus", consumes = "application/json", produces = "application/json")
    public String updateStatus(@RequestBody Loginuser loginUser) {
        return service.updateStatus(loginUser.getId(), loginUser.getStatus());
    }
}
