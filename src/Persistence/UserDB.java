package Persistence;

import Logic.compUser;
import java.sql.*;

/**
 * Class to manipulate USERS table. This is the table where the user names and passwords are stored.
 * @author Joan Francesc
 * @author Miguel Angel Grimaldos 
 * @author Margarida Pereira
 * @author Marta Vitores
 */
public class UserDB {

    protected ConnectionManager connManager;
    
    /**
     * Default constructor
     * @throws Exception 
     */
    public UserDB()throws Exception{
        connManager = new ConnectionManager("aerofoil");
    }

    /**
     * It creates a new user in the DB.
     * @param userName Nickname of the user
     * @param password Password of the user
     * @throws Exception 
     */
    public void createRegisteredUser(String userName, String password, String salt) throws Exception {
        try {
            if (!this.userNameExists(userName)) {
                connManager.connect();
                
                connManager.updateDB("insert into USERS (USERNAME, PASSWORD, SALT) "
                        + "values ('" + userName + "', '" + password + "', '" + salt + "')");

                connManager.close();
            } else {
                throw new Exception("USU_REG_EXISTS");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Check if a certain Username exists already in the DB.
     * @param userName Username we want to check
     * @return Whether the username exists or not
     * @throws SQLException 
     * @throws Exception 
     */
    public boolean userNameExists(String userName) throws Exception {
        try {

            connManager.connect();
            ResultSet rs = connManager.queryDB("select USERNAME, PASSWORD, SALT "
                    + "from USERS where USERNAME= '" + userName + "'");
            connManager.close();
            try {
                return rs.next();
            } catch (SQLException e) {
                throw new Exception("DB_READ_ERROR");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Looks for information in the DB given a Username.
     * @param userName Username we want to get the info about
     * @return Information related with the Username given. Null if it doesn't exist
     * @throws SQLException 
     * @throws Exception 
     */
    public compUser findPersonbyUserName(String userName) throws Exception {
        try {

            connManager.connect();
            
            ResultSet rs = connManager.queryDB("select USERNAME, PASSWORD, SALT "
                    + "from USERS where USERNAME= '" + userName + "'");
            connManager.close();
            try {
                if (rs.next()) {
                    compUser user = new compUser(rs.getString("USERNAME"), 
                            rs.getString("PASSWORD"), rs.getString("SALT"));
                    return user;
                } else {
                    return null;
                }
            } catch (SQLException e) {
                throw new Exception("DB_READ_ERROR");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void deleteRegisteredUser(String userName) throws Exception {
        try {
            if (this.userNameExists(userName)) {
                connManager.connect();
                
                connManager.queryDB("DELETE FROM users WHERE username = '"
                        + userName + "'");

                connManager.close();
            } else {
                throw new Exception("USU_REG_DOESNT_EXISTS");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
