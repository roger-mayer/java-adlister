package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username"); //receives user input from login.jsp form
        String password = request.getParameter("password");

        //find by username establishes that user name does exists
        User user = DaoFactory.getUsersDao().findByUsername(username);

        //if does not exist, redirects back to login
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }

        //valid attempt is made true if user does exists
        boolean validAttempt = Password.check(password, user.getPassword());

        //if attempt is valid user object is set as a session and sent to profile page
        if (validAttempt) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
