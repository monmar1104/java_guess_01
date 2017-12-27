package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("add-user-steps")
public class AddUserStepsServlet extends AddUserServlet {

    @Inject
    private UsersRepositoryDao userRepositoryDaoBean;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        addUser(request, response);

    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user;
        if (request.getSession().getAttribute("user") == null) {
            user = new User();
            request.getSession().setAttribute("user", user);
        }
        user = (User) request.getSession().getAttribute("user");
        if (request.getParameter("step").equals("1")) {
            user.setLogin(request.getParameter("login"));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-user-step-2.jsp");
            requestDispatcher.forward(request, response);
        } else if (request.getParameter("step").equals("2")) {
            user.setName(request.getParameter("name"));
            user.setSurname(request.getParameter("surname"));
            user.setAge(Integer.parseInt(request.getParameter("age")));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-user-step-3.jsp");
            requestDispatcher.forward(request, response);
        } else if (request.getParameter("step").equals("3")) {
            setGender(request, user);
            userRepositoryDaoBean.addUser(user);
            request.setAttribute("okMessage", "User with ID " + user.getId() + " has been added.");
            request.setAttribute("userId",user.getId());
            request.setAttribute("name",user.getName());
            request.setAttribute("surname",user.getSurname());
            request.setAttribute("age",user.getAge());
            request.setAttribute("login",user.getLogin());
            request.setAttribute("gender",user.getGender());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user-details.jsp");
            requestDispatcher.forward(request, response);
            request.getSession().invalidate();
        }

    }

}
