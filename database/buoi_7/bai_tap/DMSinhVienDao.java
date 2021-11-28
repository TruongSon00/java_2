package database.buoi_7.bai_tap;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DMSinhVienDao extends DMSinhVien {
    private Connection connect;

    public DMSinhVienDao(Connection connect) {
        this.connect = connect;
    }

    public DMSinhVienDao(String maSV, String hoSV, String tenSV, String gender, String ngaySinh, String noiSinh,
            String maKhoa, Float hocBong) {
        super(maSV, hoSV, tenSV, gender, ngaySinh, noiSinh, maKhoa, hocBong);
    }

    // ----------- insert -----------
    public void insert(String maSV, String hoSV, String tenSV, String gender, String ngaySinh, String noiSinh,
            String maKhoa, Float hocBong) {
        String sql = "insert into DMSV(MaSV, HoSV, TenSV, Phai, NgaySinh, NoiSinh, MaKhoa, HocBong) values(?,?,?,?,?,?,?,?)";
        CallableStatement cs = null;

        try {
            cs = connect.prepareCall(sql);
            cs.setString(1, maSV);
            cs.setString(2, hoSV);
            cs.setString(3, tenSV);
            cs.setString(4, gender);

            try {
                cs.setDate(5, new java.sql.Date(sdf.parse(ngaySinh).getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            cs.setString(6, noiSinh);
            cs.setString(7, maKhoa);
            cs.setFloat(8, hocBong);
            if (cs.executeUpdate() == 1)
                System.out.println("insert thanh cong!!!");
            else if (cs.executeUpdate() == 0)
                System.out.println("khong the insert");
        } catch (SQLException e) {
            System.out.println("ERROR: Insert that bai!!!");
            e.printStackTrace();
        } finally {
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    // ----------- update -----------
    public void update(String maSV, String hoSV, String tenSV, String gender, String ngaySinh, String noiSinh,
            String maKhoa, Float hocBong) {
        String sql = "update DMSV set HoSV =?, TenSV=?,Phai=?,NgaySinh=?,NoiSinh=?,MaKhoa=?,HocBong=?  where MaSV =?";
        CallableStatement cs = null;
        try {
            cs = connect.prepareCall(sql);
            cs.setString(1, hoSV);
            cs.setString(2, tenSV);
            cs.setString(3, gender);
            try {
                cs.setDate(4, new java.sql.Date(sdf.parse(ngaySinh).getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cs.setString(5, noiSinh);
            cs.setString(6, maKhoa);
            cs.setFloat(7, hocBong);
            cs.setString(8, maSV);
            if (cs.executeUpdate() == 1)
                System.out.println("update thanh cong!!!");
            else if (cs.executeUpdate() == 0)
                System.out.println("Ma sinh vien khong ton tai");
        } catch (SQLException e) {
            System.out.println("ERROR: Update that bai!!!");
            e.printStackTrace();
        } finally {
            if (cs != null)
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    // ----------- delete -----------
    public void delete(String maSV) {
        String sql = "delete from DMSV  where MaSV = '" + maSV + "'";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            if (ps.executeUpdate() == 1)
                System.out.println("Delete thanh cong!!!");
            else if (ps.executeUpdate() == 0)
                System.out.println("Ma sinh vien khong ton tai");
        } catch (SQLException e) {
            System.out.println("ERROR: delete that bai!!!");
            e.printStackTrace();
        } finally {
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    // ----------- select -----------
    public List<DMSinhVienDao> select(String sql) {

        PreparedStatement ps = null;
        List<DMSinhVienDao> lSV = new ArrayList<>();
        try {
            ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            String maSV, hoSV, tenSV, gender, ngaySinh, noiSinh, maKhoa;
            float hocBong;

            while (result.next()) {
                maSV = result.getString(1);
                hoSV = result.getString(2);
                tenSV = result.getString(3);
                gender = result.getString(4);
                ngaySinh = sdf.format(result.getDate(5));
                noiSinh = result.getString(6);
                maKhoa = result.getString(7);
                hocBong = result.getFloat(8);

                lSV.add(new DMSinhVienDao(maSV, hoSV, tenSV, gender, ngaySinh, noiSinh, maKhoa, hocBong));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lSV;

    }

    // ----------- insert batch -----------
    public void insertTXT(File root) throws SQLException {
        File file = new File(root, "sinh_vien.txt");
        Scanner scanner = null;
        Statement state = connect.createStatement();
        String text, sql;
        String[] arrText;
        try {
            sql = "insert into DMSV(MaSV, HoSV, TenSV, Phai , NgaySinh, NoiSinh, MaKhoa, HocBong) values ";
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                arrText = scanner.nextLine().split(",");
                try {
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(arrText[4].replaceAll("'", ""));
                    arrText[4] = new java.sql.Date(date.getTime()).toString();
                    arrText[4] = "'" + arrText[4] + "'";
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                text = Arrays.toString(arrText);
                text = text.substring(1, text.length() - 1);
                state.addBatch(sql + "(" + text + ")");
            }

            int[] arrBatch = state.executeBatch();
            System.out.println("Thanh cong insert " + arrBatch.length + " ban ghi");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        state.close();
        scanner.close();
    }
}
