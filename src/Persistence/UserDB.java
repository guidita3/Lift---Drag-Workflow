package Persistence;

import java.sql.*;

/**
 * Class to manipulate USERS table. This is the table where the user names and passwords are stored.
 * @author Miguel Angel Grimaldos
 */
public class UserDB {

    protected ConnectionManager connManager;

    /**
     * It creates a new user in the DB.
     * @param userName Nickname of the user
     * @param password Password of the user
     * @throws Exception 
     */
    public void createRegisteredUser(String userName, String password) throws Exception {
        try {
            if (this.findPersonbyUserName(userName)) {
                connManager.connect();

                connManager.updateDB("insert into USERS (USERNAME, PASSWORD) "
                        + "values ('" + userName + "', '" + password + "'");

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
     * @throws Exception 
     */
    public boolean findPersonbyUserName(String userName) throws Exception {
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
}
