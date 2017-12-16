package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.cdi.MaxPulse;
import com.infoshareacademy.searchengine.dao.SearchStatistics;
import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.domain.UserQueriesLog;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;


@WebServlet("find-user-by-id")
public class FindUserByIdServlet extends HttpServlet {
    @Inject
    private UsersRepositoryDao userRepositoryDaoBean;

    @Inject
    private SearchStatistics searchStatisticsBean;

    @Inject
    private MaxPulse maxPulse;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        User user = userRepositoryDaoBean.getUserById(Integer.valueOf(req.getParameter("id")));
        if (user == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        double pulse = 0;

        UserQueriesLog userQueriesLog = new UserQueriesLog();
        userQueriesLog.setUserID(user.getId());
        userQueriesLog.setUserName(user.getName());
        userQueriesLog.setLogDate(LocalDateTime.now());
        searchStatisticsBean.addUserQuery(userQueriesLog);
        int numberOfQueries = searchStatisticsBean.getNumberOfQueriesById(user.getId());
        if(user.getGender().equals(Gender.MAN)){
            pulse = maxPulse.getMaxPulseForMan(user.getAge());
        }
        else pulse = maxPulse.getMaxPulseForWoman(user.getAge());
        writer.println("Ilość zapytań o użytkownika " + user.getName() + ": " + numberOfQueries+"-- puls: "+pulse);
        searchStatisticsBean.addVisit(user);
    }
}
