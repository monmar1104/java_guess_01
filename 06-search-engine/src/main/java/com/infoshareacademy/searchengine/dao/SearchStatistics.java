package com.infoshareacademy.searchengine.dao;


import com.infoshareacademy.searchengine.domain.UserQueriesLog;

import javax.ejb.Local;
import java.util.List;

@Local
public interface SearchStatistics {
    void addUserQuery(UserQueriesLog userQueriesLog);
    int getNumberOfQueriesById(int userId);
    List<UserQueriesLog> getUserQueriesById(int userId);
}
