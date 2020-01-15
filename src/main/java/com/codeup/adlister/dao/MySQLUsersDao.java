package com.codeup.adlister.dao;


import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import models.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {


    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            String sql = "SELECT * FROM users WHERE username LIKE ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            User result = new User(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password")
            );
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding User");
        }
    }



//    @Override
//    public List<User> all() {
//        Statement stmt = null;
//        try {
//            stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
//            return createUsersFromResults(rs);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error retrieving all ads.", e);
//        }
//    }
//
//    private List<User> createUsersFromResults(ResultSet rs) {
//        List<User> user = new ArrayList<>();
//        while (rs.next()) {
//            users.add(extractUser(rs));
//        }
//        return users;
//    }


    @Override
    public List<User> all() {
        return null;
    }

    @Override
    public Long insert(User user) {
        return null;
    }

    @Override
    public List<User> getFilteredList(String searchString) {
        return null;
    }

    @Override
    public List<User> getPreparedList(String searchString) {
        return null;
    }


}
