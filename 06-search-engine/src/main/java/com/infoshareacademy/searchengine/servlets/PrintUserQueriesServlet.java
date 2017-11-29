package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.SearchStatistics;
import com.infoshareacademy.searchengine.domain.UserQueriesLog;
import com.infoshareacademy.searchengine.repository.UserQueriesRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.TreeSet;


@WebServlet("print-user-queries")
public class PrintUserQueriesServlet extends HttpServlet {

    @Inject
    SearchStatistics searchStatisticsBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserQueriesLog> userQueriesLogList = UserQueriesRepository.getUserQueriesRepository();
        PrintWriter printWriter = response.getWriter();
        TreeSet<String> userNameList = new TreeSet<>();
        for (UserQueriesLog userQueriesLog : userQueriesLogList){
            String userName = userQueriesLog.getUserName();
            if(!userNameList.contains(userName)) {
                printWriter.println(userName + " " + searchStatisticsBean.getNumberOfQueriesById(userQueriesLog.getUserID()));
                userNameList.add(userName);
            }
        }
    }
}
