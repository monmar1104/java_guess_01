package com.infoshareacademy.searchengine;

import com.infoshareacademy.searchengine.dao.UserRepositoryDaoBean;
import com.infoshareacademy.searchengine.domain.User;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hallo world");
        UserRepositoryDaoBean userRepositoryDaoBean = new UserRepositoryDaoBean();

        for(User user:userRepositoryDaoBean.getUserList()){
            System.out.println(user.getName());
        }




    }
}
