package edu.nhs.wsaams.entity;

import edu.nhs.wsaams.commons.Utility;
import org.springframework.stereotype.Component;

@Component
public class DBLog {

    private String timestamp;
    private String application;
    private String machineName;
    private String userId;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static DBLog getDBLog() {
        DBLog dbLog = new DBLog();
        dbLog.setApplication(Utility.getApplication());
        dbLog.setMachineName(Utility.getHostName());
        dbLog.setTimestamp(Utility.getCurrrentTimeStamp());
        return dbLog;
    }

    public static DBLog getDBLog(String userId) {
        DBLog dbLog = getDBLog();
        dbLog.setUserId(userId);
        return dbLog;
    }

}
