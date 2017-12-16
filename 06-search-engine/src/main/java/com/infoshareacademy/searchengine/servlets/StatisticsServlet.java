package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.SearchStatistics;
import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/statistics")
public class StatisticsServlet extends HttpServlet {

    @EJB
    SearchStatistics searchStatisticsBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<User, Integer> statistics = searchStatisticsBean.getAllStatistics();


        PrintWriter printWriter = resp.getWriter();
        for (Map.Entry<User, Integer> entry : statistics.entrySet()) {
            printWriter.println(entry.getKey().getName() + ": " + entry.getValue());
        }

        req.setAttribute("list", statistics);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/users-list-map.jsp");
        requestDispatcher.forward(req, resp);
    }
}
