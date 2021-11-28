package buoi_4.bai_tap_file.path;

public class split {
    public static void main(String[] args) {
        String text = "1son.truong";
        ;

        for (String string : text.split(".")) {
            System.out.println(string);
        }
    }
}
