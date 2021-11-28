package database.buoi_7.bai_tap;

public class DDMonhoc {
    private String MaMH;
    private String TenMH;
    private int SoTiet;

    public DDMonhoc() {
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String maMH) {
        MaMH = maMH;
    }

    public String getTenMH() {
        return TenMH;
    }

    public void setTenMH(String tenMH) {
        TenMH = tenMH;
    }

    public int getSoTiet() {
        return SoTiet;
    }

    public void setSoTiet(int soTiet) {
        SoTiet = soTiet;
    }

    public DDMonhoc(String maMH, String tenMH, int soTiet) {
        MaMH = maMH;
        TenMH = tenMH;
        SoTiet = soTiet;
    }

    @Override
    public String toString() {
        return "\nMon hoc ---> ma mon = " + MaMH + "  | SoTiet = " + SoTiet + "  | TenMH = " + TenMH;
    }

}
