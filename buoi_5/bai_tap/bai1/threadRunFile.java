package buoi_5.bai_tap.bai1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class threadRunFile extends Thread {

    File fileRoot;
    File newFile;

    public threadRunFile(File fileRoot, File newFile) {
        this.fileRoot = fileRoot;
        this.newFile = newFile;
    }

    // --------- show file ----------
    public static void showFile(File files, String ram) {

        if (files.isDirectory()) {
            System.out.println(ram + "- " + files.getName());
            for (File file : files.listFiles()) {
                showFile(file, ram + "\t");
            }
        } else {
            System.out.println(ram + "+ " + files.getName());
        }
    }

    // --- copy file --------
    static int count = 0;

    public static void copyDir(Path sourseDir, Path newDir) throws IOException {
        String root = sourseDir.getParent().getParent().toString();
        String newPath = sourseDir.getParent().getParent().toString();
        Files.walk(sourseDir).forEach(file -> {
            Path newFile = Paths.get(newDir.toString(), file.toString().substring(sourseDir.toString().length()));
            try {
                count++;
                Files.copy(file, newFile);
                System.out.println("\n" + count + " -> Thanh cong  " + file.toString().substring(root.length())
                        + " --> " + newFile.toString().substring(newPath.length()));
            } catch (IOException e) {
                System.out.println(count + " -> That bai (file da ton tai)");
            }
        });
    }

    // ---------- thread --------------
    @Override
    public void run() {

        int length = fileRoot.listFiles().length;

        for (int i = 0; i < length; i++) {
            System.out.println(length);

            showFile(fileRoot.listFiles()[i], "");
            try {
                copyDir(fileRoot.listFiles()[i].toPath(),
                        Paths.get(newFile.toString(), fileRoot.listFiles()[i].getName()));
                Thread.sleep(1000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
