package buoi_2.bai_tap;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class student implements Comparator<student> {
    private int maSV;
    private String name;
    private String birthday;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String address;
    private String gender;
    private String maNganh;

    // ------------- constructor -------------

    public student(int maSV, String name, String birthday, String address, String gender, String maNganh) {
        this.maSV = maSV;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.gender = gender;
        this.maNganh = maNganh;
    }

    // -------------- set, get ----------------------

    public student() {
    }

    public Integer getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    // -------------- mo rong ----------------

    @Override
    public String toString() {

        return "\n   Ma SV = " + maSV

                + "  |  name = " + name

                + "  |  birthday = " + birthday

                + "  |  gender = " + gender

                + "  |   address = " + address

                + "  |  ma nganh = " + maNganh;

    }

    // @Override
    // public boolean equals(Object obj) {

    // return this.equals(obj);
    // }

    // @Override
    // public int hashCode() {

    // return super.hashCode();
    // }

    @Override
    public int compare(student arg0, student arg1) {

        return arg0.getMaSV().compareTo(arg1.getMaSV());
    }

    public static void main(String[] args) {
        List<student> listSV = new ArrayList<>();
        listSV.add(new student(1, "Truong Son", "30/08/2000", "HP", "nam", "T23M"));
        listSV.add(new student(2, "Long Vu", "30/08/2005", "HP", "nam", "T23M"));
        listSV.add(new student(3, "Huu Cuong", "30/08/2004", "HP", "nam", "T23M"));
        listSV.add(new student(4, "Thanh Long", "30/08/2001", "HP", "nam", "T23M"));
        listSV.add(new student(5, "Truong An", "30/08/2003", "HP", "nam", "T23M"));

        // --------- main --------------
        Collections.sort(listSV, new Comparator<student>() {

            @Override
            public int compare(student arg0, student arg1) {
                return arg0.getName().split(" ")[1].compareTo(arg1.getName().split(" ")[1]);
            }

        });

        System.out.println(listSV.toString());

        // ---------- set ----------

        Set<String> listName = new HashSet<>();
        Set<student> listTreeSet = new HashSet<>();

        for (student student : listSV) {
            listTreeSet.add(student);

            if (listName.add(student.getName()))
                System.out.println(student.getName().toString());
        }

        Set<student> sortMaSv = new TreeSet<>(new student());
        sortMaSv.addAll(listTreeSet);
        System.out.println(sortMaSv);

        // -------- tim ten ------------

        System.out.println("Nhap ten can tim: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        boolean check = false;
        for (student student : listSV) {
            if (name.equalsIgnoreCase(student.getName())) {
                System.out.println("xoa thanh cong: " + student.toString());
                listSV.remove(student);

                check = true;
                break;
            }
        }

        if (!check)
            System.out.println("ten khong ton tai");

        sc.close();

        // ----------- sep theo tuoi -----------
        System.out.println("---------- Sap xep theo tuoi --------------");
        Collections.sort(listSV, new Comparator<student>() {

            @Override
            public int compare(student arg0, student arg1) {
                return arg1.getBirthday().substring(6).compareTo(arg0.getBirthday().substring(6));
            }

        });

        int tuoi;
        int count = 0;
        for (student student : listSV) {
            tuoi = 2021 - Integer.valueOf(student.getBirthday().substring(6));
            if (tuoi < 16) {
                System.out.println(count == 0);
                if (count == 0) {
                    System.out.println("-------- Tuoi tre tai cao ---------\n");
                    count++;
                }

                System.out.println(student.toString() + "  |  tuoi: " + tuoi);
            }
            if (count == 0)
                count++;
            if (tuoi < 18) {

                if (count == 1) {
                    System.out.println("-------- Thanh nien choai choai ---------\n");
                    count++;
                }
                System.out.println(student.toString() + "  |  tuoi: " + tuoi);
            }
            if (count == 0 || count == 1)
                count++;
            if ((tuoi >= 18)) {
                if (count == 2) {
                    System.out.println("-------- Hoi nguoi gia leo don ---------\n");
                    count += 1;
                }
                System.out.println(student.toString() + "  |  tuoi: " + tuoi);
            }
        }

    }

}
