package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.UserRepositoryDaoBean;
import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Test {
    private static UsersRepositoryDao userRepositoryDaoBean = new UserRepositoryDaoBean();

    public static void main(String[] args) {


        User user = new User();

        Integer id = 3;
        String name = "Marcin";
        String surname = "Pastwa";
        String login = "marcinpastwa";
        Integer age = 40;

        if (id == null || name == null || surname == null || login == null || age == null) {
            System.out.println("nie podano wszystkich danych");
            return;
        }
        List<User> userList = userRepositoryDaoBean.getUserList();
        if (isIdExist(userList, id)) {
            System.out.println("Id się powtarza");
            return;
        }

        user.setId(id);
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setAge(age);
        userRepositoryDaoBean.addUser(user);



        printNames(userList);
    }

    private static boolean isIdExist(List<User> userList, Integer id) {
        boolean idExist = false;
        for (User u : userList) {
            if (u.getId() == id) {
                idExist = true;
            }
        }
        return idExist;
    }

    private static void printNames(List<User> userList) {
        for (User u : userList) {
            System.out.println(u.getName());
        }
    }



}
