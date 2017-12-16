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
public class AddUserStepsServlet extends HttpServlet {

    @Inject
    private UsersRepositoryDao userRepositoryDaoBean;



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        addUser(request, response);

    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(request.getParameter("step").equals("1")){
            request.getSession().setAttribute("id", request.getParameter("id"));
            request.getSession().setAttribute("login", request.getParameter("login"));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-user-step-2.jsp");
            requestDispatcher.forward(request, response);
            return;
        } else if(request.getParameter("step").equals("2")){
            request.getSession().setAttribute("name", request.getParameter("name"));
            request.getSession().setAttribute("surname", request.getParameter("surname"));
            request.getSession().setAttribute("age", request.getParameter("age"));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-user-step-3.jsp");
            requestDispatcher.forward(request, response);
            return;

        } else if (request.getParameter("step").equals("3")){
            request.getSession().setAttribute("gender", request.getParameter("gender"));

            User user = new User();
            user.setId(Integer.parseInt((String)request.getSession().getAttribute("id")));
            user.setLogin((String) request.getSession().getAttribute("login"));
            user.setName((String) request.getSession().getAttribute("name"));
            user.setSurname((String) request.getSession().getAttribute("surname"));
            user.setAge(Integer.parseInt((String)request.getSession().getAttribute("age")));
            Gender gender=null;
            if (request.getSession().getAttribute("gender")=="MAN"){
                gender = Gender.MAN;
            }
            else if (request.getSession().getAttribute("gender")=="WOMAN") {
                gender=Gender.WOMAN;
            }

            user.setGender(gender);
            userRepositoryDaoBean.addUser(user);
            request.getSession().invalidate();
        }

    }

}
