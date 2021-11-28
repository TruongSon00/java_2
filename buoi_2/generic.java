package buoi_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import sanpham.sanPham;

public class generic {
    public static void main(String[] args) {
        List<container> box = new ArrayList<>();
        LinkedList<Number> a = new LinkedList<>();
        a.add(1);
        // a.add(new sanPham());
        a.add(1);
        System.out.println(a);

        box.add(new container(1));
        box.add(new container(new sanPham()));

        System.out.println(box.toString());
    }
}

class container {
    public Object obj;

    public container(Object obj) {
        this.obj = obj;
    }

}