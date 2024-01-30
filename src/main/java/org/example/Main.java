package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {

        var conn = DriverManager.getConnection("jdbc:h2:mem:hexlet");

        var sql = "CREATE TABLE films"
                + "(id BIGINT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(255), release_year INT, duration INT)";

        var statement = conn.createStatement();
        statement.execute(sql);
        statement.close();

        // BEGIN (write your solution here)
        var sql2 = "INSERT INTO films (title, release_year, duration) VALUES ('Godfather', '1972', '175'), ('The Green Mile', '1999', '189')";
        var statement2 = conn.createStatement();
        statement2.executeUpdate(sql2);
        statement2.close();

        var sql3 = "SELECT * FROM films";
        var statement3 = conn.createStatement();

        var resultSet = statement3.executeQuery(sql3);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("title") + " "
                    + resultSet.getString("release_year") + " "
                    + resultSet.getString("duration"));

        }
        statement3.close();

//        var sql4 = "INSERT INTO films (title, release_year, duration) VALUES ('The Green Mile', '1999', '189')";
//        var statement4 = conn.createStatement();
//        statement4.executeUpdate(sql4);
//        statement3.close();
//
//        var resultSet2 = statement3.executeQuery(sql4);
//        while (resultSet2.next()) {
//            System.out.println(resultSet2.getString("title") + " "
//                    + resultSet2.getString("release_year") + " "
//                    + resultSet2.getString("duration"));
//
//        }
        statement3.close();
        // END

        conn.close();
    }
}