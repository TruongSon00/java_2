package assignment_adf2.objectDaoImliment;

import java.sql.Connection;
import java.util.concurrent.locks.Condition;

import assignment_adf2.object.customer;
import assignment_adf2.objectDao.customerDao;

public class customerImlement extends customer implements customerDao {
    private Connection connect;

    public customerImlement(Connection connect) {
        this.connect = connect;
    }

    @Override
    public boolean delete(String maKH) {

        return false;
    }

    @Override
    public boolean insert(customer customer) {

        return false;
    }

    @Override
    public boolean show() {

        return false;
    }

    @Override
    public boolean update(customer customer) {

        return false;
    }

}
