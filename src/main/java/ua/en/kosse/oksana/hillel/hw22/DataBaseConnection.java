package ua.en.kosse.oksana.hillel.hw22;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DataBaseConnection {

    public static Connection getConnection() {            // - повертає нове з'єднання з БД
        Properties properties = new Properties();
        try {
            InputStream in = Files.newInputStream(Paths.get("database.properties"));
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        try {

            connection = DriverManager.getConnection(
                    properties.getProperty("DB_URL"),
                    properties.getProperty("USERNAME"),
                    properties.getProperty("PASSWORD"));

        } catch (SQLException e) {
            System.out.println("\n*** SQLException caught ***\n");
            while (e != null) {
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("Message: " + e.getMessage());
                System.out.println("Vendor: " + e.getErrorCode());
                e = e.getNextException();
            }
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
        }

        return connection;
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
