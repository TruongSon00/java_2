package database.buoi_7.bai_tap;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DDKhoaDao extends DMKhoa {

    public DDKhoaDao(String maKhoa, String tenKhoa) {
        super(maKhoa, tenKhoa);

    }

    private Connection connect;

    public DDKhoaDao(Connection connect) {
        this.connect = connect;
    }

    public void nhapTT(Scanner sc) {
        System.out.println("Nhap thong tin khoa");
        System.out.print("Nhap ma khoa: ");
        this.setMaKhoa(sc.nextLine());

        System.out.print("Nhap Ten khoa: ");
        this.setTenKhoa(sc.nextLine());
    }

    // --------- insert ----------
    public void insert(String maKhoa, String tenKhoa) {
        CallableStatement cs = null;
        String sql = "insert into DMKhoa(MaKhoa, TenKhoa) values(?,?)";
        try {
            cs = connect.prepareCall(sql);
            cs.setString(1, maKhoa);
            cs.setString(2, tenKhoa);
            if (cs.executeUpdate() == 1)
                System.out.println("insert thanh cong!!!");
            else if (cs.executeUpdate() == 0)
                System.out.println("Khong the insert");
        } catch (SQLException e) {
            System.out.println("ERROR: Insert that bai!!!");
            e.printStackTrace();
        } finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // ---------- update -----------
    public void update(String maKhoa, String tenKhoa) {
        CallableStatement cs = null;
        String sql = "exec dbo.pr_update_khoa ?,?,?";

        try {
            cs = connect.prepareCall(sql);
            cs.setString(1, maKhoa);
            cs.setString(2, tenKhoa);
            cs.registerOutParameter(3, Types.NVARCHAR);
            cs.execute();
            System.out.println("status: " + cs.getString(3));
        } catch (SQLException e) {
            System.out.println("ERROR: Update that bai!!!");
            e.printStackTrace();
        } finally {
            try {

                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // ---------- delete -----------
    public void delete(String maKhoa) {
        CallableStatement cs = null;
        String sql = "DELETE FROM DMKhoa WHERE MaKhoa = ?";

        try {
            cs = connect.prepareCall(sql);
            cs.setString(1, maKhoa);
            if (cs.executeUpdate() == 1)
                System.out.println("Delete thanh cong!!!");
            else if (cs.executeUpdate() == 0)
                System.out.println("Ma khoa khong ton tai");

        } catch (SQLException e) {
            System.out.println("ERROR: Delete that bai!!!");
            e.printStackTrace();
        } finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // ---------- Select -----------
    public List<DMKhoa> select() {
        Statement sta = null;
        String sql = "select * from DMKhoa";

        List<DMKhoa> lKhoas = new ArrayList<>();
        try {
            sta = connect.createStatement();
            ResultSet result = sta.executeQuery(sql);
            String maKhoa, tenKhoa;
            while (result.next()) {
                maKhoa = result.getString(1);
                tenKhoa = result.getString(2);
                lKhoas.add(new DMKhoa(maKhoa, tenKhoa));
            }
            return lKhoas;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        lKhoas.add(new DMKhoa("empty", "chua co khoa"));
        return lKhoas;
    }

    // ---------- insert batchc -----------
    public void insertTXT(File root) throws SQLException {
        File file = new File(root, "khoa.txt");
        Scanner scanner = null;
        Statement state = connect.createStatement();
        try {
            String text = "insert into DMKhoa(MaKhoa, TenKhoa) values ";
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
