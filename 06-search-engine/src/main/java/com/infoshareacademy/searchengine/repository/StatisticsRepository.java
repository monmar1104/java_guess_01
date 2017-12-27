package com.infoshareacademy.searchengine.repository;

import com.infoshareacademy.searchengine.domain.Statistic;
import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Stateless
public class StatisticsRepository {
    @PersistenceContext(unitName = "pUnit")
    EntityManager entityManager;

    public void addVisit(Statistic statistic){
        entityManager.persist(statistic);
    }

    public void updateStatistic(User user){
        //entityManager.createQuery("update Statistic s set s.counter=s.counter+1 where s.user=:user").setParameter("user",user);
        entityManager.createNamedQuery("updateStatistic").setParameter("user",user).executeUpdate();
    }

    public  Map<User, Integer> getRepository() {
        List<Statistic> statisticList = entityManager.createNamedQuery("selectAllStatistics").getResultList();
        Map<User,Integer> statisticsMap = new HashMap<>();
        for (Statistic s:statisticList){
            statisticsMap.putIfAbsent(s.getUser(),s.getCounter());
        }
        return statisticsMap;
    }


}
