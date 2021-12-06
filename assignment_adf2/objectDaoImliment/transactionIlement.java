package assignment_adf2.objectDaoImliment;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import assignment_adf2.object.giaoDich;

public class transactionIlement extends giaoDich {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    File root = new File(System.getProperty("user.dir"), "assignment_adf2/xuatFile");
    private Connection connect;

    public transactionIlement(Connection connect) {
        this.connect = connect;
    }

    public void transactionTheoAcc(String matk, String beginTime, String endTime) {
        String sql = "select * from giaoDich "
                + "where sotk = ? ngayTao >= convert(date,?,103) and ngayTao <= convert(date,?,103) order by ngayTao";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setString(1, matk);
            ps.setString(2, beginTime);
            ps.setString(3, endTime);
            ResultSet lTransaction = ps.executeQuery();

            giaoDich transaction = new giaoDich();
            while (lTransaction.next()) {
                transaction.setId(lTransaction.getInt(1));
                transaction.setSoTK(lTransaction.getString(2));
                transaction.setLoaiTT(lTransaction.getInt(3));
                transaction.setSoTien(lTransaction.getInt(4));
                transaction.setNgayTao(sdf.format(lTransaction.getDate(5)));
                transaction.setNoiThucHien(lTransaction.getString(6));
                System.out.println(transaction.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void transactionTheoCus(String maKH, String beginTime, String endTime) {
        String sql = "exec dbo.pr_select_transaction_cus ?,?,?";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setString(1, maKH);
            ps.setString(2, beginTime);
            ps.setString(3, endTime);

            ResultSet lTransaction = ps.executeQuery();
            giaoDich transaction = new giaoDich();
            while (lTransaction.next()) {
                transaction.setId(lTransaction.getInt(1));
                transaction.setSoTK(lTransaction.getString(2));
                transaction.setLoaiTT(lTransaction.getInt(3));
                transaction.setSoTien(lTransaction.getInt(4));
                transaction.setNgayTao(sdf.format(lTransaction.getDate(5)));
                transaction.setNoiThucHien(lTransaction.getString(6));
                System.out.println(transaction.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean xuatFile(String month, String year) {
        String sql = "exec dbo.pr_transaction_theoMonth ?,?";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setString(1, month);
            ps.setString(2, year);
            ResultSet results = ps.executeQuery();
            List<giaoDich> list;
            giaoDich transaction = new giaoDich();
            File file;
            FileWriter fw;
            String nameFile = "", maKH = "", soTK = "";
            while (results.next()) {
                maKH = results.getString(7);
                soTK = results.getString(2);
                nameFile = maKH + "_" + soTK + "_" + month + "/" + year;
                list = new ArrayList<>();
                while (true) {
                    if (maKH.equals(results.getString(7)) && !soTK.equals(results.getString(2))
                            || !maKH.equals(results.getString(7))) {
                        results.previous();
                        maKH = results.getString(7);
                        soTK = results.getString(2);
                        break;
                    }
                    transaction.setId(results.getInt(1));
                    transaction.setSoTK(results.getString(2));
                    transaction.setLoaiTT(results.getInt(3));
                    transaction.setSoTien(results.getInt(4));
                    transaction.setNgayTao(sdf.format(results.getDate(5)));
                    transaction.setNoiThucHien(results.getString(6));

                    list.add(transaction);
                }
                file = new File(root, nameFile);
                fw = new FileWriter(file);
                for (giaoDich gDich : list) {
                    fw.write(gDich.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return false;
    }

}
