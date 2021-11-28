package database.buoi_7.bai_tap;

public class DMKhoa {
    private String maKhoa;
    private String tenKhoa;

    public DMKhoa(String maKhoa, String tenKhoa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
    }

    public DMKhoa() {
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    @Override
    public String toString() {
        return "\nkhoa  --->  ma khoa = " + maKhoa + "  |  Ten khoa = " + tenKhoa;
    }

}