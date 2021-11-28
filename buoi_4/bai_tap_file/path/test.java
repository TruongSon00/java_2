package buoi_4.bai_tap_file.path;

import java.io.File;
import java.io.IOException;

public class test {
    // show tep
    public static void checkFile(File files, String ram) {

        if (files.isDirectory()) {
            System.out.println(ram + "- " + files.getName());
            for (File file : files.listFiles()) {
                checkFile(file, ram + "\t");
            }
        } else {
            System.out.println(ram + "+ " + files.getName());
        }
    }

    // show file
    public static void showFile(File files) {

        if (files.isDirectory()) {
            for (File file : files.listFiles()) {
                showFile(file);
            }
        } else {
            System.out.println("- " + files.getName());
        }
    }

    // tim theo duoi
    public static void timFile(File files, String duoi) {
        String nameFile;
        if (files.isDirectory()) {
            for (File file : files.listFiles()) {
                timFile(file, duoi);
            }
        } else {
            nameFile = files.getName();
            // System.out.println(nameFile.split(".")[0]);
            if (nameFile.replace('.', ',').split(",")[1].equals(duoi))
                System.out.println("+ " + nameFile);

        }
    }

    // xoa theo duoi
    public static void xoaFile(File files, String duoi) {
        String nameFile;
        if (files.isDirectory()) {
            for (File file : files.listFiles()) {
                xoaFile(file, duoi);
            }
        } else {
            nameFile = files.getName();
            // System.out.println(nameFile.split(".")[0]);
            if (nameFile.replace('.', ',').split(",")[1].equals(duoi)) {
                if (files.delete())
                    System.out.println("file: " + nameFile + " da duoc xoa");

            }

        }
    }

    // reName theo duoi
    public static void reNameFile(File files, String duoi) {
        String nameFile;
        File newFile;
        if (files.isDirectory()) {
            for (File file : files.listFiles()) {
                reNameFile(file, duoi);
            }
        } else {
            nameFile = files.getName();
            // System.out.println(nameFile.split(".")[0]);
            if (nameFile.replace('.', ',').split(",")[1].equals(duoi)) {
                nameFile = "new" + nameFile;
                newFile = new File(files.getParent(), nameFile);
                if (files.renameTo(newFile)) {
                    System.out.println("Rename thanh cong to name: " + newFile.getName());
                    System.out.println("file cuc: " + files.getPath());

                }

            }

        }
    }

    public static void main(String[] args) {
        String proPath = System.getProperty("user.dir");
        System.out.println(proPath);
        File proFile = new File(proPath);
        // test.checkFile(proFile, "");
        // ---------- hien thi file ---------
        // showFile(proFile);

        // ----------- them, xoa file --------
        File filParent = new File(proFile, "buoi_4/bai_tap_file");

        System.out.println(new File(filParent, "newDirectory/hay/moi").mkdirs());
        filParent = new File(filParent, "newDirectory/hay");
        try {
            System.out.println(new File(filParent, "test_1.jpg").createNewFile());
            System.out.println(new File(filParent, "test_2.jpg").createNewFile());
            System.out.println(new File(filParent, "test_3.jpg").createNewFile());
            System.out.println(new File(filParent, "test_4.jpg").createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        File deleteFile = new File(filParent, "moi");
        if (deleteFile.exists()) {
            System.out.println(deleteFile.delete() ? (" da xoa thanh cong file: " + deleteFile.getName()) : "that bai");

        }
        // -------- tim file co duoi ---------
        // timFile(proFile, "bin");
        // -------- xoa file co duoi ---------
        // xoaFile(proFile, "bin");
        // xoaFile(proFile, "jpg");
        // // ----------- doi ten file ---------
        reNameFile(proFile, "pin");
        System.out.println();

    }
}
