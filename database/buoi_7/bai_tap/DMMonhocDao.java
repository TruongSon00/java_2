package database.buoi_7.bai_tap;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DMMonhocDao extends DDMonhoc {
    private Connection connect;

    public DMMonhocDao(Connection connect) {
        this.connect = connect;
    }

    public DMMonhocDao(String maMH, String tenMH, int soTiet) {
        super(maMH, tenMH, soTiet);
    }

    public void nhapTT(Scanner sc) {
        System.out.println("Nhap thong tin mon hoc");
        System.out.print("Ma mon hoc: ");
        setMaMH(sc.nextLine());

        System.out.print("Ten mon hoc: ");
        setTenMH(sc.nextLine());

        System.out.print("Tiet mon hoc: ");
        int soTiet = 1;
        try {
            soTiet = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            sc.nextLine();
            e.printStackTrace();
        }
        setSoTiet(soTiet);
    }

    // ----------- insert -----------
    public void insert(String maMH, String tenMH, int soTiet) {
        String sql = "insert into DMMH(MaMH, TenMH, SoTiet) values(?,?,?)";
        CallableStatement cs = null;
        try {
            cs = connect.prepareCall(sql);
            cs.setString(1, maMH);
            cs.setString(2, tenMH);
            cs.setInt(3, soTiet);
            if (cs.executeUpdate() == 1)
                System.out.println("Insert thanh cong!!!");
            else
                System.out.println("Insert loi");

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
    public void update(String maMH, String tenMH, int soTiet) {
        String sql = "update DMMH set TenMH =?, SoTiet =? where MaMH =?";
        CallableStatement cs = null;
        try {
            cs = connect.prepareCall(sql);
            cs.setString(1, tenMH);
            cs.setInt(2, soTiet);
            cs.setString(3, maMH);

            if (cs.executeUpdate() == 1)
                System.out.println("update thanh cong!!!");
            else if (cs.executeUpdate() == 0)
                System.out.println("Ma mon hoc khong ton tai");
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
    public void delete(String maMHCanDel) {
        String sql = "delete from DMMH  where MaMH = '" + maMHCanDel + "'";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            if (ps.executeUpdate() == 1)
                System.out.println("Delete thanh cong!!!");
            else if (ps.executeUpdate() == 0)
                System.out.println("Ma mon hoc khong ton tai");
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
    public List<DDMonhoc> select(String sql) {

        PreparedStatement ps = null;
        List<DDMonhoc> lMonhocs = new ArrayList<>();
        try {
            ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            String maMH, tenMH;
            int soTiet;
            while (result.next()) {
                maMH = result.getString(1);
                tenMH = result.getString(2);
                soTiet = result.getInt(3);
                lMonhocs.add(new DDMonhoc(maMH, tenMH, soTiet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lMonhocs;

    }

    // ----------- insert batch -----------
    public void insertTXT(File root) throws SQLException {
        File file = new File(root, "mon_hoc.txt");
        Scanner scanner = null;
        String text = "insert into DMMH(MaMH, TenMH, SoTiet) values ";
        Statement state = connect.createStatement();
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine())
                state.addBatch(text + "(" + scanner.nextLine() + ")");
            int[] arr = state.executeBatch();
            if (arr != null)
                System.out.println("Insert thanh cong " + arr.length + " ban ghi");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        state.close();
        scanner.close();
    }

}
