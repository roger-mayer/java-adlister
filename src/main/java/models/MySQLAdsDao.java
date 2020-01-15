package models;


import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//  Create a class named MySQLAdsDao that implements the Ads interface
public class MySQLAdsDao implements Ads {
//  This class should have a private instance property
//  named connection of type Connection
//  that is initialized in the constructor.
    private Connection connection;

//  Define your constructor so that it
//  accepts an instance of your Config class
//  so that it can obtain the database credentials.
    public MySQLAdsDao(Config config) {
        try {

            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    method should retrieve ads from the database
    @Override
    public List<Ad> all() {
        List<Ad> output = new ArrayList<>(); //create new list
        String query = "Select * FROM ads";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                output.add(
                        new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getString("description")

                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }

//  method to insert new ads into the database
    @Override
    public Long insert(Ad newAd) throws SQLException {
        String insertQuery = "INSERT INTO ads (user_id, title, description) VALUES (" + newAd.getUserId() + ",'" + newAd.getTitle() + "','" + newAd.getDescription() + "')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {

            System.out.println("inserted id: " + rs.getLong(1));
        }
        return rs.getLong(1);
    }


    public static void main(String[] args) throws SQLException {
        Config config = new Config();
        Ads adsDao = new models.MySQLAdsDao(config);
        //set up test add
        Ad testAd = new Ad(
                1,
                "test title1",
                "test description1"

        );

        adsDao.insert(testAd);
        List<Ad> ads = adsDao.all();
        for (Ad ad : ads) {
            System.out.println(ad);

        }
    }

}

