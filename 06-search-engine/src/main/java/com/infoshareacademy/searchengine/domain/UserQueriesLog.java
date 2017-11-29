package com.infoshareacademy.searchengine.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class UserQueriesLog {
    private int userID;
    private String userName;
    private LocalDateTime logDateTime;


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getLogDate() {
        return logDateTime;
    }

    public void setLogDate(LocalDateTime logDateTime) {
        this.logDateTime = logDateTime;
    }
}
