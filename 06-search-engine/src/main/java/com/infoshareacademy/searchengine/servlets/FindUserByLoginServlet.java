package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.StatisticsRepositoryDao;
import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("find-user-by-login")
public class FindUserByLoginServlet extends HttpServlet {
    @EJB
    UsersRepositoryDao usersRepositoryDaoBean;
    @EJB
    StatisticsRepositoryDao statisticsRepositoryDaoBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String login = request.getParameter("login");
        User user = usersRepositoryDaoBean.getUserByLogin(login);
        statisticsRepositoryDaoBean.addVisit(user);
        request.setAttribute("userId",user.getId());
        request.setAttribute("name",user.getName());
        request.setAttribute("surname",user.getSurname());
        request.setAttribute("login",user.getLogin());
        request.setAttribute("age",user.getAge());
        request.setAttribute("gender",user.getGender());
        request.setAttribute("stats",statisticsRepositoryDaoBean.getStatisticsByUser(user));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user-details.jsp");
        requestDispatcher.forward(request, response);
    }
}
