package assignment_adf2.objectDao;

import java.util.List;

import assignment_adf2.object.account;

public interface accountDao {
    public void insert(String maKH, String soTK);

    public void napTien(String soTK, int soTienNap);

    public void rutTien(String soTK, int soTienRut);

    public account tkTheoSoTK(String soTK);

    public List<account> tkTheoMaKH(String maKH);
}
