package ua.en.kosse.oksana.hillel.hw21;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class QuerySQL extends MySQLDataBase {
    static final String allHomeworkTableRecords =
            "\r\n SELECT * \r\n"
               + " FROM "+NAME_DATABASE+".homework h \r\n";

    static final String allLessonAndHomeworkTableRecords =
            "\r\n SELECT * \r\n"
              + " FROM  "+ NAME_DATABASE+".lesson l\r\n"
              + " INNER JOIN "+NAME_DATABASE+".homework h ON l.homework_id = h.id \r\n";

    static final String allLessonAndHomeworkTableOrderedRecords =
            allLessonAndHomeworkTableRecords
                    + " ORDER BY l.updatedAt DESC \r\n";

    static final String allScheduleAndLessonTableRecords =
            "\r\n SELECT *\r\n"
              + " FROM "+NAME_DATABASE+".schedule s \r\n"
              + " Inner Join "+NAME_DATABASE+".scheduled_lessons sl ON s.id = sl.schedule_id \r\n"
              + " Inner Join "+NAME_DATABASE+".lesson l ON l.id = sl.lesson_id \r\n";

    static final String allScheduleTableRecordsWithLessonsCount =
            "\r\n SELECT s.name, COUNT(sl.lesson_id) AS l_count \r\n"
              + " FROM "+NAME_DATABASE+".schedule s \r\n"
              + " Inner Join "+NAME_DATABASE+".scheduled_lessons sl ON s.id = sl.schedule_id \r\n"
              + " GROUP BY sl.schedule_id \r\n"
              + " ORDER BY s.name \r\n";

    public static void PrintAllQueriesResults() {
        // Print all Homework records
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(allHomeworkTableRecords);
        ) {

            System.out.println("\nAll HomeWorks table records:");
            while (resultSet.next()) {
                System.out.print("Id: " + resultSet.getInt("h.id"));
                System.out.print(", Name: " + resultSet.getString("h.name"));
                System.out.println(", Description: " + resultSet.getString("h.description"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        // Print all Lesson table records including
        // Homework table records
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(allLessonAndHomeworkTableRecords);
        ) {

            System.out.println("\nAll Lesson with HomeWorks tables records:");
            while (resultSet.next()) {
                System.out.print("h.id: " + resultSet.getInt("h.id"));
                System.out.print(", h.name: " + resultSet.getString("h.name"));
                System.out.print(", l.id: " + resultSet.getInt("l.id"));
                System.out.print(", l.name: " + resultSet.getString("l.name"));
                System.out.println(", l.homework_id: " + resultSet.getInt("l.homework_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Print all Lesson table records including
        // Homework table records, ordered by updatedAt
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(allLessonAndHomeworkTableOrderedRecords);
        ) {

            System.out.println("\nAll Lesson with HomeWorks tables ordered records:");
            while (resultSet.next()) {
                System.out.print("h.id: " + resultSet.getInt("h.id"));
                System.out.print(", h.name: " + resultSet.getString("h.name"));
                System.out.print(", l.id: " + resultSet.getInt("l.id"));
                System.out.print(", l.name: " + resultSet.getString("l.name"));
                System.out.print(", l.homework_id: " + resultSet.getInt("l.homework_id"));
                System.out.println(", date: " + resultSet.getString("l.updatedAt"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        // Print all Schedule table records including
        // Lesson table records
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(allScheduleAndLessonTableRecords);
        ) {

            System.out.println("\nAll Schedule with Lesson tables records:");
            while (resultSet.next()) {
                System.out.print("s.id: " + resultSet.getInt("s.id"));
                System.out.print(", s.name: " + resultSet.getString("s.name"));
                System.out.print(", l.id: " + resultSet.getInt("l.id"));
                System.out.print(", l.name: " + resultSet.getString("l.name"));
                System.out.print(", sl.schedule_id: " + resultSet.getInt("sl.schedule_id"));
                System.out.println(", sl.lesson_id: " + resultSet.getInt("sl.lesson_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        // Print Lesson count for each Schedule
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(allScheduleTableRecordsWithLessonsCount);
        ) {

            System.out.println("\nAll Lessons count for each Schedule:");
            while (resultSet.next()) {
                System.out.print("s.name: " + resultSet.getString("s.name"));
                System.out.println(", l.count: " + resultSet.getInt("l_count"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void PrintDMLIntoFile(String fileName) {
        File file = new File(fileName);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.append(allHomeworkTableRecords);
            bufferedWriter.append(allLessonAndHomeworkTableRecords);
            bufferedWriter.append(allLessonAndHomeworkTableOrderedRecords);
            bufferedWriter.append(allScheduleAndLessonTableRecords);
            bufferedWriter.append(allScheduleTableRecordsWithLessonsCount);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println("\nDML commands saved into file: " + file.getAbsolutePath());

    }
}
