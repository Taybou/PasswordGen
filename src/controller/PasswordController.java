package controller;

import beans.Password;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PasswordDAO;

/**
 *
 * @author Xo
 */
public class PasswordController extends PasswordDAO {

    public PasswordController(Connection connection) {
        super(connection);
    }

    private PreparedStatement request;
    private ResultSet resultSet;

    private final String ADD_PASSWORD = "INSERT INTO password (account,userAccount,passwordAccount) "
            + "VALUES (?,?,?)";
    private final String ALL_ACCOUNT = "SELECT * FROM password";
    private final String GET_ACCOUNT = "SELECT * FROM password WHERE id = ?";
    private final String UPDATE_ACCOUNT = "UPDATE password "
            + "SET account = ? , "
            + "userAccount = ? , "
            + "passwordAccount = ? "
            + "WHERE  id = ? ";

    private final String DELETE_ACCOUNT = "DELETE FROM password WHERE id = ? ";

    @Override
    public boolean addPassword(Password x) {
        boolean flag = false;
        try {
            request = connection.prepareStatement(ADD_PASSWORD);
            request.setString(1, x.getAccount());
            request.setString(2, x.getUserAccount());
            request.setString(3, x.getPasswordAccount());

            if (request.executeUpdate() != 0) {
                flag = true;
            }
        } catch (SQLException e) {
            flag = false;
            System.err.println(e.toString());
        }
        return flag;
    }

    @Override
    public List<Password> getAllAccount() {
        List<Password> list = new ArrayList<>();
        Password password;
        try {
            request = connection.prepareStatement(ALL_ACCOUNT);
            resultSet = request.executeQuery();

            while (resultSet.next()) {
                password = mapPassword(resultSet);
                list.add(password);
            }

        } catch (SQLException e) {
        }
        return list;
    }

    @Override
    public Password getAccount(int id) {
        Password password = null;
        try {
            request = connection.prepareStatement(GET_ACCOUNT);
            request.setInt(1, id);
            resultSet = request.executeQuery();

            while (resultSet.next()) {
                password = mapPassword(resultSet);
            }

        } catch (SQLException e) {
        }
        return password;
    }

    @Override
    public boolean deleteAccount(int id) {
        boolean flag = false;
        try {
            request = connection.prepareStatement(DELETE_ACCOUNT);
            request.setInt(1, id);

            if (request.executeUpdate() != 0) {
                flag = true;
            }
        } catch (SQLException e) {
            flag = false;
            System.err.println(e.toString());
        }
        return flag;
    }

    @Override
    public boolean updateAccount(Password x) {
        boolean flag = false;
        try {
            request = connection.prepareStatement(UPDATE_ACCOUNT);
            request.setString(1, x.getAccount());
            request.setString(2, x.getUserAccount());
            request.setString(3, x.getPasswordAccount());
            request.setInt(4, x.getId());

            if (request.executeUpdate() != 0) {
                flag = true;
            }
        } catch (SQLException e) {
            flag = false;
            System.err.println(e.toString());
        }
        return flag;
    }

    private static Password mapPassword(ResultSet resultset) throws SQLException {
        Password password = new Password(
                resultset.getInt("id"),
                resultset.getString("account"),
                resultset.getString("userAccount"),
                resultset.getString("passwordAccount"));

        return password;
    }

}
