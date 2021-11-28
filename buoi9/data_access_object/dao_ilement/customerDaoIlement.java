package buoi9.data_access_object.dao_ilement;

import java.sql.Connection;
import java.util.List;

import buoi9.data_access_object.dao_interface.IcustomerDao;
import buoi9.data_access_object.obj.customer;
import buoi9.designbattan.db_connection;
import buoi9.utils.respon;

public class customerDaoIlement implements IcustomerDao {
    Connection connect = db_connection.getInstance().getConnection();

    @Override
    public respon insert(customer customer) {

        return null;
    }

    public respon delete(int id) {

        return null;
    }

    public List<customer> select() {

        return null;
    }

    public respon update(customer customer) {

        return null;
    }

}
