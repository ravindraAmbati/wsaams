package edu.nhs.wsaams.repository.statement;

public class LoginuserStatements {

    public static final String IS_USERNAME_EXISTS = "SELECT 1 FROM loginuser WHERE username = :username and status = 'A'";
    public static final String IS_USERNAME_PASSWORD_EXISTS = "SELECT 1 FROM loginuser WHERE username = :username and password = :password and status = 'A'";
    public static final String FIND_ALL = "SELECT * FROM loginuser";
    public static final String FIND_BY_ID = "SELECT * FROM loginuser WHERE id = :id";
    public static final String FIND_BY_USERNAME = "SELECT * FROM loginuser WHERE username = :username";
    public static final String FIND_BY_STATUS = "SELECT * FROM loginuser WHERE status = :status";
    public static final String FIND_BY_LAST_ATTEMPT_STATUS = "SELECT * FROM loginuser WHERE last_attempt_status = :lastattemptstatus";
    public static final String SAVE = "INSERT INTO loginuser VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    public static final String DELETE = "DELETE FROM loginuser WHERE id = ?";
    public static final String UPDATE_PASSWORD = "UPDATE loginuser SET password = ? WHERE id = ?";
    public static final String UPDATE_STATUS = "UPDATE loginuser SET status = ? WHERE id = ?";
    public static final String CLEAN_UP = "DELETE FROM loginuser";

}
