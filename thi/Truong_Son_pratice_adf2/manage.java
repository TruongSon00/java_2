package thi.Truong_Son_pratice_adf2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class manage {
    private File root = new File(System.getProperty("user.dir"));
    private final File file = new File(root, "thi/Truong_Son_pratice_adf2/data.bat");

    // --------- add method ---------
    public boolean addBook(List<book> lbooks, Scanner sc) {
        boolean check = false;
        book sach = new book();
        sach.nhapTT(sc);
        check = lbooks.add(sach);
        return check;
    }

    // --------- save method ---------
    public boolean saveBook(List<book> lbooks) {
        FileOutputStream writeFile = null;
        ObjectOutputStream objectWrite = null;
        try {
            file.createNewFile();
            writeFile = new FileOutputStream(file);
            objectWrite = new ObjectOutputStream(writeFile);
            objectWrite.writeObject(lbooks);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                objectWrite.close();
                writeFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    // --------- display method ---------
    public void displayBook() {
        FileInputStream readFile = null;
        ObjectInputStream objectRead = null;
        try {
            readFile = new FileInputStream(file);
            objectRead = new ObjectInputStream(readFile);
            Object listBook = objectRead.readObject();

            if (listBook instanceof List) {
                List<book> lBooks = (List<book>) listBook;
                for (book book : lBooks) {
                    System.out.println(book.toString());
                }
            } else if (listBook instanceof book) {
                System.out.println(listBook.toString());
            } else {
                System.out.println("chua co book");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                readFile.close();
                objectRead.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        manage manageBook = new manage();
        List<book> lBooks = new ArrayList<>();

        int choose;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("======== MAIN ==========");
            System.out.print("1. Add book");
            System.out.println("\t\t2. Save book");
            System.out.print("3. Display book");
            System.out.println("\t\t4. Exit");
            System.out.print("Nhap lua chon: ");

            try {
                choose = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                sc.nextLine();
                choose = 5;
            }

            switch (choose) {
                case 1:
                    if (manageBook.addBook(lBooks, sc)) {
                        System.out.println("add book succes");
                    } else {
                        System.out.println("add book succes");

                    }
                    break;

                case 2:
                    if (manageBook.saveBook(lBooks)) {
                        System.out.println("add book succes");
                    } else {
                        System.out.println("add book succes");
                    }
                    break;

                case 3:
                    manageBook.displayBook();
                    break;

                case 4:

                    break;

                default:
                    System.out.println("Lua chon khong ton tai!!!");
            }
            if (choose == 4)
                break;
        }
        sc.close();
        System.out.println("Thank you used us service");

    }
}
