package buoi_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class writeReadBook {
    public static void main(String[] args) {
        // String fileObject = "book.txt";
        File fileOb = new File("book.txt");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileOb));

        ) {
            List<book> lBooks = new ArrayList<>();
            lBooks.add(new book("Truyen Kieu", 23000));
            lBooks.add(new book("Truyen ngu ngon", 23000));
            lBooks.add(new book("Truyen trinh tham", 23000));
            lBooks.add(new book("Truyen thieu nhi", 23000));
            lBooks.add(new book("Truyen tranh", 23000));
            lBooks.add(new book("Truyen hai", 23000));
            // book conan = new book("conan", 21000);
            oos.writeObject(lBooks);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ------------ input --------------
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileOb));) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                List<book> listBook = new ArrayList<>();
                // listBook.addAll((List<book>) obj);
                for (book sach : listBook)
                    System.out.println(sach);

            } else if (obj instanceof book)
                System.out.println(obj.toString());
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// ------------ Serializable: cho phep tuan tu ghi thuoc tinh vao file theo
// object ----------
class book implements Serializable {
    private String name;
    private int price;

    // ------------ transient: ngan khong cho ghi thuoc tinh vao file ---------
    private transient int id;

    public book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book  --->  Name = " + name + "  |  Price = " + price;
    }

}
