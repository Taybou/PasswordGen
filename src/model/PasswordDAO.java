package model;

import beans.Password;
import java.sql.Connection;
import java.util.List;

public abstract class PasswordDAO {

    protected Connection connection = null;

    public PasswordDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract boolean addPassword(Password x);

    public abstract List<Password> getAllAccount();

    public abstract Password getAccount(int id);

    public abstract boolean deleteAccount(int id);

    public abstract boolean updateAccount(Password x);

}
