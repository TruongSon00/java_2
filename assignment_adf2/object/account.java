package assignment_adf2.object;

public class account {
    private int id;
    private int khID;
    private String soTK;
    private int loaitk;
    private int trangThai;
    private String ngayTao;
    private int soTien;
    private int hanMuc;

    public account() {
    }

    public account(int khID, String soTK, int loaitk, int trangThai, String ngayTao, int soTien, int hanMuc) {
        this.khID = khID;
        this.soTK = soTK;
        this.loaitk = loaitk;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.soTien = soTien;
        this.hanMuc = hanMuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKhID() {
        return khID;
    }

    public void setKhID(int khID) {
        this.khID = khID;
    }

    public String getSoTK() {
        return soTK;
    }

    public void setSoTK(String soTK) {
        this.soTK = soTK;
    }

    public String getLoaitkIn() {
        return loaitk == 0 ? "Tra truoc" : "Tra sau";
    }

    public int getLoaitk() {
        return loaitk;
    }

    public void setLoaitk(int loaitk) {
        this.loaitk = loaitk;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public String getTrangThaiIn() {
        return trangThai == 0 ? "disable" : "active";
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public int getHanMuc() {
        return hanMuc;
    }

    public void setHanMuc(int hanMuc) {
        this.hanMuc = hanMuc;
    }

    @Override
    public String toString() {
        return " \n Account  --> |  id = " + id

                + "  |  sotk = " + soTK

                + "  |  khID = " + khID

                + "  |  soTien = " + soTien
                + "  |  loaitk=" + getLoaitkIn()

                + "  |  ngayTao = " + ngayTao

                + "  |  hanmuc = " + hanMuc

                + "  |  trangThai = " + getTrangThaiIn();
    }

}
