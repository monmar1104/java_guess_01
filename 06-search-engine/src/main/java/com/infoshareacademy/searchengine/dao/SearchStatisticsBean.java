package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.domain.UserQueriesLog;
import com.infoshareacademy.searchengine.repository.StatisticsRepository;
import com.infoshareacademy.searchengine.repository.UserQueriesRepository;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class SearchStatisticsBean implements SearchStatistics {


    @Override
    public void addUserQuery(UserQueriesLog userQueriesLog) {
        UserQueriesRepository.getUserQueriesRepository().add(userQueriesLog);
    }

    @Override
    public int getNumberOfQueriesById(int userId) {

        return (int) UserQueriesRepository
                .getUserQueriesRepository()
                .stream()
                .filter(userQueriesLog -> userQueriesLog.getUserID() == userId)
                .count();
    }

    @Override
    public List<UserQueriesLog> getUserQueriesById(int userId) {
        return UserQueriesRepository
                .getUserQueriesRepository()
                .stream()
                .filter(userQueriesLog -> userQueriesLog.getUserID() == userId)
                .collect(Collectors.toList());
    }
    @Override
    public void addVisit(User user) {
        StatisticsRepository.getRepository().putIfAbsent(user, 0);
        Integer userStats = getStatisticsByUser(user);
        StatisticsRepository.getRepository().replace(user, userStats + 1);
    }

    @Override
    public Map<User, Integer> getAllStatistics() {
        return StatisticsRepository.getRepository();
    }

    @Override
    public Integer getStatisticsByUser(User user) {
        return StatisticsRepository.getRepository().get(user);
    }

}
