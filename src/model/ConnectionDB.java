package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {

    private static final String     url  = "jdbc:sqlite:passwordAccount.sqlite";
    private static final String     user = "";
    private static final String     password   = "";
    private static Connection connection;


            
    public static Connection getInstance() {
        if ( connection == null ) {
            try {
                Class.forName("org.sqlite.JDBC");
            	connection = DriverManager.getConnection(url, user, password );
            } catch ( SQLException e ) {
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

}
