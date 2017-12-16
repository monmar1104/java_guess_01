package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.User;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("print-users")
public class PrintAllUsersServlet extends HttpServlet{
    @Inject
    private UsersRepositoryDao userRepositoryDaoBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userRepositoryDaoBean.getUserList();
        request.setAttribute("userslist", userList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/users-list.jsp");
        requestDispatcher.forward(request,response);
    }

}
