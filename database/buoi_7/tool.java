package database.buoi_7;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class tool {
    Connection connect = dbConnect.getConnect();

    // --------- 0. create table --------
    public boolean createTable() {
        String sql = "create table person( id int primary key, name nvarchar(30), price int,)";
        Statement state = null;
        try {
            state = connect.createStatement();
            state.execute(sql);
            System.out.println("Create table succes");
            return true;
        } catch (Exception e) {
            System.out.println("------- Co 1 loi gi do!!! ----------");
        }
        return false;
    }

    // ------ 1. insert ---------
    public boolean inserts(int id, String name, int price) {

        PreparedStatement cs = null;
        try {
            String sql = "insert into book(id, name, price) values(" + id + ",'" + name + "'," + price + ")";
            cs = connect.prepareStatement(sql);
            cs.execute();
            System.out.println("Them thanh cong");
        } catch (Exception e) {
            System.out.println("Them that bai");
        } finally {
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

        }
        return true;
    }
    // ------ 2. update ---------

    public boolean updateBook(int id, String name, int price) {
        boolean result = false;

        if (connect == null) {
            return false;
        }
        // -------- cung la lenh spl toi db nhung co ho tro truyen tham so vao query
        CallableStatement cs = null;

        try {
            // b2 thao tac du lieu
            String sql = "exec dbo.pr_update_book ?,?,?,?";
            cs = connect.prepareCall(sql);
            cs.setInt(1, 1);
            cs.setString(2, name);
            cs.setInt(3, price);
            cs.registerOutParameter(4, Types.VARCHAR);

            cs.execute();
            // b3: xu ly ket qua

            String err_desc = cs.getString(4);

            System.out.println("err_desc: " + err_desc);
        } catch (Exception e) {
            System.out.println("ERROR: update that bai!!!");
            e.printStackTrace();
        } finally {
            try {
                if (cs != null)
                    cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    // ------ 3. delete ---------

    public boolean deleteBook(int id) {
        boolean result = false;

        if (connect == null) {
            // -------- cung la lenh spl toi db nhung co ho tro truyen tham so vao query
            return false;
        }
        PreparedStatement ps = null;

        try {
            String sql = "delete from id=?";
            ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            int num = ps.executeUpdate();
            if (num == 1)
                System.out.println("xoa thanh cong");

        } catch (Exception e) {

        } finally {

            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // ------ select ---------

    public List<book> getList() {
        List<book> result = new ArrayList<>();

        if (connect == null) {
            // -------- cung la lenh spl toi db nhung co ho tro truyen tham so vao query
            return null;
        }
        PreparedStatement ps = null;

        try {
            String sql = "select id, name, price from book";
            ps = connect.prepareStatement(sql);

            // resultset dai dien cho tap du lieu dang bang tra ve cua query
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // lay du lieu cac cot trong hang
                int id = rs.getInt(1);
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                book sach = new book(id, name, price);
                result.add(sach);
            }
        } catch (Exception e) {

        } finally {

            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // --------- insert batch ------------
    // ****** tu hoc *******
}
