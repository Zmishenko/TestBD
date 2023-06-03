package com.example.testdb.model;

public class User {
    private Long id;
    private String role;
    private String login;
    private String password;
    private String mail;
    private String surname;
    private String first_name;
    private String fathers_name;
    private String userGroup;
    private String departament;
    private String eventsID;
    private boolean isAuthorized;

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

    public String getSurname() {
        return surname;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getFathers_name() {
        return fathers_name;
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
                ", surname='" + surname + '\'' +
                ", first_name='" + first_name + '\'' +
                ", fathers_name='" + fathers_name + '\'' +
                ", userGroup='" + userGroup + '\'' +
                ", departament='" + departament + '\'' +
                ", eventsID='" + eventsID + '\'' +
                ", isAuthorized=" + isAuthorized +
                '}';
    }
}
