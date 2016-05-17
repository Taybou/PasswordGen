package model;

import controller.PasswordController;

import java.sql.Connection;

public class DAOFactory {

    protected static final Connection connection = ConnectionDB.getInstance();

    public static PasswordDAO getPasswordDAO() {
        return new PasswordController(connection);
    }

}
