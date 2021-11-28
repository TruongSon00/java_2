package database.buoi_7;

public class book {
    public int id;
    public String name;
    public float price;

    public book(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nBook ------> id = " + id + "  |  name = " + name + "  |  price = " + price;
    }

}
