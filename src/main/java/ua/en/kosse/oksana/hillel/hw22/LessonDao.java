package ua.en.kosse.oksana.hillel.hw22;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class LessonDao {


    public static void writeDataToLesson(String lessonName, int homeworkId) throws SQLException {
        if (checkIdInTable("Lesson", "homework_id", homeworkId)) {
            String sql = "INSERT INTO Lesson(name, homework_id) VALUES (?, ?) ";
            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = DataBaseConnection.getConnection().prepareStatement(sql);
                preparedStatement.setString(1, lessonName);
                preparedStatement.setInt(2, homeworkId);
                preparedStatement.execute();
                System.out.println("Lesson " + lessonName + "  was added");
                DataBaseConnection.close(preparedStatement.getConnection());

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("There is not homework with id = " + homeworkId);
        }
    }


    public static void deleteDataFromLesson(int lessonId) throws SQLException {
        if (checkIdInTable("Lesson", "id", lessonId)) {
            String sql = "DELETE FROM Lesson WHERE id = ? ";
            PreparedStatement preparedStatement = null;
            try {

                preparedStatement = DataBaseConnection.getConnection().prepareStatement(sql);
                preparedStatement.setInt(1, lessonId);
                preparedStatement.execute();
                if (!checkIdInTable("Lesson", "id", lessonId)) {
                    System.out.println("lesson with id = " + lessonId + " was deleted");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DataBaseConnection.close(preparedStatement.getConnection());
            }
        } else {
            System.out.println("no lesson with id = " + lessonId);
        }
    }

    public static List<Lesson> createLessonList(String tableName) throws SQLException {
        ResultSet resultSet = getDataFromDB(tableName);

        List<Lesson> lessons = new ArrayList<>();
        while (resultSet.next()) {
            Lesson lesson = new Lesson();
            lesson.setId(resultSet.getInt("id"));
            lesson.setName(resultSet.getString("name"));
            lesson.setHomework_id(resultSet.getInt("homework_id"));
            lessons.add(lesson);
        }
        return lessons;
    }

   
    public static Lesson getDataFromLessonById(Integer lessonId) throws SQLException {
        Lesson lesson = null;
        if (checkIdInTable("Lesson", "id", lessonId)) {
            String sql = "SELECT * FROM Lesson WHERE id = ?  ";
            PreparedStatement preparedStatement = null;
            ResultSet resultSet;

            try {
                preparedStatement = DataBaseConnection.getConnection().prepareStatement(sql);
                preparedStatement.setInt(1, lessonId);
                preparedStatement.execute();

                resultSet = preparedStatement.getResultSet();
                lesson = new Lesson();
                while (resultSet.next()) {
                    lesson.setId(resultSet.getInt("id"));
                    lesson.setName(resultSet.getString("name"));
                    lesson.setHomework_id(resultSet.getInt("homework_id"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DataBaseConnection.close(preparedStatement.getConnection());
            }
        } else {
            System.out.println("no lesson with id = " + lessonId);
            return new Lesson();
        }
        return lesson;
    }

    private static ResultSet getDataFromDB(String tableName) throws SQLException {
        String sql = "SELECT * FROM " + tableName;

        ResultSet resultSet = null;
        try {
            resultSet = DataBaseConnection.getConnection().createStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    private static boolean checkIdInTable(String tableName, String fieldName, int id) throws SQLException {
        String sql = "SELECT * FROM  " + tableName;
        ResultSet resultSet = null;
        try {
            resultSet = DataBaseConnection.getConnection().createStatement().executeQuery(sql);

            while (resultSet.next()) {
                int intValue = Integer.parseInt(resultSet.getObject(fieldName).toString());
                if (intValue == id) {
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DataBaseConnection.close(resultSet.getStatement().getConnection());
        }
    }

    public static <T> void printAllDataFromList(List<T> list) {
        System.out.println("id|  name          | updatedAt");
        for (T t : list) {
            System.out.println(t.toString());
        }
        System.out.println();
    }

}