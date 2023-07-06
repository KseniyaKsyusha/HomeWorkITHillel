package ua.en.kosse.oksana.hillel.hw21;

import java.lang.reflect.InvocationTargetException;

public class HomeWorkDB {
    public static void main(String[] args) throws ClassNotFoundException {

        // Create empty BD
        try {
            MySQLDataBase.CreateDataBase();
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException |
                 InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // Create Tables
        MySQLDataBase.CreateTables();


        // Init with demo data
        MySQLDataBase.InitTablesWithDemoData();

        // Print all home works by schedule name
        MySQLDataBase.PrintAllHomeWorksByScheduleName("schedule_name_3");

        // Create file with DDL commands
        MySQLDataBase.PrintDDLIntoFile("init.sql");

        // Print all queries results
        QuerySQL.PrintAllQueriesResults();

        // Create file with DML commands
        QuerySQL.PrintDMLIntoFile("fetch.sql");
    }
}

