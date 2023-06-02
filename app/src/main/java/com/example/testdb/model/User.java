package com.example.testdb.model;

public class User {

    private Long id;
    private String role;
    private String login;
    private String password;
    private String mail;
    private String FIO;
    private String userGroup;
    private String departament;
    private String eventsID;
    private boolean isAuthorized;

    public User(String login, String password, boolean isAuthorized) {
        this.login = login;
        this.password = password;
        this.isAuthorized = isAuthorized;
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public String getFIO() {
        return FIO;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public String getDepartament() {
        return departament;
    }

    public String getEventsID() {
        return eventsID;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", FIO='" + FIO + '\'' +
                ", userGroup='" + userGroup + '\'' +
                ", departament='" + departament + '\'' +
                ", eventsID='" + eventsID + '\'' +
                ", isAuthorized=" + isAuthorized +
                '}';
    }
}
