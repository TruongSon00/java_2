package database.buoi_7;

import java.sql.SQLException;

public class manage {
    public static void main(String[] args) throws SQLException {
        tool maniputing = new tool();
        // --------- create table --------

        // System.out.println(maniputing.createTable());
        maniputing.inserts(5, "conan", 10000);
        System.out.println(maniputing.getList().toString());

        maniputing.updateBook(2, "sach update", 10000);

        System.out.println(maniputing.getList().toString());
    }
}
