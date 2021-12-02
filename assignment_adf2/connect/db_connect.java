package assignment_adf2.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import assignment_adf2.util.const_util;

public class db_connect {
    public static Connection getConnect() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(const_util.url, const_util.user, const_util.password);
            System.out.println("------------ Connect succesfully -----------");
        } catch (SQLException e) {
            System.out.println("-------- ERROR: Connect fail -------");
        }
        return connect;
    }
}
