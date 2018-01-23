package com.infoshareacademy.searchengine.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Book extends Publication {

    @Column
    private int pages;
}
