package com.infoshareacademy.searchengine.dao;


import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.domain.UserQueriesLog;

import javax.ejb.Local;
import java.util.List;
import java.util.Map;

@Local
public interface SearchStatistics {
    void addUserQuery(UserQueriesLog userQueriesLog);

    int getNumberOfQueriesById(int userId);

    List<UserQueriesLog> getUserQueriesById(int userId);
    void addVisit(User user);

    Map<User, Integer> getAllStatistics();

    Integer getStatisticsByUser(User user);
}
