package database.buoi_7.bai_tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect_database {
    private final static String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=QuanLyDiemSV";
    private final static String name = "SA";
    private final static String password = "Son123456";

    public static Connection getConnect() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(url, name, password);
            System.out.println("*******  Connect succesfully!!! ******");
        } catch (SQLException e) {
            System.out.println("-------  ERROR: Connect failed!!! -------");
            e.printStackTrace();
        }
        return connect;
    }
}
