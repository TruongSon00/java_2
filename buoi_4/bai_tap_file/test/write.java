package buoi_4.bai_tap_file.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class write {
    public static void main(String[] args) {
        File fileParent = new File("/media/son/HDD download/document/java_2/buoi_4/bai_tap_file/test");
        File fileTest = new File(fileParent, "data.txt");
        FileWriter myWriter = null;

        try {
            myWriter = new FileWriter(fileTest);
            myWriter.write("Lan hai tao file cua Truong Son");
            System.out.println("Ghi file thanh cong");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                myWriter.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
