package buoi_4.bai_tap_file.test;

import java.io.File;
import java.io.IOException;

public class test {
    public static void main(String[] args) {
        File fileParent = new File("/media/son/HDD download/document/java_2/buoi_4/bai_tap_file/test");
        File fileTest = new File(fileParent, "data.txt");
        try {
            if (fileTest.createNewFile())
                System.out.println("File tao thanh cong: " + fileTest.getName());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("viet duoc khong? " + fileTest.canWrite());
        System.out.println("File co chua? " + fileTest.exists());
        System.out.println("Ten file? " + (fileTest.getName()));
        System.out.println("Ten duong dan? " + fileTest.getPath());
        System.out.println("Kich thuoc? " + fileTest.length());
        System.out.println("File trong parent: " + fileTest.listFiles());
        // -------- file parent ----------
        System.out.println("File trong parent: " + fileParent.listFiles().toString());
    }
}
