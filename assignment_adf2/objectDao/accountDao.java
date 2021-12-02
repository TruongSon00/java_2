package assignment_adf2.objectDao;

import java.util.List;

import assignment_adf2.object.account;

public interface accountDao {
    public void insert(account customer);

    public void napTien(account customer);

    public void rutTien(String maKH);

    public account tkTheoSoTK(String soTK);

    public List<account> tkTheoMaKH(String maKH);
}
