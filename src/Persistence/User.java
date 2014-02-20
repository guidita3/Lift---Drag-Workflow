package Persistence;

import java.sql.*;

/**
 *
 * @author Miguel Angel Grimaldos
 */
public class User {

    protected ConnectionManager connManager;

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

    public boolean findPersonbyUserName(String userName) throws Exception {
        try {

            connManager.connect();
            ResultSet rs = connManager.queryDB("select USERID, USERNAME, PASSWORD "
                    + "from USERS where USERNAME= '" + userName + "'");
            connManager.close();
            try {
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                throw new Exception("DB_READ_ERROR");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
