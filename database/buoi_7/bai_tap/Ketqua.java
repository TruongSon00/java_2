package database.buoi_7.bai_tap;

public class Ketqua {
    private String maSV;
    private String MaMH;
    private int LanThi;
    private float Diem;

    public Ketqua(String maSV, String maMH, int lanThi, float diem) {
        this.maSV = maSV;
        MaMH = maMH;
        LanThi = lanThi;
        Diem = diem;
    }

    public Ketqua() {
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String maMH) {
        MaMH = maMH;
    }

    public int getLanThi() {
        return LanThi;
    }

    public void setLanThi(int lanThi) {
        LanThi = lanThi;
    }

    public float getDiem() {
        return Diem;
    }

    public void setDiem(float diem) {
        Diem = diem;
    }

    @Override
    public String toString() {
        return "\nDiem SV --->  maSV = " + maSV

                + "  |  MaMH = " + MaMH

                + "  |  Diem = " + Diem

                + "  |  LanThi = " + LanThi;

    }

}
