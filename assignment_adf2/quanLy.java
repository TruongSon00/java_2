package assignment_adf2;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import assignment_adf2.connect.db_connect;
import assignment_adf2.object.account;
import assignment_adf2.object.customer;
import assignment_adf2.objectDao.accountDao;
import assignment_adf2.objectDao.customerDao;
import assignment_adf2.objectDao.transactionDao;
import assignment_adf2.objectDaoImliment.accountImliment;
import assignment_adf2.objectDaoImliment.customerImlement;
import assignment_adf2.objectDaoImliment.transactionIlement;

public class quanLy {
    Connection connect = db_connect.getConnect();
    accountDao accs = new accountImliment(connect);
    customerDao cus = new customerImlement(connect);
    transactionDao gDich = new transactionIlement(connect);

    // -------- check int ---------
    private int checkInt(Scanner sc) {
        int num;
        while (true) {
            try {
                num = sc.nextInt();
                sc.nextLine();
                return num;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("So khong duoc chua ky tu");
            }
        }
    }

    // ----------- 1. customer -----------
    public void customer(Scanner sc) {
        int choose;
        while (true) {
            System.out.println("-------- Customer --------");
            System.out.print("1. Insert");
            System.out.println("\t\t2. Update");
            System.out.print("3. Delete");
            System.out.println("\t\t4. Show");
            System.out.println("5. Thoat");
            System.out.print("\nNhap lua chon: ");
            choose = checkInt(sc);

            switch (choose) {
                case 1:
                    cus.insert(cus.nhapTT(sc));
                    break;
                case 2:
                    cus.update(cus.nhapTT(sc));
                    break;
                case 3:
                    System.out.print("Nhap ma khach hang can xoa: ");
                    cus.delete(sc.nextLine());
                    break;
                case 4:
                    List<customer> listCus = cus.show();
                    if (listCus != null)
                        for (customer customer : listCus) {
                            System.out.println(customer.toString());
                        }
                    else
                        System.out.println("chua co khach hang de hien thi");
                    break;

                default:
                    break;

            }
            if (choose == 5)
                break;
        }
    }

    // ----------- 2. account -----------
    public void account(Scanner sc) {
        int choose;
        while (true) {
            System.out.println("-------- Account --------");
            System.out.print("1. Create acc");
            System.out.println("\t\t2. Nap tien");
            System.out.print("3. Rut tien");
            System.out.println("\t\t4. Acc tu soTT");
            System.out.print("5. Accs to maKH");
            System.out.println("\t\t6. show acc");
            System.out.print("7. Thoat");
            System.out.print("\nNhap lua chon: ");
            choose = checkInt(sc);
            String soTK;
            int soTienNap, soTienRut;
            List<account> lAccounts;
            switch (choose) {
                case 1:
                    System.out.print("Nhap ma khach hang: ");
                    accs.insert(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap so tai khoan: ");
                    soTK = sc.nextLine();

                    System.out.print("Nhap so tien nap: ");
                    soTienNap = checkInt(sc);
                    accs.napTien(soTK, soTienNap);
                    break;
                case 3:
                    System.out.print("Nhap so tai khoan: ");
                    soTK = sc.nextLine();

                    System.out.print("Nhap so tien rut: ");
                    soTienRut = checkInt(sc);
                    accs.rutTien(soTK, soTienRut);
                    break;
                case 4:
                    System.out.print("Nhap so tai khoan: ");
                    account tk = accs.tkTheoSoTK(sc.nextLine());
                    if (tk != null)
                        System.out.println(tk.toString());
                    else
                        System.out.println("So tai khoan khong ton tai");
                    break;
                case 5:
                    System.out.print("Nhap ma khach hang: ");

                    lAccounts = accs.tkTheoMaKH(sc.nextLine());
                    if (lAccounts != null)
                        for (account account : lAccounts) {
                            System.out.println(account.toString());
                        }
                    else
                        System.out.println("ma khach hang khong dung");
                    break;
                case 6:
                    lAccounts = accs.show();
                    if (lAccounts != null)
                        for (account account : lAccounts) {
                            System.out.println(account.toString());
                        }
                    else
                        System.out.println("Hien chua co tai khoan nao");
                    break;
                case 7:

                    break;

                default:
                    break;

            }
            if (choose == 7)
                break;
        }
    }

    // ----------- 3. giao dich -----------
    public void giaoDich(Scanner sc) {
        int choose;
        while (true) {
            System.out.println("-------- Bao cao --------");
            System.out.println("1. Hien thi thong tin giao dich cua khach hang");
            System.out.println("2. Hien thi thong tin giao dich cua tai khoan");
            System.out.println("3. Xuat file giao dich theo thang cua khach hang");
            System.out.println("4. Thoat");
            System.out.println("(Xep theo ngay thuc hien giao dich va loai tai khoan)");

            System.out.print("\nNhap lua chon: ");
            choose = checkInt(sc);
            String month, year, matk, maKH, beginTime, endTime;
            switch (choose) {
                case 1:
                    System.out.print("Nhap ma khach hang: ");
                    maKH = sc.nextLine();
                    System.out.print("Nhap begin time(dd/MM/yyyy): ");
                    beginTime = sc.nextLine();
                    System.out.print("Nhap end time(dd/MM/yyyy): ");
                    endTime = sc.nextLine();
                    gDich.transactionTheoCus(maKH, beginTime, endTime);
                    break;
                case 2:
                    System.out.print("Nhap ma tai khoan: ");
                    matk = sc.nextLine();
                    System.out.print("Nhap begin time(dd/MM/yyyy): ");
                    beginTime = sc.nextLine();
                    System.out.print("Nhap end time(dd/MM/yyyy): ");
                    endTime = sc.nextLine();
                    gDich.transactionTheoAcc(matk, beginTime, endTime);
                    break;
                case 3:
                    System.out.print("Nhap thang: ");
                    month = sc.nextLine();

                    System.out.print("Nhap nam: ");
                    year = sc.nextLine();
                    if (gDich.xuatFile(month, year))
                        System.out.println("Ghi file thanh cong");
                    else
                        System.out.println("Hien chua co giao dich nao phu hop");
                    break;
                case 4:

                    break;

                default:
                    break;

            }
            if (choose == 4)
                break;
        }
    }

    public static void main(String[] args) {
        quanLy manage = new quanLy();
        int choose;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("========= MAIN ========");
            System.out.print("1. Customer");
            System.out.println("\t\t2. Account");
            System.out.print("3. Giao dich");
            System.out.println("\t\t4. Thoat");
            System.out.print("\nNhap lua chon: ");
            choose = manage.checkInt(sc);

            switch (choose) {
                case 1:
                    manage.customer(sc);
                    break;
                case 2:
                    manage.account(sc);
                    break;
                case 3:
                    manage.giaoDich(sc);
                    break;
                case 4:

                    break;

                default:
                    break;

            }
            if (choose == 4)
                break;
        }
        sc.close();

    }
}