package database.buoi_7.bai_tap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class test {
    public static void main(String[] args) {

        String[] arr = "'A01', N'Nguyễn Thị', N'Hải', N'Nữ', '23/02/1990', N'Hà Nội', 'TH', 130000".split(",");
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(arr[4].replaceAll("'", ""));
            System.out.println(date);
            arr[4] = "'" + new java.sql.Date(date.getTime()).toString() + "'";
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        String text = Arrays.toString(arr);

        text = text.substring(0, text.length() - 1);
        text = text.substring(1, text.length());
        System.out.println(text);

        System.out.println("---------------------------");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println(new java.sql.Date(sdf.parse("20/10/2020").getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
