package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.interceptors.AddUserInterceptor;

import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("add-user")
public class AddUserServlet extends HttpServlet {
    @Inject
    private UsersRepositoryDao userRepositoryDaoBean;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addUser(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addUser(request, response);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String login = request.getParameter("login");
        String age = request.getParameter("age");

        //Gender gender=null;

//        if (id == null || name == null || surname == null || login == null || age == null) {
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            return;
//        }


//        if (isIdExist(userList, id)) {
//            response.setStatus(HttpServletResponse.SC_CONFLICT);
//            return;
//        }

//        user.setId(Integer.valueOf(id));
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setAge(Integer.valueOf(age));
        setGender(request, user);
        userRepositoryDaoBean.addUser(user);


        List<User> userList = userRepositoryDaoBean.getUsersList();

        PrintWriter writer = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        printNames(userList, writer);
    }

     void setGender(HttpServletRequest request, User user) {
        String gender = request.getParameter("gender");
        if (gender.equals("MAN")){
            user.setGender(Gender.MAN);
        }
        else if (gender.equals("WOMAN")){
            user.setGender(Gender.WOMAN);
        }
        else user.setGender(null);
    }

    private boolean isIdExist(List<User> userList, String id) {
        boolean idExist = false;
        for (User u : userList) {
            if (u.getId() == Integer.valueOf(id)) {
                idExist = true;
            }
        }
        return idExist;
    }

    private void printNames(List<User> userList, PrintWriter writer) {
        for (User u : userList) {
            writer.println(u.getName());
        }
    }
}
