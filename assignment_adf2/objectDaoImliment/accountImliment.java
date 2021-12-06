package assignment_adf2.objectDaoImliment;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import assignment_adf2.object.account;
import assignment_adf2.object.giaoDich;
import assignment_adf2.objectDao.accountDao;

public class accountImliment extends account implements accountDao {
    private Connection connect;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public accountImliment(Connection connect) {
        this.connect = connect;
    }

    // -------- check acc ------------------
    public int checkAcc(String maKH) {
        String sql = "exec dbo.pr_checkAcc_account ?,?";
        CallableStatement cs = null;
        try {
            cs = connect.prepareCall(sql);
            cs.setString(1, maKH);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.execute();
            int check = cs.getInt(2);
            return check;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -2;
    }

    // ----------- insert ---------------
    @Override
    public void insert(String maKH) {
        int loaitk = 0;

        int check = checkAcc(maKH);
        if (check == 1)
            loaitk = 0;
        else if (check == 0)
            loaitk = 1;
        else if (check == -1)
            System.out.println("Ban chi duoc tao toi da 2 tai khoan");
        if (check != -1) {
            String sql = "exec dbo.pr_insert_account ?,?";
            CallableStatement cs = null;
            try {
                cs = connect.prepareCall(sql);
                cs.setString(1, maKH);
                cs.setInt(2, loaitk);
                if (cs.executeUpdate() == 1)
                    System.out.println("ADD thanh cong acc");
                else
                    System.out.println("ADD that bai");

            } catch (SQLException e) {
                System.out.println("ERROR: Loi them acc");
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
    // ------------ nap tien -------------

    @Override
    public void napTien(String soTK, int soTienNap) {
        String sql = "exec dbo.pr_NapTien_account ?,?,?,?";
        CallableStatement cs = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String ngayTao = sdf.format(new Date());
        try {
            cs = connect.prepareCall(sql);
            cs.setString(1, soTK);
            cs.setInt(2, soTienNap);
            cs.registerOutParameter(3, Types.INTEGER);
            cs.registerOutParameter(4, Types.INTEGER);
            cs.registerOutParameter(5, Types.NVARCHAR);
            cs.execute();
            if (cs.getInt(3) == 1) {
                System.out.println("nap tien thanh cong");
                giaoDich gDich = new giaoDich(soTK, 1, soTienNap, ngayTao, cs.getString(5));
                insertGiaoDich(gDich);
                System.out.println("So tien hien tai: " + cs.getInt(4));
            } else if (cs.getInt(3) == -1)
                System.out.println("Khong the nap tien cho the visa");
            else
                System.out.println("So tai khoan khong ton tai");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // ------------ rut tien -------------
    @Override
    public void rutTien(String soTK, int soTienRut) {
        String sql = "exec dbo.pr_RutTien_account ?,?,?,?,?,? ";
        CallableStatement cs = null;
        String ngayTao = sdf.format(new Date());
        try {
            cs = connect.prepareCall(sql);
            cs.setString(1, soTK);
            cs.setInt(2, soTienRut);
            cs.registerOutParameter(3, Types.INTEGER);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.registerOutParameter(5, Types.INTEGER);
            cs.registerOutParameter(6, Types.NVARCHAR);

            if (cs.executeUpdate() == 1) {
                giaoDich gDich = new giaoDich(soTK, 1, soTienRut, ngayTao, cs.getString(6));
                insertGiaoDich(gDich);
            }
            System.out.println(cs.getString(4));

        } catch (SQLException e) {
            System.out.println("ERROR: loi rut tien");
            e.printStackTrace();
        } finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    // ----------- insert giao dich -------------
    public void insertGiaoDich(giaoDich gDich) {
        String sql = "insert into giaoDich(sotk, loaitt, soTien, ngayTao, noiThucHien) values (?,?,?,convert(date,?,103),?)";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setString(1, gDich.getSoTK());
            ps.setInt(2, gDich.getLoaiTT());
            ps.setInt(3, gDich.getSoTien());
            ps.setString(4, gDich.getNgayTao());
            ps.setString(5, gDich.getNoiThucHien());
            if (ps.executeUpdate() == 1)
                System.out.println("Ghi giao dich thanh cong");
            else
                System.out.println("Ghi giao dich that bai");
        } catch (SQLException e) {
            System.out.println("Loi ghi giao dich");
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<account> tkTheoMaKH(String maKH) {
        String sql = "select * from account where kh_id = any (select id from customer where maKH = " + maKH + ")";
        Statement state = null;
        List<account> list = new ArrayList<>();
        account acc = null;
        try {
            state = connect.createStatement();
            ResultSet lSet = state.executeQuery(sql);
            while (lSet.next()) {
                acc = new account(lSet.getInt(2), lSet.getString(3), lSet.getInt(4), lSet.getInt(5),
                        sdf.format(lSet.getDate(6)), lSet.getInt(7), lSet.getInt(8));
                acc.setId(lSet.getInt(1));
                list.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public account tkTheoSoTK(String soTK) {
        String sql = "select * from account where sotk = " + soTK + "";
        Statement state = null;
        account acc = null;
        try {
            state = connect.createStatement();
            ResultSet rSet = state.executeQuery(sql);
            if (rSet.next()) {
                acc = new account(rSet.getInt(2), rSet.getString(3), rSet.getInt(4), rSet.getInt(5),
                        sdf.format(rSet.getDate(6)), rSet.getInt(7), rSet.getInt(8));
                acc.setId(rSet.getInt(1));
            }
        } catch (SQLException e) {
        } finally {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return acc;
    }

}
