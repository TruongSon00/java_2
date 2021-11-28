package buoi_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class set {
    private String ma;
    private int piece;

    public set(String ma, int piece) {
        this.ma = ma;
        this.piece = piece;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Integer getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        return "\n  Ma = " + ma + "  |  piece = " + piece;
    }

    public static void main(String[] args) {
        Set<set> listSPBanChay = new TreeSet<>(new Comparator<set>() {

            @Override
            public int compare(set arg0, set arg1) {
                if (arg0 == null && arg1 == null)
                    return 0;

                int checkTrung = arg1.getMa().compareToIgnoreCase(arg0.getMa());
                if (checkTrung == 0)
                    return 0;
                int sort = arg1.getPiece().compareTo(arg0.getPiece());
                if (sort == 0)
                    return -1;
                return sort;

            }

        });

        List<set> listSP = new ArrayList<>();
        listSP.add(new set("t001", 2));
        listSP.add(new set("t002", 3));
        listSP.add(new set("t002", 5));
        listSP.add(new set("t003", 7));
        listSP.add(new set("t003", 3));
        listSP.add(new set("t003", 5));
        listSP.add(new set("t004", 2));
        listSP.add(new set("t005", 9));
        listSP.add(new set("t005", 9));
        listSP.add(new set("t005", 10));
        listSP.add(new set("t005", 91));
        listSP.add(new set("t005", 92));

        listSPBanChay.addAll(listSP);
        listSPBanChay.add(new set("t001", 2));
        listSPBanChay.add(new set("t002", 3));
        listSPBanChay.add(new set("t002", 5));
        listSPBanChay.add(new set("t003", 7));
        listSPBanChay.add(new set("t003", 3));
        listSPBanChay.add(new set("t003", 5));
        listSPBanChay.add(new set("t004", 2));
        listSPBanChay.add(new set("t005", 9));
        listSPBanChay.add(new set("t006", 9));
        listSPBanChay.add(new set("t006", 10));
        listSPBanChay.add(new set("t007", 91));
        listSPBanChay.add(new set("t007", 92));
        System.out.println(listSPBanChay.toString() + " size = " + listSPBanChay.size());
        List<set> listMoi = new ArrayList<>(listSPBanChay);
        System.out.println(listMoi.toString());
        Iterator<set> a = listSPBanChay.iterator();
        while (a.hasNext()) {
            System.out.println(a.next());
        }
    }

}
