package edu.nhs.wsaams.controller;

import edu.nhs.wsaams.service.TestDBServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testdb")
@CrossOrigin("http://localhost:3000")
public class TestDBController {

    @Autowired
    private TestDBServicesImpl service;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/time")
    public String getCurrentTime(){
        return service.getCurrentTimeFromDB();
    }

}
