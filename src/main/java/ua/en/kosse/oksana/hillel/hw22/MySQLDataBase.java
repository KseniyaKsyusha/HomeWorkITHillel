package ua.en.kosse.oksana.hillel.hw22;

import java.sql.*;
import java.util.Random;

public class MySQLDataBase {
    static protected String NAME_DATABASE = "MyHomeWorkDB";

    static final String createBdQuery =
            "CREATE DATABASE IF NOT EXISTS " + NAME_DATABASE;

    static final String createHomeworkTableQuery =
            "CREATE TABLE IF NOT EXISTS `homework` (\r\n"

                    + "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n"
                    + "  `name` varchar(25) NOT NULL,\r\n"
                    + "  `description` varchar(255) NOT NULL,\r\n"

                    + "  PRIMARY KEY (`id`)\r\n"
                    + ")\r\n\r\n";

    static final String createLessonTableQuery =
            "CREATE TABLE IF NOT EXISTS `lesson` (\r\n"

                    + "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n"
                    + "  `name` varchar(25) NOT NULL,\r\n"
                    + "  `updatedAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\r\n"
                    + "  `homework_id` INT UNSIGNED,\r\n"


                    + " PRIMARY KEY (`id`),\r\n"
                    + " FOREIGN KEY (`homework_id`) REFERENCES `homework` (`id`)\r\n"
                    + ")\r\n\r\n";


    public static void CreateDataBase() throws SQLException {

        try {
            DataBaseConnection.getConnection().createStatement().executeUpdate(createBdQuery);
            System.out.printf("Database \" %s \" created successfully... \n", NAME_DATABASE);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void CreateTables() {
        try {
            DataBaseConnection.getConnection().createStatement().executeUpdate(createHomeworkTableQuery);
            System.out.println("Table Homework created successfully...");

            DataBaseConnection.getConnection().createStatement().executeUpdate(createLessonTableQuery);
            System.out.println("Table Lesson created successfully...");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void InitTablesWithDemoData() {

        try {
            // Homework
            String tableNameString = "homework";
            for (int i = 1; i <= 10; i++) {
                String sql =
                        "INSERT INTO " + tableNameString
                                + " (`name`, `description`) VALUES ("
                                + "\"" + tableNameString + "_name_" + i + "\", "
                                + "\"" + tableNameString + "_description_" + i + "\""
                                + ")";
                DataBaseConnection.getConnection().createStatement().executeUpdate(sql);
            }
            System.out.println("Table Homework initialized with demo data.");

            Random rand = new Random();

            // Lesson
            tableNameString = "lesson";
            for (int i = 1; i <= 10; i++) {
                String sql =
                        "INSERT INTO " + tableNameString
                                + " (`name`, `homework_id`) VALUES ("
                                + "\"" + tableNameString + "_name_" + i + "\", "
                                + rand.nextInt(1, 10)
                                + ")";
                DataBaseConnection.getConnection().createStatement().executeUpdate(sql);
            }
            System.out.println("Table Lesson initialized with demo data.");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
