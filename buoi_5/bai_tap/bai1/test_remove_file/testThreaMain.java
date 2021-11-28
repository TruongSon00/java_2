package buoi_5.bai_tap.bai1.test_remove_file;

import java.io.File;

public class testThreaMain {
    public static void main(String[] args) {

        File root = new File(System.getProperty("user.dir"));
        File fileRoot = new File(root, "buoi_4");
        String test = "fileTest";
        for (int i = 0; i < 10; i++) {

            System.out.println(Thread.currentThread());
            try {
                System.out.println(new File(fileRoot, "xxx/" + test + i).mkdirs());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
