package assignment_adf2.objectDao;

import assignment_adf2.object.customer;

public interface customerDao {
    public boolean insert(customer customer);

    public boolean update(customer customer);

    public boolean delete(String maKH);

    public boolean show();
}
