package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

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


        String username = request.getParameter("newUsername");
        String email = request.getParameter("newEmail");
        String password = request.getParameter("newPassword");
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hash);


        // TODO: ensure the submitted information is valid
        if (DaoFactory.getUsersDao().findByUsername(username) == null){

            if (username == null || password == null || !email.contains("@")) {
            response.sendRedirect("/register");
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile
        } else {
            User newUser = new User(username, email, hash);
            DaoFactory.getUsersDao().insert(newUser);
            request.getSession().setAttribute("isLoggedIn", true);
            request.getSession().setAttribute("user", newUser);
            response.sendRedirect("/profile");
        }
            } else {
            response.sendRedirect("/register");
        }

        }





    }

