package ua.en.kosse.oksana.hillel.hw20;

import com.github.javafaker.Faker;

import java.lang.reflect.InvocationTargetException;

public class HomeWorkDB {
    public static void main(String[] args) throws ClassNotFoundException {
        Faker faker = new Faker();

        try {
            MySQLDataBase.CreateDataBase();
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException |
                 InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        MySQLDataBase.CreateTables();
        MySQLDataBase.InitTablesWithDemoData();
        MySQLDataBase.PrintDDLIntoFile("myquery.sql");
    }
}

