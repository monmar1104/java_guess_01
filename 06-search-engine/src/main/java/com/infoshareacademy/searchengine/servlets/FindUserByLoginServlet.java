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
import javax.servlet.http.HttpSession;
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
        HttpSession session = request.getSession();
        session.setAttribute("userId",user.getId());
        session.setAttribute("name",user.getName());
        session.setAttribute("surname",user.getSurname());
        session.setAttribute("login",user.getLogin());
        session.setAttribute("age",user.getAge());
        session.setAttribute("gender",user.getGender());
        request.setAttribute("stats",statisticsRepositoryDaoBean.getStatisticsByUser(user));
        request.setAttribute("isUpdateUser",false);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user-details.jsp");
        requestDispatcher.forward(request, response);
    }
}
