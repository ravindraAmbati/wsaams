package edu.nhs.wsaams.repository.implementation;

import edu.nhs.wsaams.entity.DBLog;
import edu.nhs.wsaams.entity.Grade;
import edu.nhs.wsaams.repository.GradeRepository;
import edu.nhs.wsaams.repository.mapper.GradeRowMapper;
import edu.nhs.wsaams.repository.statement.GradeStatements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GradeRepositoryImpl implements GradeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public GradeRepositoryImpl() {
    }

    public GradeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public GradeRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public GradeRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public boolean create() {
        this.jdbcTemplate.execute(GradeStatements.CREATE);
        return 0 == this.jdbcTemplate.queryForObject(GradeStatements.TEST,Long.class);
    }

    @Override
    public List<Grade> findAll() {
        return jdbcTemplate.query(GradeStatements.FIND_ALL, new GradeRowMapper());

    }

    @Override
    public Grade findById(String id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return namedParameterJdbcTemplate.queryForObject(GradeStatements.FIND_BY_ID, paramMap, new GradeRowMapper());

    }

    @Override
    public List<Grade> findByName(String name) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return namedParameterJdbcTemplate.query(GradeStatements.FIND_BY_NAME, paramMap, new GradeRowMapper());

    }

    @Override
    public List<Grade> findByEmployeeId(String employeeId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("employeeid", employeeId);
        return namedParameterJdbcTemplate.query(GradeStatements.FIND_BY_EMPLOYEE_ID, paramMap, new GradeRowMapper());
    }

    @Override
    public List<Grade> findByStatus(String status) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("status", status);
        return namedParameterJdbcTemplate.query(GradeStatements.FIND_BY_STATUS, paramMap, new GradeRowMapper());

    }

    @Override
    public boolean save(Grade grade) {
        DBLog dbLog = DBLog.getDBLog(grade.getId());
        grade.setDBLog(dbLog);
        return 1 == jdbcTemplate.update(GradeStatements.SAVE, grade.getId(), grade.getName(),
                grade.getNoOfBoys(), grade.getNoOfGirls(), grade.getEmployeeId(), grade.getStatus(),
                grade.getDBLog().getTimestamp(), grade.getDBLog().getApplication(), grade.getDBLog().getMachineName(),
                grade.getDBLog().getUserId());

    }

    @Override
    public boolean delete(String id) {
        return 1 == jdbcTemplate.update(GradeStatements.DELETE, id);

    }

    @Override
    public boolean updateStatus(String id, String status) {
        return 1 == jdbcTemplate.update(GradeStatements.UPDATE_STATUS, status, id);

    }

    @Override
    public boolean updateEmployeeId(String id, String employeeId) {
        return 1 == jdbcTemplate.update(GradeStatements.UPDATE_EMPLOYEE_ID, employeeId, id);

    }

    @Override
    public int cleanUp() {
        return jdbcTemplate.update(GradeStatements.CLEAN_UP);
    }
}
