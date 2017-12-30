package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.cdi.MaxPulse;
import com.infoshareacademy.searchengine.dao.SearchStatistics;
import com.infoshareacademy.searchengine.dao.StatisticsRepositoryDao;
import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.domain.UserQueriesLog;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
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
    private UsersRepositoryDao usersRepositoryDao;

    @Inject
    private SearchStatistics searchStatisticsBean;

    @EJB
    StatisticsRepositoryDao statisticsRepositoryDao;

    @Inject
    private MaxPulse maxPulse;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        User user = usersRepositoryDao.getUserById(Integer.valueOf(req.getParameter("id")));
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer id = Integer.parseInt(request.getParameter("uid"));
        User user = usersRepositoryDao.getUserById(id);
        statisticsRepositoryDao.addVisit(user);
        request.getSession().setAttribute("userId",user.getId());
        request.getSession().setAttribute("name",user.getName());
        request.getSession().setAttribute("surname",user.getSurname());
        request.getSession().setAttribute("login",user.getLogin());
        request.getSession().setAttribute("age",user.getAge());
        request.getSession().setAttribute("gender",user.getGender());
        request.setAttribute("stats",statisticsRepositoryDao.getStatisticsByUser(user));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user-details.jsp");
        requestDispatcher.forward(request, response);
    }
}
