package buoi_3;

public class test {
    public static int check(int num, int total) {

        if (num == 0)
            return total;
        System.out.println(total);
        total += num + check(--num, total);
        return total;

    }

    public static void main(String[] args) {
        int total = 0;

        System.out.println(check(12, total));
    }
}
