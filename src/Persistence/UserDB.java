package Persistence;

import Logic.compUser;
import java.sql.*;

/**
 * Class to manipulate USERS table. This is the table where the user names and passwords are stored.
 * @author Miguel Angel Grimaldos
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
    public void createRegisteredUser(String userName, String password) throws Exception {
        try {
            if (!this.userNameExists(userName)) {
                int userID = findLastUserID() + 1;
                
                connManager.connect();
                
                connManager.updateDB("insert into USERS (USERNAME, PASSWORD) "
                        + "values ('" + userID + "', '" + userName + "', '" + password + "'");

                connManager.close();
            } else {
                throw new Exception("USU_REG_EXISTE");
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
            ResultSet rs = connManager.queryDB("select USERID, USERNAME, PASSWORD "
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
            
            ResultSet rs = connManager.queryDB("select USERID, USERNAME, PASSWORD "
                    + "from USERS where USERNAME= '" + userName + "'");
            connManager.close();
            try {
                if (rs.next()) {
                    compUser user = new compUser(rs.getInt("USERID"),
                            rs.getString("USERNAME"), rs.getString("PASSWORD"));
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
    
    /**
     * Finds the greatest userID in the DB
     * @return Greatest userID
     * @throws Exception 
     */
    public int findLastUserID() throws Exception {
        try {

            connManager.connect();
            
            ResultSet rs = connManager.queryDB("SELECT MAX(USERID) FROM USERS");
            connManager.close();
            try {
                if (rs.next()) {
                    int userID = rs.getInt(1);
                    return userID;
                } else {
                    return -1;
                }
            } catch (SQLException e) {
                throw new Exception("DB_READ_ERROR");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
