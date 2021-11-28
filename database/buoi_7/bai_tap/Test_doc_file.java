package database.buoi_7.bai_tap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test_doc_file {
    public static void main(String[] args) {
        File root = new File(System.getProperty("user.dir"), "database/buoi_7/bai_tap");

        File file = new File(root, "khoa.txt");
        Scanner scanner = null;
        try {
            StringBuilder text = new StringBuilder("insert: ");
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                text.append(",(" + scanner.nextLine() + ")");
                System.out.println(text);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }

    }
}
