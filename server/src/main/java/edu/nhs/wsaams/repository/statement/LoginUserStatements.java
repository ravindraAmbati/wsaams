package edu.nhs.wsaams.repository.statement;

public class LoginUserStatements {

    public static final String FIND_BY_USERNAME = "SELECT 1 FROM loginuser WHERE username = :username";
    public static final String FIND_BY_USERNAME_PASSWORD = "SELECT 1 FROM loginuser WHERE username = :username and password = :password";
    public static final String FIND_ALL = "SELECT * FROM loginuser";
}
