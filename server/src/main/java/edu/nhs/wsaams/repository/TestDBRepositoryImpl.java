package edu.nhs.wsaams.repository;

import edu.nhs.wsaams.repository.statement.TestDBStatements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestDBRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getCurrentTime() {
        return jdbcTemplate.queryForObject(TestDBStatements.GET_CURRENT_DATE, String.class);
    }
}
