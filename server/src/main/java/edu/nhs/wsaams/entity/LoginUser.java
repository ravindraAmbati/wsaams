package edu.nhs.wsaams.entity;

public class  LoginUser {

    private String username;
    private String password;
    private boolean isValidLoginUser;
    private boolean isValidAuthentication;


    public LoginUser() {
    }

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
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

    public boolean isValidLoginUser() {
        return isValidLoginUser;
    }

    public void setValidLoginUser(boolean validLoginUser) {
        isValidLoginUser = validLoginUser;
    }

    public boolean isValidAuthentication() {
        return isValidAuthentication;
    }

    public void setValidAuthentication(boolean validAuthentication) {
        isValidAuthentication = validAuthentication;
    }

}
