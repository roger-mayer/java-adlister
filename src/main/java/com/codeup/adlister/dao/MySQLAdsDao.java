package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;
import models.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
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
    public List<Ad> all() {
//        Statement stmt = null;
        PreparedStatement stmt = null;
        try {
//            stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    /**
     * Method to get a list of ads filtered by the title
     * @param searchString  String to use for filtering
     * @return              A filtered list of ads
     */

    @Override
    public List<Ad> getFilteredList(String searchString) {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads WHERE title LIKE '%" + searchString + "%' ");
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving filtered ads list.", e);
        }
    }

    /**
     * Method to get a list of ads filtered by the title
     * @param searchString  String to use for filtering
     * @return              A filtered list of ads
     */
    @Override
    public List<Ad> getPreparedList(String searchString) {
        // notice that there are no quotes on the question mark
        String sql = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?";
        String searchTermWithWildcards = "%" + searchString + "%";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, searchTermWithWildcards);
            stmt.setString(2, searchTermWithWildcards);

            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving filtered ads list.", e);
        }
    }
    @Override
    public Long insert(Ad ad) {
        try {
            PreparedStatement stmt = connection.prepareStatement(createInsertQuery(), PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private String createInsertQuery() {
        return "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
    public static void main(String[] args) {
        Ads adsDao = new MySQLAdsDao(new Config());
//        List<Ad> ads = adsDao.all();
//        for (Ad ad : ads) {
//            System.out.println(ad.toString());
//        }

        long lastInsertedId = adsDao.insert(new Ad(1, "Cat for Sale", "Very cheap. I'll even pay you!"));
        System.out.println(lastInsertedId);



    }
}
