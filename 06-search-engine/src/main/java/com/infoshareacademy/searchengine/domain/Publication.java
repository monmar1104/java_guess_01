package com.infoshareacademy.searchengine.domain;


import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    protected int id;

    @Column
    protected String title;

    @Version
    @Column
    private int verion;

    @Column
    @Temporal(TemporalType.DATE)
    private Date publishingDate;

}
