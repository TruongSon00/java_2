package database.buoi_7.bai_tap;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KetQuaDao extends Ketqua {
    private Connection connect;

    public KetQuaDao(Connection connect) {
        this.connect = connect;
    }

    public KetQuaDao(String maSV, String maMH, int lanThi, float diem) {
        super(maSV, maMH, lanThi, diem);
    }

    // ----------- insert -----------
    public void insert(String maSV, String maMH, int lanThi, float diem) {
        String sql = "insert into KetQua(MaSV,MaMH,LanThi,Diem) values(?,?,?,?)";
        CallableStatement cs = null;
        try {
            cs = connect.prepareCall(sql);
            cs.setString(1, maSV);
            cs.setString(2, maMH);
            cs.setInt(3, lanThi);
            cs.setFloat(4, diem);
            if (cs.executeUpdate() == 1)
                System.out.println("Insert thanh cong!!!");
            else if (cs.executeUpdate() == 0)
                System.out.println("Loi insert");
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
    public void update(String maSV, String maMH, int lanThi, float diem) {
        String sql = "exec dbo.pr_update_diem ?,?,?,?,?";
        CallableStatement cs = null;
        try {
            cs = connect.prepareCall(sql);
            cs.setString(1, maSV);
            cs.setString(2, maMH);
            cs.setInt(3, lanThi);
            cs.setFloat(4, diem);
            cs.registerOutParameter(5, Types.VARCHAR);

            cs.execute();
            System.out.println("Status: " + cs.getString(5));
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
    public void delete(String maSV, String maMH) {
        String sql = "delete from KetQua  where MaSV ='" + maSV + "' MaMH = '" + maMH + "'";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            if (ps.executeUpdate() == 1)
                System.out.println("Delete thanh cong!!!");
            else if (ps.executeUpdate() == 0)
                System.out.println("Ma id diem khong ton tai");
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
    public List<KetQuaDao> select(String sql) {

        PreparedStatement ps = null;
        List<KetQuaDao> lMonhocs = new ArrayList<>();
        try {
            ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            String MaSV, maMH;
            int lanThi;
            float diem;
            while (result.next()) {
                MaSV = result.getString(1);
                maMH = result.getString(2);
                lanThi = result.getInt(3);
                diem = result.getFloat(4);
                lMonhocs.add(new KetQuaDao(MaSV, maMH, lanThi, diem));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lMonhocs;

    }

    // ----------- insert batch -----------

    public void insertTXT(File root) throws SQLException {
        File file = new File(root, "diem.txt");
        Scanner scanner = null;
        Statement state = connect.createStatement();
        try {
            String text = "insert into KetQua(MaSV, MaMH, LanThi, Diem) values ";
            scanner = new Scanner(file);
            while (scanner.hasNextLine())
                state.addBatch(text + "(" + scanner.nextLine() + ")");

            int[] arr = state.executeBatch();
            System.out.println("Thanh cong insert " + arr.length + " ban ghi");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        state.close();
        scanner.close();
    }

}
