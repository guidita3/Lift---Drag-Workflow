/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Persistence.UserDB;

/**
 *
 * @author s206689
 */
public class LoginLogic {
    
    public boolean checkUserAndPassword(String userName, String Passw) throws Exception{
        try {
            //Check if the username exists in the database
            boolean exist = new UserDB().userNameExists(userName);
            
            //If it exists, check its password
            //False is returned if it does not exsist or the password is not ok
            if (exist)
            {
               compUser check = new UserDB().findPersonbyUserName(userName);
               if ( Passw.equals(check.getPassword()) ) return true;
                 else return false;      
            }
            else return false;

        } catch (Exception e){throw e;} //Database error
    }

}
