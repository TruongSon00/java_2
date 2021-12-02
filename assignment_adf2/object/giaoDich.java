package assignment_adf2.object;

public class giaoDich {
    private String soTK;
    private int loaiTT;
    private int soTien;
    private String ngayTao;
    private String noiThucHien;

    public giaoDich() {
    }

    public giaoDich(String soTK, int loaiTT, int soTien, String ngayTao, String noiThucHien) {
        this.soTK = soTK;
        this.loaiTT = loaiTT;
        this.soTien = soTien;
        this.ngayTao = ngayTao;
        this.noiThucHien = noiThucHien;
    }

    public String getSoTK() {
        return soTK;
    }

    public void setSoTK(String soTK) {
        this.soTK = soTK;
    }

    public String getLoaiTTIn() {
        return loaiTT == 0 ? "nap" : "rut";
    }

    public void setLoaiTT(int loaiTT) {
        this.loaiTT = loaiTT;
    }

    public int getLoaiTT() {
        return loaiTT;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNoiThucHien() {
        return noiThucHien;
    }

    public void setNoiThucHien(String noiThucHien) {
        this.noiThucHien = noiThucHien;
    }

    @Override
    public String toString() {
        return "\nGiaoDich  -->  soTK = " + soTK

                + "  |  ngayTao = " + ngayTao

                + "  |  soTien = " + soTien

                + "  |  loaiTT = " + getLoaiTTIn()

                + "  |  noiThucHien = " + noiThucHien;

    }

}
