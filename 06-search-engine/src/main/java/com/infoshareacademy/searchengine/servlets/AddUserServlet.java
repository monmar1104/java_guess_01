package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
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
public class AddUserServlet extends HttpServlet{
    @Inject
    private UsersRepositoryDao userRepositoryDaoBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        User user = new User();
        user.setId(Integer.valueOf(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        user.setLogin(request.getParameter("login"));
        user.setId(Integer.valueOf(request.getParameter("age")));
        userRepositoryDaoBean.addUser(user);

        List<User> userList=userRepositoryDaoBean.getUserList();

        PrintWriter writer = response.getWriter();
        for (User u : userList){
            writer.println(u.getName());
        }
    }

}
