package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("add-user")
public class AddUserServlet extends HttpServlet {
    @Inject
    private UsersRepositoryDao userRepositoryDaoBean;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addUser(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addUser(request, response);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String login = request.getParameter("login");
        String age = request.getParameter("age");
        //TODO
        Gender gender;
        if (request.getParameter("gender")=="MAN"){
            gender = Gender.MAN;
        } else
        {
            gender=Gender.WOMAN;
        }

        if (id == null || name == null || surname == null || login == null || age == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        List<User> userList = userRepositoryDaoBean.getUserList();

        if (isIdExist(userList, id)) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return;
        }

        user.setId(Integer.valueOf(id));
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setAge(Integer.valueOf(age));
        user.setGender(gender);
        userRepositoryDaoBean.addUser(user);


        PrintWriter writer = response.getWriter();
        printNames(userList, writer);
    }

    private boolean isIdExist(List<User> userList, String id) {
        boolean idExist = false;
        for (User u : userList) {
            if (u.getId() == Integer.valueOf(id)) {
                idExist = true;
            }
        }
        return idExist;
    }

    private void printNames(List<User> userList, PrintWriter writer) {
        for (User u : userList) {
            writer.println(u.getName());
        }
    }
}
