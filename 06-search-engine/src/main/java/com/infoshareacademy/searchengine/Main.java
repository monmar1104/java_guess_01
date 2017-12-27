package com.infoshareacademy.searchengine;

import com.infoshareacademy.searchengine.dao.UsersRepositoryDaoBean;
import com.infoshareacademy.searchengine.domain.User;

import javax.jws.soap.SOAPBinding;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hallo world");
        UsersRepositoryDaoBean usersRepositoryDaoBean = new UsersRepositoryDaoBean();
        User user1 = new User();
        user1.setId(5);
        user1.setName("Marcin");
        user1.setSurname("Pastwa");
        user1.setLogin("marcinpastwa");
        user1.setAge(40);
        usersRepositoryDaoBean.addUser(user1);

        for(User user:usersRepositoryDaoBean.getUsersList()){
            System.out.println(user.getName());
        }




    }
}
