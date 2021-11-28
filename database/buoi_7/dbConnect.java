package database.buoi_7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnect {
    private static final String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=TestDB";
    private static final String name = "SA";
    private static final String passWord = "Son123456";

    public static Connection getConnect() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(url, name, passWord);
            System.out.println("----  Connect succesfully!!!  ----");
        } catch (SQLException e) {
            System.out.println("----  Error: connect Fail!!!  ----");
            e.printStackTrace();
        }
        return connect;
    }

}