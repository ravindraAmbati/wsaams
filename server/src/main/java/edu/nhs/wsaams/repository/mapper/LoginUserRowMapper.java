package edu.nhs.wsaams.repository.mapper;

import edu.nhs.wsaams.entity.DBLog;
import edu.nhs.wsaams.entity.Loginuser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUserRowMapper implements RowMapper<Loginuser> {
    @Override
    public Loginuser mapRow(ResultSet rs, int rowNum) throws SQLException {
        Loginuser loginuser = new Loginuser();
        loginuser.setId(rs.getString("id"));
        loginuser.setUsername(rs.getString("username"));
        loginuser.setPassword(rs.getString("password"));
        loginuser.setStatus(rs.getString("status"));
        loginuser.setLoginTime(rs.getString("login_time"));
        loginuser.setLogoffTime(rs.getString("logoff_time"));
        loginuser.setLastAttemptStatus(rs.getString("last_attempt_status"));
        DBLog dbLog = new DBLog();
        dbLog.setUserId(rs.getString("userId"));
        dbLog.setTimestamp(rs.getString("timestamp"));
        dbLog.setMachineName(rs.getString("machinename"));
        dbLog.setApplication(rs.getString("application"));
        loginuser.setDBLog(dbLog);
        return loginuser;
    }
}
