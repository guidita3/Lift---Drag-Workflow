package Persistence;

/**
 * Class used to connect with the DB.
 * @author Miguel Angel Grimaldos
 */
import java.sql.*;

public class ConnectionManager {

    private String sourceURL;
    private Connection dbcon = null;

    /**
     * Alternate constructor to connect to the DB.
     * @param dbname Name of the database we want to connect with.
     * @throws ClassNotFoundException 
     */
    public ConnectionManager(String dbname) throws ClassNotFoundException {
        Class.forName("org.hsqldb.jdbcDriver");
        sourceURL = "jdbc:hsqldb:hsql://localhost/" + dbname;
    }

    /**
     * Connects with the specified DB.
     * @throws Exception 
     */
    public void connect() throws Exception {
        if (dbcon == null) {
            try {
                dbcon = DriverManager.getConnection(sourceURL);
            } catch (SQLException e) {
                throw new Exception("DB_CONNECT_ERROR");
            }
        }
    }

    /**
     * Closes the connection with the specified DB.
     * @throws Exception 
     */
    public void close() throws Exception {
        if (dbcon != null) {
            try {
                dbcon.close();
            } catch (SQLException e) {
                throw new Exception("DB_DISCONNECT_ERROR");
            }
            dbcon = null;
        }
    }

    /**
     * Updates data in the DB.
     * @param sql Query for updating data
     * @throws Exception 
     */
    public void updateDB(String sql) throws Exception {
        if (dbcon != null) {
            try {
                Statement statement = dbcon.createStatement();
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                throw new Exception("DB_WRITE_ERROR");
            }
        }
    }

    /**
     * Performs a query to the DB.
     * @param sql Query for accessing data
     * @return Information read from the DB
     * @throws Exception 
     */
    public ResultSet queryDB(String sql) throws Exception {
        if (dbcon != null) {
            try {
                Statement statement = dbcon.createStatement();
                return statement.executeQuery(sql);
            } catch (SQLException e) {
                throw new Exception("DB_READ_ERROR");
            }
        }
        return null;
    }
}
