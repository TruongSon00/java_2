package assignment_adf2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class test {

    public static void main(String[] args) {
        File root = new File(System.getProperty("user.dir"), "assignment_adf2/xuatFile/test.txt");
        try (FileWriter fw = new FileWriter(root)) {

            for (int i = 0; i < 10; i++) {
                fw.write("hả nói gì đi\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
