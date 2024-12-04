package at.htl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/db",
                "app",
                "app");
             Statement stmt = conn.createStatement()
        ) {
            String sql = "CREATE TABLE person (" +
                    "id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY," +
                    "name VARCHAR(255)," +
                    "city VARCHAR(255)," +
                    "house VARCHAR(255)" +
                    ")";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO person (NAME, CITY, HOUSE) " +
                    "VALUES ('Tyrion','Kingslanding','Lannister')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


    }
}