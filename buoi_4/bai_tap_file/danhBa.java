package buoi_4.bai_tap_file;

import java.io.Serializable;
import java.util.Scanner;

public class danhBa implements Serializable {
    private String sdt;
    private String name;

    public danhBa(String sdt, String name) {
        setSdt(sdt);
        this.sdt = getSdt();
        this.name = name;
    }

    public danhBa() {
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        try {
            Long.parseLong(sdt);
            this.sdt = sdt;
            if (sdt.length() != 10)
                System.out.println("so dien thoai phai 10 so");
        } catch (Exception e) {
            System.out.println("Danh ba khong duoc chua ky tu");
            this.sdt = "0587234423";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ---------- mo rong -----------
    public void addSDT(Scanner sc) {

        System.out.println("Nhap so dien thoai");
        sdt = sc.nextLine();
        setSdt(sdt);

        System.out.print("Nhap ten thue bao: ");
        name = sc.nextLine();

    }

    @Override
    public String toString() {
        return "\n SDT: " + sdt + "\t|   Name: " + name;
    }

}
