

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
            System.out.printf("Username:\n");
            System.out.printf(userName);
            System.out.printf("\n");
            System.out.printf("Password:\n");
            System.out.printf(Passw);
            System.out.printf("\n");
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
    
    
    /**
     * Function that registers a new username and password
     * @param userName String containing the username to be checked
     * @param Passw String containing the password to be checked
     * @return {@code true} if the user has been registered and {@code false} if not
     * @throws Exception
     */    
    public boolean RegisterUser(String userName, String Passw) throws Exception{
        try {
            System.out.printf("Username:\n");
            System.out.printf(userName);
            System.out.printf("\n");
            System.out.printf("Password:\n");
            System.out.printf(Passw);
            System.out.printf("\n");
            
            //Check if the username exists in the database
            //If it exists returns false because it cannot be created again
            //if not, it calls the function createRegisteredUser to register it
            boolean exist = new UserDB().userNameExists(userName);
            
            if (exist) return false;
            else 
            {
                new UserDB().createRegisteredUser(userName,Passw);
                return true;
            }
            
        } catch (Exception e){throw e;} //Database error
    }
    
    
    

}
