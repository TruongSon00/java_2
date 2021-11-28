package database.buoi_7.bai_tap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DMSinhVien {
    private String MaSV;
    private String HoSV;
    private String TenSV;
    private String gender;
    private String ngaySinh;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String noiSinh;
    private String MaKhoa;
    private float HocBong;

    public DMSinhVien() {
    }

    public DMSinhVien(String maSV, String hoSV, String tenSV, String gender, String ngaySinh, String noiSinh,
            String maKhoa, float hocBong) {
        MaSV = maSV;
        HoSV = hoSV;
        TenSV = tenSV;
        this.gender = gender;
        setNgaySinh(ngaySinh);
        this.noiSinh = noiSinh;
        MaKhoa = maKhoa;
        HocBong = hocBong;
    }

    public void setNgaySinh(String ngaySinh) {
        try {
            this.ngaySinh = sdf.format(sdf.parse(ngaySinh));
        } catch (ParseException e) {
            this.ngaySinh = sdf.format(new Date());
            e.printStackTrace();
        }
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String maSV) {
        MaSV = maSV;
    }

    public String getHoSV() {
        return HoSV;
    }

    public void setHoSV(String hoSV) {
        HoSV = hoSV;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String tenSV) {
        TenSV = tenSV;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        MaKhoa = maKhoa;
    }

    public float getHocBong() {
        return HocBong;
    }

    public void setHocBong(float hocBong) {
        HocBong = hocBong;
    }

    @Override
    public String toString() {
        return "\nSinh vien --->  MaSV = " + MaSV

                + "  |  TenSV = " + HoSV + " " + TenSV

                + "  |  GT = " + gender

                + "  |  NS = " + ngaySinh

                + "  |  MaKhoa = " + MaKhoa

                + "  |  HB = " + HocBong

                + "  |  add = " + noiSinh;
    }

    // -------- set | get ------ - -

}
