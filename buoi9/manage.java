package buoi9;

import java.sql.Connection;

import buoi9.designbattan.db_connection;

public class manage {
    public static void main(String[] args) {
        db_connection instance1 = db_connection.getInstance();
        db_connection instance2 = db_connection.getInstance();
        Connection connect = instance1.getConnection();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(connect);
        System.out.println("test");
    }
}
