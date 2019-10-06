package edu.nhs.wsaams.controller;

import edu.nhs.wsaams.entity.LoginUser;
import edu.nhs.wsaams.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:3000")
public class LoginController {

    @Autowired
    LoginService service;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @PostMapping(path="/user", consumes = "application/json", produces = "application/json")
    public LoginUser isValidUser(@RequestBody LoginUser loginUser){
        System.out.println(loginUser.getUsername());
        System.out.println(loginUser.getPassword());
        return service.validate(loginUser);
    }

    @GetMapping("/view")
    public List<LoginUser> view(){
        return service.viewLoginUsers();
    }
}
