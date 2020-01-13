package models;

import com.mysql.cj.jdbc.Driver; //sets up connection to MySQL

import java.sql.*;

public class JDBCLecture {

    public static void main(String[] args) {
        try {

            // ======================== CREATING THE DRIVER and CONNECTION OBJECTS

            DriverManager.registerDriver(new Driver());

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false", //name of db
                    "root",
                    "codeup"
            );


            // ======================== CREATING A STATEMENT OBJECT

            Statement statement = conn.createStatement(); //conn = connection object gives access to db file


            // ======================== GETTING A SINGLE AND LIST OF RESULTS

            // get everything from albums table
            String query = "SELECT * FROM albums";

//          statement.execute()- any CRUD operation
//          statement.executeUpdate()  -Create, Update, Delete
//          statement.executeQuery() -Read

            ResultSet rs = statement.executeQuery(query);
//
//            a | b | c | d
//
//            highlight next result
            rs.next();

//
//            System.out.println(rs.getString(1));
//            System.out.println(rs.getString(2));
//            System.out.println(rs.getString(3));
//            System.out.println(rs.getString(4));
//            System.out.println(rs.getString(5));
//            System.out.println(rs.getString(6));
//
//            rs.beforeFirst(); // also rs.previous()
//
//            //LOOP THROUGH ENTIRE DATABASE
            while (rs.next()) {
                System.out.println("===================");
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("artist"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("release_date"));
                System.out.println(rs.getString("sales"));
                System.out.println(rs.getString("genre"));
            }

            // ======================== GETTING METADATA

//            ResultSetMetaData rsmd = rs.getMetaData();
//            int colCount = rsmd.getColumnCount();
//            for (int i = 1; i <= colCount; i += 1) {
//                System.out.println(rsmd.getColumnName(i));
//            }

            // ======================== ALBUM MODEL

//            rs.beforeFirst();
//            rs.next();
//
//            Album album = new Album(rs.getLong("id"),
//                rs.getString("artist"),
//                rs.getString("name"),
//                rs.getInt("release_date"),
//                rs.getDouble("sales"),
//                rs.getString("genre")
//            );
//
//            System.out.println(album.getId());
//            System.out.println(album.getArtist());
//            System.out.println(album.getName());
//            System.out.println(album.getReleaseDate());
//            System.out.println(album.getReleaseDate());

            // ======================== UPDATE A RECORD

//            Album updateAlbum = new Album(
//                    2,
//                    "Prince",
//                    "Purple Rain",
//                    1984,
//                    50,
//                    "amazing"
//            );
//
//            String updateQuery = String.format("UPDATE albums SET artist = '%s', name = '%s', release_date = %d, sales = %f, genre = '%s' WHERE id = %d",
//                    updateAlbum.getArtist(),
//                    updateAlbum.getName(),
//                    updateAlbum.getReleaseDate(),
//                    updateAlbum.getSales(),
//                    updateAlbum.getGenre(),
//                    updateAlbum.getId()
//            );
//
//            boolean success = statement.execute(updateQuery);
//            int numberOfRowsEffected = statement.executeUpdate(updateQuery);

            // ======================== INSERTING A RECORD

//            Album brandNewAlbum = new Album(
//                "The Cure",
//                "Disintegration",
//                1989,
//                15,
//                "alt, goth, rock"
//            );
//
//            String insertQuery = String.format("INSERT INTO albums (artist, name, release_date, sales, genre) VALUES ('%s', '%s', %d, %f, '%s')",
//                brandNewAlbum.getArtist(),
//                brandNewAlbum.getName(),
//                brandNewAlbum.getReleaseDate(),
//                brandNewAlbum.getSales(),
//                brandNewAlbum.getGenre()
//            );
//
//            statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
//            rs = statement.getGeneratedKeys();
//
//            if (rs.next()) {
//                System.out.println("Inserted id is: " + rs.getLong(1));
//            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}