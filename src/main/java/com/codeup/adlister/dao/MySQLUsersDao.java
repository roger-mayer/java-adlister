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
        User registeredUser = null;
        String sql = "SELECT * FROM users WHERE username LIKE ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                registeredUser = new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registeredUser;
    }
    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }
    private String createInsertQuery(User user){
        return "INSERT INTO users(username, email, password) VALUES "
                + "('" + user.getUsername() + "',"
                + "('" + user.getEmail() + "',"
                + "('" + user.getPassword() + "',)";
    }


    @Override
    public List<User> all() {
        return null;
    }

    public static void main(String[] args) {
        Users userDao = new MySQLUsersDao(new Config());
//        System.out.println(userDao.findByUsername("asdf"));
        User user = new User("t123", "t@email.com", "strongpassword");
        long lastInsertedId = userDao.insert(user);
        System.out.println(lastInsertedId);
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
    public List<User> getFilteredList(String searchString) {
        return null;
    }

    @Override
    public List<User> getPreparedList(String searchString) {
        return null;
    }


}
