package edu.nhs.wsaams.repository.statement;

public interface GradeStatements {
     String CREATE = "DROP TABLE IF EXISTS grade;\n" +
             "create table grade(\n" +
            "id varchar(50) not null primary key,\n" +
            "name varchar(50) not null,\n" +
            "no_of_boys int,\n" +
            "no_of_girls int,\n" +
            "employeeid varchar(50),\n" +
            "status varchar(1),\n" +
            "timestamp varchar(50),\n" +
            "application varchar(50),\n" +
            "machinename varchar(50),\n" +
            "userid varchar(50)\n" +
            ");";
     String TEST = "SELECT count(*) FROM grade";
     String FIND_ALL = "SELECT * FROM grade WHERE status = 'A'";
     String FIND_BY_ID = "SELECT * FROM grade WHERE id = :id and status = 'A'";
     String FIND_BY_NAME = "SELECT * FROM grade WHERE name = :name and status = 'A'";
     String FIND_BY_EMPLOYEE_ID = "SELECT * FROM grade WHERE employeeid = :employeeid and status = 'A'";
     String FIND_BY_STATUS = "SELECT * FROM grade WHERE status = :status";
     String SAVE = "INSERT INTO grade VALUES(?,?,?,?,?,?,?,?,?,?)";
     String DELETE = "DELETE FROM grade WHERE id = ?";
     String UPDATE_STATUS = "UPDATE grade SET status = ? WHERE id = ? and status = 'A'";
     String UPDATE_EMPLOYEE_ID = "UPDATE grade SET employeeid = ? WHERE id = ? and status = 'A'";
     String CLEAN_UP = "DELETE FROM grade";

}
