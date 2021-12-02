package assignment_adf2.objectDaoImliment;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import assignment_adf2.object.customer;
import assignment_adf2.objectDao.customerDao;

public class customerImlement extends customer implements customerDao {
    private Connection connect;

    public customerImlement(Connection connect) {
        this.connect = connect;
    }

    // ------------- delete -------------
    @Override
    public void delete(String maKH) {
        String sql = "exec dbo.pr_delete_customer ?,?";
        CallableStatement cs = null;
        try {
            cs = connect.prepareCall(sql);
            cs.setString(1, maKH);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.execute();
            if (cs.getInt(2) == 1)
                System.out.println("Delete thanh cong");
            else
                System.out.println("Fail: khach hang da tao the");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ---------- insert -------------
    @Override
    public void insert(customer customer) {
        String sql = "insert into customer(maKH,tenKH,cmt,soDT,email,ngaySinh,gioiTinh,address,loaiKH) values (?,?,?,?,?,convert(date,?,103),?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareCall(sql);
            ps.setString(1, customer.getMaKH());
            ps.setString(2, customer.getTenKH());
            ps.setString(3, customer.getCmt());
            ps.setString(4, customer.getSoDT());
            ps.setString(5, customer.getEmail());
            ps.setString(6, customer.getNgaySinh());
            ps.setInt(7, customer.getGioiTinh());
            ps.setString(8, customer.getAddress());
            ps.setInt(9, customer.getLoaiKH());

            if (ps.executeUpdate() == 1)
                System.out.println("Update succesfully");
            else
                System.out.println("ma khach hang khong ton tai");

        } catch (SQLException e) {
            System.out.println("Update that bai");
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // ---------- show --------------

    @Override
    public List<customer> show() {
        List<customer> lCustomers = new ArrayList<>();
        String sql = "select * from customer";
        try {
            Statement state = connect.createStatement();
            ResultSet listSet = state.executeQuery(sql);
            customer cus = new customer();
            while (listSet.next()) {
                cus.setId(listSet.getInt(1));
                cus.setMaKH(listSet.getString(2));
                cus.setTenKH(listSet.getString(3));
                cus.setCmt(listSet.getString(4));
                cus.setSoDT(listSet.getString(5));
                cus.setEmail(listSet.getString(6));
                cus.setNgaySinh(listSet.getString(7));
                cus.setGioiTinh(listSet.getInt(8));
                cus.setAddress(listSet.getString(9));
                cus.setLoaiKH(listSet.getInt(10));
                lCustomers.add(cus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lCustomers;

    }

    // ----------- update --------------
    @Override
    public void update(customer customer) {
        String sql = "exec dbo.pr_update_customer ?,?,?,?,convert(date, ?, 103),?,?,?,?,?";
        CallableStatement cs = null;
        try {
            cs = connect.prepareCall(sql);
            cs.setString(1, customer.getTenKH());
            cs.setString(2, customer.getCmt());
            cs.setString(3, customer.getSoDT());
            cs.setString(4, customer.getEmail());
            cs.setString(5, customer.getNgaySinh());
            cs.setInt(6, customer.getGioiTinh());
            cs.setString(7, customer.getAddress());
            cs.setInt(8, customer.getLoaiKH());
            cs.setString(9, customer.getMaKH());
            cs.registerOutParameter(10, Types.INTEGER);
            cs.execute();

            if (cs.getInt(10) == 1)
                System.out.println("Update succesfully");
            else
                System.out.println("ma khach hang khong ton tai");

        } catch (SQLException e) {
            System.out.println("Update that bai");
            e.printStackTrace();
        } finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
