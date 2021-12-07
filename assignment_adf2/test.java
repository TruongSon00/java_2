package assignment_adf2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assignment_adf2.object.giaoDich;
import assignment_adf2.util.const_util;

public class test {

    public static void main(String[] args) {
        File root = new File(System.getProperty("user.dir"), "assignment_adf2/xuatFile");

        File file = new File(root, "test.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            for (int i = 0; i < 10; i++)
                fw.write(
                        "GiaoDich  -->  id = 5  |  soTK = 000004  |  ngayTao = 20/08/2021  |  soTien = 1000000  |  loaiTT = rut  |  noiThucHien = HP");
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
