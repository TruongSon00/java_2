package buoi9.data_access_object.obj;

public class customer {
    private String name;
    private int id;

    public customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "customer [id=" + id + ", name=" + name + "]";
    }

}
