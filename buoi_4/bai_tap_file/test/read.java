package buoi_4.bai_tap_file.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class read {
    public static void main(String[] args) {
        File fileParent = new File("/media/son/HDD download/document/java_2/buoi_4/bai_tap_file/test");
        File fileTest = new File(fileParent, "data.txt");
        try {
            Scanner readFile = new Scanner(fileTest);
            while (readFile.hasNextLine()) {
                String data = readFile.nextLine();
                System.out.println(data);
            }
            readFile.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
