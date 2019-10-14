package edu.nhs.wsaams.repository.statement;

public interface LoginuserStatements {
     String CREATE = "DROP TABLE IF EXISTS loginuser;\n" +
             "create table loginuser(\n" +
            "id varchar(50) not null primary key,\n" +
            "name varchar(50) not null,\n" +
            "username varchar(50) not null unique,\n" +
            "password varchar(50) not null,\n" +
            "status varchar(1),\n" +
            "login_time varchar(50),\n" +
            "logoff_time varchar(50),\n" +
            "last_attempt_status varchar(1),\n" +
            "timestamp varchar(50),\n" +
            "application varchar(50),\n" +
            "machinename varchar(50),\n" +
            "userid varchar(50)\n" +
            ");";
     String TEST = "SELECT count(*) FROM loginuser";
     String IS_USERNAME_EXISTS = "SELECT 1 FROM loginuser WHERE username = :username and status = 'A'";
     String IS_USERNAME_PASSWORD_EXISTS = "SELECT 1 FROM loginuser WHERE username = :username and password = :password and status = 'A'";
     String FIND_ALL = "SELECT * FROM loginuser WHERE status = 'A'";
     String FIND_BY_ID = "SELECT * FROM loginuser WHERE id = :id and status = 'A'";
     String FIND_BY_NAME = "SELECT * FROM loginuser WHERE name = :name and status = 'A'";
     String FIND_BY_USERNAME = "SELECT * FROM loginuser WHERE username = :username and status = 'A'";
     String FIND_BY_STATUS = "SELECT * FROM loginuser WHERE status = :status";
     String FIND_BY_LAST_ATTEMPT_STATUS = "SELECT * FROM loginuser WHERE last_attempt_status = :lastattemptstatus and status = 'A'";
     String SAVE = "INSERT INTO loginuser VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
     String DELETE = "DELETE FROM loginuser WHERE id = ?";
     String UPDATE_PASSWORD = "UPDATE loginuser SET password = ? WHERE id = ? and status = 'A'";
     String UPDATE_STATUS = "UPDATE loginuser SET status = ? WHERE id = ? and status = 'A'";
     String CLEAN_UP = "DELETE FROM loginuser";

}
