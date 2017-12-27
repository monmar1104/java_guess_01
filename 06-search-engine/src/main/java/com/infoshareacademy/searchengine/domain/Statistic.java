package com.infoshareacademy.searchengine.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
@NamedQuery(name = "selectAllStatistics", query = "from Statistic"),
@NamedQuery(name = "updateStatistic", query = "update Statistic s set s.counter = s.counter+1 where s.user=:user")
})
public class Statistic implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(orphanRemoval = true)
    private User user;
    @Column
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    }





