package buoi_4.bai_tap_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static File fileDB = new File("danh_ba.txt");

    // ---------- read file ------------
    public List<danhBa> readFile() {
        List<danhBa> lDanhBas = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileDB));) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                // lDanhBas = (ArrayList) obj;
            }

            else if (obj instanceof danhBa)
                lDanhBas.add((danhBa) obj);

        } catch (Exception e) {
            System.out.println("Loi file!!!!!!!");
        }
        return lDanhBas;
    }

    // ------ 1. Them danh ba -----------
    public void addDB(Scanner sc) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileDB))) {
            danhBa thueBao = new danhBa();
            thueBao.addSDT(sc);
            oos.writeObject(thueBao);
        } catch (Exception e) {
            System.out.println("\n-------- Loi them file!!!!!!!");
        }
    }

    // ------ 2. hien thi danh ba -----------2

    public void showFile() {
        List<danhBa> lDanhBas = new ArrayList<>();
        if (readFile() != null)
            lDanhBas.addAll(readFile());
        if (lDanhBas != null)
            for (danhBa danhBa : lDanhBas)
                System.out.println(danhBa.toString());
    }

    // ------ 3. luu danh ba vao arraylist -----------
    public void saveDB() {

    }

    // ------ 4. tim danh ba theo so dien thoai -----------
    // ------ 5. xoa danh ba -----------
    public static void main(String[] args) {
        Main DB = new Main();
        List<danhBa> danhBas = new ArrayList<>();
        List<danhBa> takeFromFile = new ArrayList<>();
        danhBas.add(new danhBa("0587234423", "Truong Son"));
        danhBas.add(new danhBa("0587234424", "Long Vu"));
        danhBas.add(new danhBa("0587234425", "Huu Cuong"));
        danhBas.add(new danhBa("0587234426", "Thanh Long"));
        danhBas.add(new danhBa("0587234427", "Thanh Danh"));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileDB))) {

            oos.writeObject(danhBas);
        } catch (Exception e) {
            System.out.println("\n-------- Loi them file!!!!!!!");
        }
        // ----------- main -----------------
        Scanner sc = new Scanner(System.in);

        int choose = 0;
        while (true) {
            System.out.print("1. Them 1 danh ba");
            System.out.println("\t\t2. Hien thi file");
            System.out.print("3. Luu vao mang List");
            System.out.println("\t\t4. Tim theo so dien thoai");
            System.out.print("5. Xoa 1 danh ba");
            System.out.println("\t\t6. Thoat");
            System.out.print("Nhap lua chon: ");
            try {
                choose = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("khong phai so");
                sc.nextLine();
            }

            switch (choose) {
            case 1:
                DB.addDB(sc);
                break;
            case 2:
                DB.showFile();
                break;
            case 3:
                takeFromFile = DB.readFile();
                break;
            case 4:
                for (danhBa danhBa : takeFromFile) {
                    System.out.println(danhBa.toString());
                }
                break;
            case 5:

                break;
            case 6:

                break;

            default:
                break;
            }
            if (choose == 6)
                break;
        }
        sc.close();
        System.out.println("\n\t----------- END -----------");

    }
}
