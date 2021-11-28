package sanpham;

import java.io.File;

import java.util.Scanner;

public class readFile {
    public static void main(String[] args) {
        File file = new File("tailieu\\taiLieu.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }

            System.out.println("end try");
        } catch (Exception e1) {

            e1.printStackTrace();
        } finally {
            if (sc != null)
                sc.close();
            System.out.println("vao finally");
        }

    }
}
