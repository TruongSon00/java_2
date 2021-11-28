package database.buoi_7.bai_tap;

import java.io.File;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class quanLyDiemSV {
    Connection connect = connect_database.getConnect();
    File root = new File(System.getProperty("user.dir"), "database/buoi_7/bai_tap/data");
    DMSinhVienDao sinh_vien = new DMSinhVienDao(connect);
    KetQuaDao ket_qua = new KetQuaDao(connect);
    DMMonhocDao mon_hoc = new DMMonhocDao(connect);
    DDKhoaDao khoa = new DDKhoaDao(connect);

    // ---------- 1. khoa ------------
    public void khoa(Scanner sc) {
        int choose;

        String maKhoa, tenKhoa;

        while (true) {
            System.out.println("\n-------------  Khoa  -------------\n");
            System.out.print("1. Insert khoa");
            System.out.println("\t2. Update khoa");
            System.out.print("3. Delete khoa");
            System.out.println("\t4. Select khoa");
            System.out.print("5. Insert TXT");
            System.out.println("\t6. Thoat");
            System.out.print("\nNhap lua chon: ");
            choose = checkInt(sc);
            switch (choose) {
                case 1:
                    System.out.println("Nhap khoa can them");
                    System.out.print("Nhap ma khoa: ");
                    maKhoa = sc.nextLine();
                    System.out.print("Nhap ten khoa: ");
                    tenKhoa = sc.nextLine();
                    khoa.insert(maKhoa, tenKhoa);
                    break;
                case 2:
                    System.out.print("Nhap ma khoa update: ");
                    maKhoa = sc.nextLine();
                    System.out.print("Nhap ten khoa: ");
                    tenKhoa = sc.nextLine();
                    khoa.update(maKhoa, tenKhoa);
                    break;
                case 3:
                    System.out.print("Nhap ma khoa: ");
                    maKhoa = sc.nextLine();

                    khoa.delete(maKhoa);
                    break;
                case 4:
                    System.out.println(khoa.select().toString());
                    break;
                case 5:
                    try {
                        khoa.insertTXT(root);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:

                    break;

                default:
                    System.out.println("Lua chon khong ton tai");
            }
            if (choose == 6)
                break;
        }
    }

    // ---------- 2. Sinh vien ------------
    public void SinhVien(Scanner sc) {
        int choose;

        String maSV, TenSV, maKhoa, sql;

        while (true) {
            System.out.println("\n-------------  Khoa  -------------\n");
            System.out.print("1. Insert Sinh vien");
            System.out.println("\t2. Update Sinh vien");
            System.out.print("3. Delete Sinh vien");
            System.out.println("\t4. Select Sinh vien");
            System.out.print("5. Insert TXT");
            System.out.println("\t6. Thoat");
            System.out.print("\nNhap lua chon: ");
            choose = checkInt(sc);
            switch (choose) {
                case 1:
                    System.out.println("Nhap sinh vien can them");
                    System.out.print("Nhap ma Sinh vien: ");
                    maSV = sc.nextLine();
                    System.out.print("Nhap ten Sinh vien: ");
                    TenSV = sc.nextLine();
                    System.out.print("Nhap ma Khoa: ");
                    maKhoa = sc.nextLine();
                    sinh_vien.insert(maSV, "Vu Truong", TenSV, "nam", "30/08/2000", "Hai Phong", maKhoa, 1500000f);
                    break;
                case 2:
                    System.out.println("Nhap sinh vien can update");
                    System.out.print("Nhap ma Sinh vien: ");
                    maSV = sc.nextLine();
                    System.out.print("Nhap ten Sinh vien: ");
                    TenSV = sc.nextLine();
                    System.out.print("Nhap ma Khoa: ");
                    maKhoa = sc.nextLine();
                    sinh_vien.update(maSV, "Vu Truong", TenSV, "nam", "30/08/2000", "Hai Phong", maKhoa, 1500000f);
                    break;
                case 3:
                    System.out.print("Nhap ma sinh vien: ");
                    maSV = sc.nextLine();

                    sinh_vien.delete(maSV);
                    break;
                case 4:
                    sql = "select * from DMSV";
                    System.out.println(sinh_vien.select(sql).toString());
                    break;
                case 5:
                    try {
                        sinh_vien.insertTXT(root);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:

                    break;

                default:
                    System.out.println("Lua chon khong ton tai");
            }
            if (choose == 6)
                break;
        }
    }

    // ---------- 3. Mon hoc ------------
    public void monHoc(Scanner sc) {
        int choose;
        String maMH, tenMH, sql;

        while (true) {
            System.out.println("\n-------------  mon_hoc  -------------\n");
            System.out.print("1. Insert mon hoc");
            System.out.println("\t2. Update mon hoc");
            System.out.print("3. Delete mon hoc");
            System.out.println("\t4. Select mon hoc");
            System.out.print("5. Insert TXT");
            System.out.println("\t6. Thoat");
            System.out.print("\nNhap lua chon: ");
            choose = checkInt(sc);
            switch (choose) {
                case 1:
                    System.out.println("Nhap mon hoc can them");
                    System.out.print("Nhap ma mon hoc: ");
                    maMH = sc.nextLine();
                    System.out.print("Nhap ten mon hoc: ");
                    tenMH = sc.nextLine();

                    mon_hoc.insert(maMH, tenMH, 5);
                    break;
                case 2:
                    System.out.print("Nhap ma mon hoc update: ");
                    maMH = sc.nextLine();
                    System.out.print("Nhap ten mon hoc: ");
                    tenMH = sc.nextLine();
                    mon_hoc.update(maMH, tenMH, 9);
                    break;
                case 3:
                    System.out.print("Nhap ma mon hoc: ");
                    maMH = sc.nextLine();

                    mon_hoc.delete(maMH);
                    break;
                case 4:
                    sql = "select * from DMMH";
                    System.out.println(mon_hoc.select(sql).toString());
                    break;
                case 5:
                    try {
                        mon_hoc.insertTXT(root);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:

                    break;

                default:
                    System.out.println("Lua chon khong ton tai");
            }
            if (choose == 6)
                break;
        }
    }

    // ---------- 4. Ket qua ------------
    public void KetQua(Scanner sc) {
        int choose;
        String maSV, maMH, sql;
        float diem;

        while (true) {
            System.out.println("\n-------------  ket qua  -------------\n");
            System.out.print("1. Insert ket qua");
            System.out.println("\t2. Update ket qua");
            System.out.print("3. Delete ket qua");
            System.out.println("\t4. Select ket qua");
            System.out.print("5. Insert TXT");
            System.out.println("\t6. Thoat");
            System.out.print("\nNhap lua chon: ");
            choose = checkInt(sc);
            switch (choose) {
                case 1:
                    System.out.println("Nhap ket qua can them");
                    System.out.print("Nhap ma sinh vien: ");
                    maSV = sc.nextLine();
                    System.out.print("Nhap ma mon hoc: ");
                    maMH = sc.nextLine();
                    System.out.print("Nhap diem: ");
                    try {
                        diem = sc.nextFloat();
                        sc.nextLine();
                    } catch (Exception e) {
                        sc.nextLine();
                        diem = 0;
                        System.out.println("Diem khong hop le");
                    }

                    ket_qua.insert(maSV, maMH, 3, diem);
                    break;
                case 2:
                    System.out.println("Nhap ket qua can update");
                    System.out.print("Nhap ma sinh vien: ");
                    maSV = sc.nextLine();
                    System.out.print("Nhap ma mon hoc: ");
                    maMH = sc.nextLine();
                    System.out.print("Nhap diem: ");
                    try {
                        diem = sc.nextFloat();
                        sc.nextLine();
                    } catch (Exception e) {
                        sc.nextLine();
                        diem = 0;
                        System.out.println("Diem khong hop le");
                    }

                    ket_qua.update(maSV, maMH, 3, diem);
                    break;
                case 3:
                    System.out.print("Nhap ma sinh vien: ");
                    maSV = sc.nextLine();
                    System.out.print("Nhap ma mon hoc: ");
                    maMH = sc.nextLine();

                    ket_qua.delete(maSV, maMH);
                    break;
                case 4:
                    sql = "select * from KetQua";
                    System.out.println(ket_qua.select(sql).toString());
                    break;
                case 5:
                    try {
                        ket_qua.insertTXT(root);
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 6:

                    break;

                default:
                    System.out.println("Lua chon khong ton tai");
            }
            if (choose == 6)
                break;
        }
    }

    private static int checkInt(Scanner sc) {
        int choose;
        while (true) {
            try {
                choose = sc.nextInt();
                sc.nextLine();
                return choose;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Vui long nhap so");
            }
        }
    }

    // =========== main ==============
    public static void main(String[] args) {
        quanLyDiemSV quanLy = new quanLyDiemSV();
        int choose;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n================= MAIN ===============\n");
            System.out.print("1. Khoa");
            System.out.println("\t\t2. Sinh vien");
            System.out.print("3. Mon hoc");
            System.out.println("\t4. Ket qua");
            System.out.println("5. Thoat");
            System.out.print("\nNhap lua chon: ");
            choose = checkInt(sc);
            switch (choose) {
                case 1:
                    quanLy.khoa(sc);
                    break;
                case 2:
                    quanLy.SinhVien(sc);
                    break;
                case 3:
                    quanLy.monHoc(sc);
                    break;
                case 4:
                    quanLy.KetQua(sc);
                    break;
                case 5:
                    break;

                default:
                    System.out.println("Lua chon khong ton tai");
            }
            if (choose == 5)
                break;
        }
        sc.close();
    }
}
