package assignment_adf2.objectDao;

import assignment_adf2.object.account;

public interface accountDao {
    public boolean insert(account customer);

    public boolean update(account customer);

    public boolean delete(String maKH);

    public boolean show();
}
