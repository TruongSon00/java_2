package assignment_adf2.objectDao;

import java.util.List;

import assignment_adf2.object.customer;

public interface customerDao {
    public void insert(customer customer);

    public void update(customer customer);

    public void delete(String maKH);

    public List<customer> show();
}
