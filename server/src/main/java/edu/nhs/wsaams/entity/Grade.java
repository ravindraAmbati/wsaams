package edu.nhs.wsaams.entity;

public class Grade {

    private String id;
    private String name;
    private int noOfBoys;
    private int noOfGirls;
    private String employeeId;
    private String status;
    private DBLog dbLog;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfBoys() {
        return noOfBoys;
    }

    public void setNoOfBoys(int noOfBoys) {
        this.noOfBoys = noOfBoys;
    }

    public int getNoOfGirls() {
        return noOfGirls;
    }

    public void setNoOfGirls(int noOfGirls) {
        this.noOfGirls = noOfGirls;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DBLog getDBLog() {
        return dbLog;
    }

    public void setDBLog(DBLog dbLog) {
        this.dbLog = dbLog;
    }
}
