package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {
        // Соединение с базой данных тоже нужно отслеживать
        try (var conn = DriverManager.getConnection("jdbc:h2:mem:cars")) {

            var sql = "CREATE TABLE cars (id BIGINT PRIMARY KEY AUTO_INCREMENT, brand VARCHAR(255), model VARCHAR(255))";
            try (var statement = conn.createStatement()) {
                statement.execute(sql);
            }

            var sql2 = "INSERT INTO cars (brand, model) VALUES ('kia', 'sorento'), ('bmw', 'x5'), ('audi', 'q7')";
            try (var statement2 = conn.createStatement()) {
                statement2.executeUpdate(sql2);
            }



            var sql3 = "SELECT * FROM cars ORDER BY brand ASC";
            try (var statement3 = conn.createStatement()) {
                var resultSet = statement3.executeQuery(sql3);
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("brand") + " " +
                            resultSet.getString("model"));

                }
            }
        }
    }
}