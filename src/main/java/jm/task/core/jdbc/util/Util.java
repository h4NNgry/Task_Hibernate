package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/users_task1";
    final static String USERNAME = "root";
    final static String PASSWORD = "root";

    public static Connection getConnection() {

        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;

//        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
//            Class.forName(DRIVER);
//            System.out.println("Connected!");
//
//            return connection;
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        //    public static Connection getConnection() {
//
//        Connection connection = null;
//
//        try {
//            Class.forName(DRIVER);
//            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
//            System.out.println("Connected!");
//
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println("Failed to connect");;
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                System.out.println("Connection is not closed");
//            }
//        }
//        return connection;
//    }


    }

}
