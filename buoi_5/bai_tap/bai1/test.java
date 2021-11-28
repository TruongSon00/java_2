package buoi_5.bai_tap.bai1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class test {

    static int count = 0;

    public static void copyDir(Path sourseDir, Path newDir) throws IOException {
        Files.walk(sourseDir).forEach(file -> {
            Path newFile = Paths.get(newDir.toString(), file.toString().substring(sourseDir.toString().length()));
            try {
                count++;
                Files.copy(file, newFile);
                System.out.println("\n" + count + " -> Thanh cong  "
                        + file.toString().substring(sourseDir.toString().length() - 16) + " --> "
                        + newFile.toString().substring(newDir.toString().length() - 5));
            } catch (IOException e) {
                System.out.println(count + " -> That bai (file da ton tai)");
            }
        });
    }

    public static void main(String[] args) throws IOException {
        File root = new File(System.getProperty("user.dir"));
        File dirNew = new File(root, "buoi_5/bai_tap/bai1/dirBK");

        // System.out.println(dirNew.delete());

        root = new File(root, "buoi_5/bai_tap/bai1/test_remove_file/subTest");

        root = new File(root.getParentFile(), "test_2");
        if (root.mkdirs())
            System.out.println("Tao thanh cong");
        try {
            System.out.println(new File(root, "test_1.bin").createNewFile());
            System.out.println(new File(root, "test_2.bin").createNewFile());
            System.out.println(new File(root, "test_3.bin").createNewFile());
            System.out.println(new File(root, "test_4.bin").createNewFile());
        } catch (IOException e) {

            e.printStackTrace();
        }

        File fileToRemove = new File(root.getParent());
        System.out.println(fileToRemove);
        System.out.println(root.getPath());
        // System.out.println(Paths.get(dirNew.getPath()));

        copyDir(fileToRemove.toPath(), dirNew.toPath());

        // Files.walk(fileToRemove.toPath()).forEach(sourse ->
        // System.out.println(sourse));
    }

}
