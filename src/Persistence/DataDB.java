package Persistence;

import java.sql.*;
import Logic.compData;

/**
 * Class to manipulate BACKUP table. This is the table where the results from the computation are stored.
 * @author Joan Francesc
 * @author Miguel Angel Grimaldos 
 * @author Margarida Pereira
 * @author Marta Vitores
 */
public class DataDB {

    protected ConnectionManager connManager;
    
    /**
     * Default constructor
     * @throws Exception 
     */
    public DataDB()throws Exception{
        connManager = new ConnectionManager("aerofoil");
    }

    /**
     * It introduces new data in the DB.
     * @param data Object containing the data to be stored
     * @throws Exception 
     */
    public void createNewData(compData data) throws Exception {
        try {
            connManager.connect();

            connManager.updateDB("insert into BACKUP (ITERATION, R, T, THETA, COEFICIENT) "
                    + "values ('" + data.getIteration() + "', '" + data.getR() 
                    + "', '" + data.getT() + "', '" + data.getTheta() + "', '"
                    + data.getCoeficient() + "')");

            connManager.close();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * It returns the data from the last iteration.
     * @return Last iteration data
     * @throws Exception 
     */
    public compData findLastData() throws Exception {
        try {

            connManager.connect();
            
            ResultSet rs = connManager.queryDB("select * "+ "from BACKUP"
                    + " where ITERATION=(SELECT MAX(ITERATION) FROM BACKUP)");
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
