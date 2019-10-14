package edu.nhs.wsaams.repository.mapper;

import edu.nhs.wsaams.entity.DBLog;
import edu.nhs.wsaams.entity.Grade;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class GradeRowMapper implements RowMapper<Grade> {
    @Override
    public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
        DBLog dbLog = new DBLog();
        dbLog.setApplication(rs.getString("application"));
        dbLog.setMachineName(rs.getString("machinename"));
        dbLog.setTimestamp(rs.getString("timestamp"));
        dbLog.setUserId(rs.getString("userid"));
        Grade grade = new Grade();
        grade.setId(rs.getString("id"));
        grade.setName(rs.getString("name"));
        grade.setNoOfBoys(rs.getInt("no_of_boys"));
        grade.setNoOfGirls(rs.getInt("no_of_girls"));
        grade.setEmployeeId(rs.getString("employeeid"));
        grade.setStatus(rs.getString("status"));
        grade.setDBLog(dbLog);
        return grade;
    }
}
