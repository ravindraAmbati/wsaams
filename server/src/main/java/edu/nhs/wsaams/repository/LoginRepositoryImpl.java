package edu.nhs.wsaams.repository;

import edu.nhs.wsaams.entity.DBLog;
import edu.nhs.wsaams.entity.Loginuser;
import edu.nhs.wsaams.repository.mapper.LoginUserRowMapper;
import edu.nhs.wsaams.repository.statement.LoginuserStatements;
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
    public boolean isValidUser(String username) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        return 1 == namedParameterJdbcTemplate.queryForObject(LoginuserStatements.IS_USERNAME_EXISTS, paramMap, Long.class);
    }

    @Override
    public boolean isValidUser(String username, String password) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        paramMap.put("password", password);
        return 1 == namedParameterJdbcTemplate.queryForObject(LoginuserStatements.IS_USERNAME_PASSWORD_EXISTS, paramMap, Long.class);
    }

    @Override
    public List<Loginuser> findAll() {
        return jdbcTemplate.query(LoginuserStatements.FIND_ALL, new LoginUserRowMapper());
    }

    @Override
    public boolean save(Loginuser loginUser) {
        DBLog dbLog = DBLog.getDBLog(loginUser.getId());
        loginUser.setDBLog(dbLog);
        return 1 == jdbcTemplate.update(LoginuserStatements.SAVE, loginUser.getId(), loginUser.getUsername(), loginUser.getPassword(), loginUser.getStatus(), loginUser.getLoginTime(), loginUser.getLogoffTime(), loginUser.getLastAttemptStatus(), loginUser.getDBLog().getTimestamp(), loginUser.getDBLog().getApplication(), loginUser.getDBLog().getMachineName(), loginUser.getDBLog().getUserId());
    }

    @Override
    public Loginuser findById(String id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return namedParameterJdbcTemplate.queryForObject(LoginuserStatements.FIND_BY_ID, paramMap, new LoginUserRowMapper());
    }

    @Override
    public Loginuser findByUsername(String username) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        return namedParameterJdbcTemplate.queryForObject(LoginuserStatements.FIND_BY_USERNAME, paramMap, new LoginUserRowMapper());
    }

    @Override
    public List<Loginuser> findByStatus(String status) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("status", status);
        return namedParameterJdbcTemplate.query(LoginuserStatements.FIND_BY_STATUS, paramMap, new LoginUserRowMapper());
    }

    @Override
    public List<Loginuser> findByLastAttemptStatus(String lastAttemptStatus) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("lastattemptstatus", lastAttemptStatus);
        return namedParameterJdbcTemplate.query(LoginuserStatements.FIND_BY_LAST_ATTEMPT_STATUS, paramMap, new LoginUserRowMapper());
    }

    @Override
    public boolean delete(String id) {
        return 1 == jdbcTemplate.update(LoginuserStatements.DELETE, id);
    }

    @Override
    public boolean updatePassword(String id, String password) {
        return 1 == jdbcTemplate.update(LoginuserStatements.UPDATE_PASSWORD, password, id);
    }

    @Override
    public boolean updateStatus(String id, String status) {
        return 1 == jdbcTemplate.update(LoginuserStatements.UPDATE_STATUS, status, id);
    }

    @Override
    public int cleanUp() {
        return jdbcTemplate.update(LoginuserStatements.CLEAN_UP);
    }
}
