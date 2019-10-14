package edu.nhs.wsaams.service.implementation;

import edu.nhs.wsaams.repository.implementation.TestDBRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDBServicesImpl {

    @Autowired
    private TestDBRepositoryImpl repository;

    public String getCurrentTimeFromDB() {
        return repository.getCurrentTime();
    }
}
