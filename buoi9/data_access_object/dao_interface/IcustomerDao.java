package buoi9.data_access_object.dao_interface;

import java.util.List;

import buoi9.data_access_object.obj.customer;
import buoi9.utils.respon;

public interface IcustomerDao {
    public respon insert(customer customer);

    public respon update(customer customer);

    public respon delete(int id);

    public List<customer> select();
}
