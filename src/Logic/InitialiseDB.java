/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;

import java.io.IOException;
import java.sql.*;

/**
 * Class that initialises the DB at the beginning of the execution.
 * @author Miguel Angel Grimaldos
 */
public class InitialiseDB {    
    private static Connection dbcon = null;
    
    /**
     * Runs and cleans the database from old data.
     * @param args 
     */
    public void init(){
        
        try{
            Class.forName ("org.hsqldb.jdbcDriver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            dbcon = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/aerofoil");
	} catch (SQLException e) {
            e.printStackTrace();
	}
        try {
            Statement sentencia = dbcon.createStatement();
            //sentencia.execute("delete from PUBLIC.USER;");
            sentencia.execute("delete from PUBLIC.BACKUP;");
	} catch (SQLException e) {
            e.printStackTrace();
	}
    }
}
