package assignment_adf2.objectDaoImliment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import assignment_adf2.object.account;
import assignment_adf2.objectDao.accountDao;

public class accountImliment extends account implements accountDao {
    private Connection connect;

    public accountImliment(Connection connect) {
        this.connect = connect;
    }

    // ----------- insert ---------------
    @Override
    public void insert(account customer) {
        String sql = "insert into account(kh_id, sotk , loaitk , trangThai, ngayTao, soTien, hanMuc) values (?,?,?,?,convert (date, ?, 103),?,?)";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setInt(1, customer.getKhID());
            ps.setString(2, customer.getSoTK());
            ps.setInt(3, customer.getLoaitk());
            ps.setInt(4, customer.getTrangThai());
            ps.setString(5, customer.getNgayTao());
            ps.setInt(6, customer.getSoTien());
            ps.setInt(7, customer.getHanMuc());
            if (ps.executeUpdate() == 1)
                System.out.println("Insert thanh cong");
            else
                System.out.println("ERROR: insert that bai");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void napTien(account customer) {

    }

    @Override
    public void rutTien(String maKH) {

    }

    @Override
    public List<account> tkTheoMaKH(String maKH) {

        return null;
    }

    @Override
    public account tkTheoSoTK(String soTK) {

        return null;
    }

}
