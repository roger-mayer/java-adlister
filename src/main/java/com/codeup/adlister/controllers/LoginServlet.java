package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import org.mindrot.jbcrypt.BCrypt;

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean passwordMatch = BCrypt.checkpw(password, DaoFactory.getUsersDao().findByUsername(username).getPassword());

        // TODO: find a record in your database that matches the submitted password
        // TODO: make sure we find a user with that username
        // TODO: check the submitted password against what you have in your database
        boolean validAttempt = false;
        request.getSession().setAttribute("isLoggedIn", validAttempt);

        if (DaoFactory.getUsersDao().findByUsername(username) != null) {
            if (username.equals(DaoFactory.getUsersDao().findByUsername(username).getUsername()) && passwordMatch) {
                validAttempt = true;
                // TODO: store the logged in user object in the session, instead of just the username
//            request.getSession().setAttribute("user", username);
//            response.sendRedirect("/profile");
            } else {
                response.sendRedirect("/login");
                return;
            }
        }

        if (validAttempt) {
            request.getSession().setAttribute("user", DaoFactory.getUsersDao().findByUsername(username));
            request.getSession().setAttribute("isLoggedIn", validAttempt);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }

}



