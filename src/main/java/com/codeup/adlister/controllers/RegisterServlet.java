package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // TODO: show the registration form

        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid

        String username = request.getParameter("newUsername");
        String email = request.getParameter("newEmail");
        String password = request.getParameter("newPassword");

        if ((password.length() < 8)
            && password.matches("(?=.*[a-z]).*")
            && password.matches("(?=.*[A-Z]).*")
            && password.matches("(?=.*[1-9]).*")
            && password.matches("(?=.*[~!@#$%^&*()_><=+?.,/]).*")) {
            String validPassword = password;
        } else {
            response.sendRedirect("/register");
        }

        if (DaoFactory.getUsersDao().findByUsername(username) != null) {

        }


        // TODO: create a new user based off of the submitted information
        // User user = new user();
        // TODO: if a user was successfully created, send them to their profile
    }
}
