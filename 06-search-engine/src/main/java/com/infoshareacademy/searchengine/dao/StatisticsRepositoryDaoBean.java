package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.Statistic;
import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.repository.StatisticsRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Map;

@Stateless
public class StatisticsRepositoryDaoBean implements StatisticsRepositoryDao {
    @EJB
    StatisticsRepository statisticsRepository;
    @Override
    public void addVisit(User user) {
        Map<User, Integer> statisticMap = statisticsRepository.getRepository();
        if (statisticMap.containsKey(user)){
            statisticsRepository.updateStatistic(user);
        }else{
        Statistic statistic = new Statistic();
        statistic.setUser(user);
        statistic.setCounter(1);
        statisticsRepository.addVisit(statistic);
    }
    return;
    }

    @Override
    public Map<User, Integer> getAllStatistics() {
        return statisticsRepository.getRepository();
    }

    @Override
    public Integer getStatisticsByUser(User user) {
        return statisticsRepository.getRepository().get(user);
    }
}
