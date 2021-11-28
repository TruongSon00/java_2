package sanpham;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ghiFileDM {
    public void main2(String[] args) {
        System.out.println("start");
        String lopHoc = "tenlop, thanh vine";
        File file = new File("sanpham\\tailieu\\taiLieu.txt");
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(file);
            pw.write(lopHoc);
            System.out.println("Dang chay");
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("start");
        String lopHoc = "tenlop, thanh vine";
        File file = new File("sanpham/tailieu/taiLieu.txt");

        try (PrintWriter pw = new PrintWriter(file)) {
            pw.write(lopHoc);
            System.out.println("Dang chay");
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } finally {

        }
        System.out.println("end");
    }
}
