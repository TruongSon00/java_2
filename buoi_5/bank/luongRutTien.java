package buoi_5.bank;

public class luongRutTien extends Thread {
    private String name;
    private account taiKhoan;

    public luongRutTien(String name, account taiKhoan) {
        this.name = name;
        this.taiKhoan = taiKhoan;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            taiKhoan.rutTien(name, 2000);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }

}
