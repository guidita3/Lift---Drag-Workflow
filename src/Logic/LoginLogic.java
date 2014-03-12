

package Logic;

import Persistence.UserDB;

/**
 *
 * @author s206689
 */
public class LoginLogic {
    
    
    /**
     * Function that checks if the username and password given exist together
     * in the database, so the user could accede to the system.
     * @param userName String containing the username to be checked
     * @param Passw String containing the password to be checked
     * @return {@code true} if the user can accede and {@code false} if not
     * @throws Exception
     */
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
