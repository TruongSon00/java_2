package buoi_5.bai_tap.bai1;

import java.io.File;

public class threadCheck extends Thread {
    File fileCheck;

    public threadCheck(File fileCheck) {
        this.fileCheck = fileCheck;
    }

    @Override
    public void run() {
        int count = 0;
        while (count++ != 10) {
            System.out.println("--------- Dung luong file hien tai: " + fileCheck.length() + " bits --------");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
