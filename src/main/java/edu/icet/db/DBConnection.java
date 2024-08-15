package edu.icet.db;

import edu.icet.modal.Customer;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static DBConnection instance;

    private List<Customer> connection;

    private DBConnection(){
        connection=new ArrayList<>();
    }
    public  List<Customer> getConnection(){
        return connection;
    }

    public static DBConnection getInstance() {

        return null==instance?instance=new DBConnection():instance;
    }
}
