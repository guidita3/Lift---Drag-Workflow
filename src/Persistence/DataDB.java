package Persistence;

import java.sql.*;
import Logic.compData;

/**
 *
 * @author Miguel Angel Grimaldos
 */
public class DataDB {

    protected ConnectionManager connManager;

    public void createNewData(compData data) throws Exception {
        try {
            connManager.connect();

            connManager.updateDB("insert into BACKUP (ITERATION, R, T, THETA, COEFICIENT) "
                    + "values ('" + data.getIteration() + "', '" + data.getR() 
                    + "', '" + data.getT() + "', '" + data.getTheta() + "', '"
                    + data.getCoeficient() + "'");

            connManager.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public compData findLastData() throws Exception {
        try {

            connManager.connect();
            
            ResultSet rs = connManager.queryDB("select * "+ "from BACKUP"
                    + "where ITERATION=(SELECT MAX(ITERATION) FROM BACKUP)");
            connManager.close();
            try {
                if (rs.next()) {
                    compData data = new compData(rs.getInt("ITERATION"),
                            rs.getDouble("R"), rs.getDouble("T"),
                            rs.getDouble("THETA"), rs.getDouble("COEFICIENT"));
                    return data;
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
}
