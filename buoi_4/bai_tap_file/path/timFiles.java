package buoi_4.bai_tap_file.path;

import java.io.File;

public class timFiles {

    public static void timFile(File files) {
        String nameFile;
        if (files.isDirectory()) {
            for (File file : files.listFiles()) {
                timFile(file);
            }
        } else {
            nameFile = files.getName();
            // System.out.println(nameFile.split(".")[0]);
            if (nameFile.replace('.', ',').split(",")[1].equals("java"))
                System.out.println("+ " + nameFile);

        }
    }

    public static void main(String[] args) {
        String proPath = System.getProperty("user.dir");
        File proFile = new File(proPath);
        timFile(proFile);

    }
}
