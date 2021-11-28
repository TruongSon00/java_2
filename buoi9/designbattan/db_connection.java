package buoi9.designbattan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import buoi9.utils.contant;

public class db_connection {
    private static db_connection instance;

    public static db_connection getInstance() {
        if (instance == null)
            instance = new db_connection();
        return instance;
    }

    public synchronized Connection getConnection() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(contant.url, contant.name, contant.password);
            System.out.println("-=========  Connect succesfully  =========");
        } catch (SQLException e) {
            System.out.println("--------- ERROR: Connect that bai!!! ---------");
            e.printStackTrace();
        }
        return connect;
    }
}
