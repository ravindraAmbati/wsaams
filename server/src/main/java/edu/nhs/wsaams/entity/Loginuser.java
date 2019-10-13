package edu.nhs.wsaams.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Loginuser {

    private String id;
    private String username;
    private String password;
    private String status;
    private String loginTime;
    private String logoffTime;
    private String lastAttemptStatus;

    @Autowired
    private DBLog dbLog;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLogoffTime() {
        return logoffTime;
    }

    public void setLogoffTime(String logoffTime) {
        this.logoffTime = logoffTime;
    }

    public String getLastAttemptStatus() {
        return lastAttemptStatus;
    }

    public void setLastAttemptStatus(String lastAttemptStatus) {
        this.lastAttemptStatus = lastAttemptStatus;
    }

    public DBLog getDBLog() {
        return dbLog;
    }

    public void setDBLog(DBLog dbLog) {
        this.dbLog = dbLog;
    }
}
