package buoi_5.bank;

public class account {
    public long amount;

    public account(long amount) {
        this.amount = amount;
    }

    public void rutTien(String name, long soTien) {
        synchronized (this) {
            if (soTien <= amount) {
                amount -= soTien;
                System.out.println("Nguoi: " + name + "\tTrang thai: Thanh Cong  " + "--->  tien con lai: " + amount);
            } else
                System.out.println("Nguoi: " + name + "\tTrang thai: That bai: " + amount);
        }
    }

}
