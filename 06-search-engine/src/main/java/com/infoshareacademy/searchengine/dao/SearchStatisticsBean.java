package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.UserQueriesLog;
import com.infoshareacademy.searchengine.repository.UserQueriesRepository;

import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class SearchStatisticsBean implements SearchStatistics{


    @Override
    public void addUserQuery(UserQueriesLog userQueriesLog) {
        UserQueriesRepository.getUserQueriesRepository().add(userQueriesLog);
    }

    @Override
    public List<UserQueriesLog> getUserQueriesById(int userId) {
        List<UserQueriesLog> userQueriesLogList = UserQueriesRepository.getUserQueriesRepository().stream()
                .filter(userQueriesLog -> userQueriesLog.getUserID()==userId)
                .collect(Collectors.toList());
        return userQueriesLogList;
    }
}
