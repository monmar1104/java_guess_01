package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.User;

import javax.inject.Inject;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String login = request.getParameter("login");
        Integer age = Integer.valueOf(request.getParameter("age"));

        if (id==null || name==null || surname==null || login==null || age==null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        user.setId(id);
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setAge(age);
        userRepositoryDaoBean.addUser(user);

        List<User> userList = userRepositoryDaoBean.getUserList();
        if (isIdExist(userList, id)){
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return;
        }
        PrintWriter writer = response.getWriter();
        printNames(userList, writer);

    }

    private boolean isIdExist(List<User> userList, Integer id){
        for (User u:userList){
            if (u.getId()==id){
                return true;
            }
        }
        return false;
    }

    private void printNames(List<User> userList, PrintWriter writer) {
        for (User u : userList) {
            writer.println(u.getName());
        }
    }

}
