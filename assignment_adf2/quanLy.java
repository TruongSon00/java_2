package assignment_adf2;

import java.sql.Connection;
import java.util.Scanner;

import assignment_adf2.connect.db_connect;
import assignment_adf2.object.account;
import assignment_adf2.object.customer;
import assignment_adf2.object.giaoDich;
import assignment_adf2.objectDaoImliment.accountImliment;
import assignment_adf2.objectDaoImliment.customerImlement;

public class quanLy {
    Connection connect = db_connect.getConnect();
    account accs = new accountImliment(connect);
    customer cus = new customerImlement(connect);
    giaoDich gDich = new giaoDich();

    // -------- check int ---------
    private int checkInt(Scanner sc) {
        int num;
        while (true) {
            try {
                num = sc.nextInt();
                sc.nextLine();
                return num;
            } catch (Exception e) {
                System.out.println("So khong duoc chua ky tu");
            }
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
            System.out.print("\n4. Nhap lua chon: ");
            choose = manage.checkInt(sc);

            switch (choose) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;

                default:
                    break;
            }
        }

    }
}