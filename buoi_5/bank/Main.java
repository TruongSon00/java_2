package buoi_5.bank;

public class Main {
    public static void main(String[] args) {
        account taiKhoan = new account(10000);

        luongRutTien nguoi1 = new luongRutTien("Truong Son", taiKhoan);
        luongRutTien nguoi2 = new luongRutTien("Long Vu\t", taiKhoan);
        luongRutTien nguoi3 = new luongRutTien("Huu Cuong", taiKhoan);
        nguoi1.start();
        nguoi2.start();
        nguoi3.start();
    }
}
