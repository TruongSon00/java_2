package buoi_5.bai_tap.bai1;

import java.io.File;

public class threadMain {
    public static void main(String[] args) {

        File root = new File(System.getProperty("user.dir"));
        File fileRoot = new File(root, "buoi_4");
        File newFile = new File(root, "buoi_5/bai_tap/bai1/dirBK");

        newFile.mkdirs();

        threadRunFile luongChayFile = new threadRunFile(fileRoot, newFile);
        threadCheck luongCheck = new threadCheck(newFile);

        luongChayFile.start();
        try {
            luongChayFile.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        luongCheck.start();
        String test = "testFile";
        for (int i = 0; i < 10; i++) {

            System.out.println(new File(fileRoot, "xxx/" + test + i).mkdirs());

            try {

                Thread.sleep(2000);
                luongChayFile.interrupt();
                luongChayFile.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n-------- End Main ----------");

    }
}
