package edu.nhs.wsaams.repository;

import edu.nhs.wsaams.entity.LoginUser;
import edu.nhs.wsaams.repository.mapper.LoginUserRowMapper;
import edu.nhs.wsaams.repository.statement.LoginUserStatements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public boolean findLoginUser(String username) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username",username);
        return 1 == namedParameterJdbcTemplate.queryForObject(LoginUserStatements.FIND_BY_USERNAME, paramMap, Long.class);
    }

    @Override
    public boolean findLoginUser(String username, String password) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username",username);
        paramMap.put("password",password);
        return 1 == namedParameterJdbcTemplate.queryForObject(LoginUserStatements.FIND_BY_USERNAME_PASSWORD, paramMap, Long.class);
    }

    @Override
    public List<LoginUser> findAll() {
        return jdbcTemplate.query(LoginUserStatements.FIND_ALL,new LoginUserRowMapper());
    }
}
