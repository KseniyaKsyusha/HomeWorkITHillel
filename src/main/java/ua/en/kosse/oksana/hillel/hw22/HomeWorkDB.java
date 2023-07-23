package ua.en.kosse.oksana.hillel.hw22;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

public class HomeWorkDB {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try (Connection connection = DataBaseConnection.getConnection()) {
            DatabaseMetaData dma = connection.getMetaData();

            // Печать сообщения об успешном соединении
            System.out.println("\nConnected to " + dma.getURL());
            System.out.println("Driver " + dma.getDriverName());
            System.out.println("Version " + dma.getDriverVersion());
            System.out.println("Есть контакт!");


        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create empty BD
        try {
            MySQLDataBase.CreateDataBase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Create Tables
        System.out.println();
        MySQLDataBase.CreateTables();

        // Init with demo data
        MySQLDataBase.InitTablesWithDemoData();


        System.out.println();
        System.out.println("добавить запись");
        LessonDao.writeDataToLesson("lesson_name_10", 5);

        System.out.println();
        System.out.println("удалить по id");
        LessonDao.deleteDataFromLesson(11);


        System.out.println();
        System.out.println("получить все уроки");
        List<Lesson> lessons = LessonDao.createLessonList("Lesson");
        LessonDao.printAllDataFromList(lessons);

        System.out.println("получить урок по id");
        Lesson lesson = LessonDao.getDataFromLessonById(5);
        System.out.println(lesson.toString());
    }
}

