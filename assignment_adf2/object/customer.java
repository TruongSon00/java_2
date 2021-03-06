package assignment_adf2.object;

public class customer {
    private int id;
    private String maKH;
    private String tenKH;
    private String cmt;
    private String soDT;
    private String email;
    private String ngaySinh;
    private int gioiTinh;
    private String address;
    private int loaiKH;

    public customer() {
    }

    public customer(String maKH, String tenKH, String cmt, String soDT, String email, String ngaySinh, int gioiTinh,
            String address, int loaiKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.cmt = cmt;
        this.soDT = soDT;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.address = address;
        this.loaiKH = loaiKH;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinhIn() {

        return (gioiTinh == 1 ? "Nam" : (gioiTinh == 0) ? "Nu" : "Khac");
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLoaiKHIn() {
        return loaiKH == 1 ? "KH Vip" : "KH thuong";
    }

    public int getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(int loaiKH) {
        this.loaiKH = loaiKH;
    }

    @Override
    public String toString() {
        return "\nCustomer -->  id = " + id
                + "  |  maKH = " + maKH
                + "  |  tenKH = " + tenKH
                + "  |  cmt = " + cmt
                + "  |  soDT = " + soDT
                + "  |  ngaySinh = " + ngaySinh
                // + " | address = " + address
                // + " | email = " + email
                // + " | gioiTinh = " + getGioiTinhIn()
                + "  |  loaiKH = " + getLoaiKHIn();

    }

}
