package com.infoshareacademy.searchengine.repository;

import com.infoshareacademy.searchengine.domain.UserQueriesLog;

import java.util.ArrayList;
import java.util.List;

public class UserQueriesRepository {
    private static List<UserQueriesLog> userQueriesLogList = new ArrayList<>();
    public static List<UserQueriesLog> getUserQueriesRepository(){
        return userQueriesLogList;
    }
}
