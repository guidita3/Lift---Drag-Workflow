package Persistence;

/**
 *
 * @author Miguel Angel Grimaldos
 */
import java.sql.*;

public class ConnectionManager {

    private String sourceURL;
    private Connection dbcon = null;

    public ConnectionManager(String dbname) throws ClassNotFoundException {
        Class.forName("org.hsqldb.jdbcDriver");
        sourceURL = "jdbc:hsqldb:hsql://localhost/" + dbname;
    }

    public void connect() throws Exception {
        if (dbcon == null) {
            try {
                dbcon = DriverManager.getConnection(sourceURL);
            } catch (SQLException e) {
                throw new Exception("DB_CONNECT_ERROR");
            }
        }
    }

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
