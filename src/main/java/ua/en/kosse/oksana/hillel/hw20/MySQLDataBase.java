package ua.en.kosse.oksana.hillel.hw20;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class MySQLDataBase {
    static protected String NAME_DATABASE = "LearningProcess";
    static protected String DB_URL = "jdbc:mysql://localhost:3306/" + NAME_DATABASE;
    static protected String USERNAME = "root";
    static protected String PASSWORD = "_Live22_";

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

    static final String createScheduleTableQuery =
            "CREATE TABLE IF NOT EXISTS `schedule` (\r\n"

                    + "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n"
                    + "  `name` varchar(25) NOT NULL,\r\n"
                    + "  `updatedAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\r\n"

                    + "  PRIMARY KEY (`id`)\r\n"
                    + ")\r\n\r\n";


    public static void CreateDataBase() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()
        ) {
            System.out.printf("Database \" %s \" created successfully... \n", NAME_DATABASE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void CreateTables() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate(createHomeworkTableQuery);
            System.out.println("Table Homework created successfully...");
            statement.executeUpdate(createLessonTableQuery);
            System.out.println("Table Lesson created successfully...");
            statement.executeUpdate(createScheduleTableQuery);
            System.out.println("Table Schedule created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void InitTablesWithDemoData() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()
        ) {

            String tableNameString = "homework";
            for (int i = 0; i < 10; i++) {
                String sql =
                        "INSERT INTO " + tableNameString
                                + " (`name`, `description`) VALUES ("
                                + "\"" + tableNameString + "_name_" + i + "\", "
                                + "\"" + tableNameString + "_description_" + i + "\""
                                + ")";
                statement.executeUpdate(sql);
            }
            System.out.println("Table Homework initialized with demo data.");


            tableNameString = "schedule";
            for (int i = 0; i < 10; i++) {
                String sql =
                        "INSERT INTO " + tableNameString
                                + " (`name`) VALUES ("
                                + "\"" + tableNameString + "_name_" + i + "\""
                                + ")";
                statement.executeUpdate(sql);
            }
            System.out.println("Table Schedule initialized with demo data.");

            Random rand = new Random();


            tableNameString = "lesson";
            for (int i = 0; i < 10; i++) {
                String sql =
                        "INSERT INTO " + tableNameString
                                + " (`name`, `homework_id`) VALUES ("
                                + "\"" + tableNameString + "_name_" + i + "\", "
                                + rand.nextInt(1, 10)
                                + ")";
                statement.executeUpdate(sql);
            }
            System.out.println("Table Lesson initialized with demo data.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void PrintDDLIntoFile(String fileName) {
        File file = new File(fileName);

        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.append(createHomeworkTableQuery);
            bufferedWriter.append(createLessonTableQuery);
            bufferedWriter.append(createScheduleTableQuery);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println(
                "DDL commands saved into file: " + file.getAbsolutePath());

    }
}
