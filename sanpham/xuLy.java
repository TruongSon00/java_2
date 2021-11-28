package sanpham;

import java.io.FileNotFoundException;
import java.io.IOException;

public class xuLy {
    public static void main(String[] args) throws FileNotFoundException, RuntimeException, IOException, Exception {
        boolean check = false;

        try {
            validate("4");
            System.out.println("hop le");
            check = true;
        } catch (Exception e) {
            System.out.println("error + " + e);
        }
        System.out.println("end");

        if (check) {
            System.out.println("dung roi");
        }

    }

    public static void validate(String chuoi) throws FileNotFoundException, Exception, RuntimeException, IOException {

        if (chuoi == null || "".equals(chuoi)) {
            throw new RuntimeException("loi chcuoi");
        } else if (chuoi == "5") {
            throw new Exception("loi = 5");
        } else if (chuoi == "4") {
            throw new productException("loi = 4");
        } else {
            String[] mang = chuoi.split(",");
            // System.out.println(mang[1]);
            if (mang.length == 4) {

            } else {
                throw new Exception("ngu");
            }
        }
    }
}
