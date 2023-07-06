package ua.en.kosse.oksana.hillel.hw21;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Random;

public class MySQLDataBase {
    static protected String NAME_DATABASE = "MyHomeWorkDB";
    static protected String DB_URL = "jdbc:mysql://localhost:3306/" + NAME_DATABASE;
    static protected String USERNAME = "root";
    static protected String PASSWORD = "_Live22_";

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
                    + "  `schedule_id` INT UNSIGNED,\r\n"

                    + " PRIMARY KEY (`id`),\r\n"
                    + " FOREIGN KEY (`homework_id`) REFERENCES `homework` (`id`),\r\n"
                    + " FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`)\r\n"
                    + ")\r\n\r\n";

    static final String createScheduleTableQuery =
            "CREATE TABLE IF NOT EXISTS `schedule` (\r\n"

                    + "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n"
                    + "  `name` varchar(25) NOT NULL,\r\n"
                    + "  `updatedAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\r\n"

                    + "  PRIMARY KEY (`id`)\r\n"
                    + ")\r\n\r\n";

    static final String createScheduledLessonsTableQuery =
            "CREATE TABLE IF NOT EXISTS `scheduled_lessons` (\r\n"

                    + "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n"
                    + "  `schedule_id` INT UNSIGNED NOT NULL,\r\n"
                    + "  `lesson_id` INT UNSIGNED NOT NULL,\r\n"

                    + " PRIMARY KEY (`id`),\r\n"
                    + " FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`),\r\n"
                    + " FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`)\r\n"
                    + ")\r\n\r\n";


    public static void CreateDataBase() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate(createBdQuery);
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

            statement.executeUpdate(createScheduleTableQuery);
            System.out.println("Table Schedule created successfully...");

            statement.executeUpdate(createLessonTableQuery);
            System.out.println("Table Lesson created successfully...");

            statement.executeUpdate(createScheduledLessonsTableQuery);
            System.out.println("Table ScheduledLessons created successfully...");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void InitTablesWithDemoData() {

        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()
        ) {
            // Homework
            String tableNameString = "homework";
            for (int i = 10; i <= 10; i++) {
                String sql =
                        "INSERT INTO " + tableNameString
                                + " (`name`, `description`) VALUES ("
                                + "\"" + tableNameString + "_name_" + i + "\", "
                                + "\"" + tableNameString + "_description_" + i + "\""
                                + ")";
                statement.executeUpdate(sql);
            }
            System.out.println("Table Homework initialized with demo data.");

            // Schedule
            tableNameString = "schedule";
            for (int i = 1; i <= 10; i++) {
                String sql =
                        "INSERT INTO " + tableNameString
                                + " (`name`) VALUES ("
                                + "\"" + tableNameString + "_name_" + i + "\""
                                + ")";
                statement.executeUpdate(sql);
            }
            System.out.println("Table Schedule initialized with demo data.");

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
                statement.executeUpdate(sql);
            }
            System.out.println("Table Lesson initialized with demo data.");

            // ScheduledLessons
            tableNameString = "scheduled_lessons";
            for (int i = 1; i <= 10; i++) {
                String sql =
                        "INSERT INTO " + tableNameString
                                + " (`schedule_id`, `lesson_id`) VALUES ("
                                + rand.nextInt(1, 5) + ", "
                                + rand.nextInt(1, 10)
                                + ")";
                statement.executeUpdate(sql);
            }
            System.out.println("Table ScheduledLessons initialized with demo data.");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void PrintAllHomeWorksByScheduleName(
            String scheduleName) {
        String query = "SELECT \r\n"
                + "	   s.name, \r\n"
                + "    h.name, \r\n"
                + "    h.description\r\n"
                + "FROM \r\n"
                + "	   learningprocess.schedule s, 	\r\n"
                + "    learningprocess.scheduled_lessons sl, \r\n"
                + "    learningprocess.lesson l, \r\n"
                + "    learningprocess.homework h\r\n"
                + "WHERE \r\n"
                + "	   s.name = '" + scheduleName + "' \r\n"
                + "    AND s.id = sl.schedule_id \r\n"
                + "    AND sl.lesson_id = l.id \r\n"
                + "    AND l.homework_id = h.id;";

        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)
        ) {

            System.out.println("All home works by schedule name: " + scheduleName);
            while (resultSet.next()) {
                System.out.print("Schedule name: " + resultSet.getString("s.name"));
                System.out.print(", Homework name: " + resultSet.getString("h.name"));
                System.out.println(", Homework description: " + resultSet.getString("h.description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void PrintDDLIntoFile(String fileName) {
        File file = new File(fileName);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.append(createHomeworkTableQuery);
            bufferedWriter.append(createLessonTableQuery);
            bufferedWriter.append(createScheduleTableQuery);
            bufferedWriter.append(createScheduledLessonsTableQuery);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println(
                "DDL commands saved into file: " + file.getAbsolutePath());

    }
}
