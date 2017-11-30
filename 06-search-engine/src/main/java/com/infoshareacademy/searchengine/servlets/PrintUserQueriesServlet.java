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
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;


@WebServlet("print-user-queries")
public class PrintUserQueriesServlet extends HttpServlet {

    @Inject
    SearchStatistics searchStatisticsBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserQueriesLog> userQueriesLogList = UserQueriesRepository.getUserQueriesRepository();
        Collections.sort(userQueriesLogList);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        if (userQueriesLogList.isEmpty()) {
            printWriter.println("Brak zapytań o użytkownika");
            return;
        }
        TreeSet<Integer> userIdList = new TreeSet<>();
        for (UserQueriesLog userQueriesLog : userQueriesLogList) {
            int userId = userQueriesLog.getUserID();
            if (!userIdList.contains(userId)) {
                printWriter.println("Id: " + userQueriesLog.getUserID() + " -- " + userQueriesLog.getUserName() + " -- ilość zapytań: " + searchStatisticsBean.getNumberOfQueriesById(userQueriesLog.getUserID()) + "<br />");
                userIdList.add(userId);
            }
        }

    }
}
