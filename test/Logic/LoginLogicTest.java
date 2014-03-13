

package Logic;

import Persistence.UserDB;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for class LoginLogic
 * @author Joan Francesc
 * @author Miguel Angel Grimaldos 
 * @author Margarida Pereira
 * @author Marta Vitores
 */
public class LoginLogicTest {
    
    public LoginLogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkUserAndPassword method, of class LoginLogic.
     */
    @Test
    public void testCheckUserAndPassword() throws Exception {
        System.out.println("checkUserAndPassword");
        
        //Create variables for the test
        String userName = "testUser";
        String Passw = "testPass";
        LoginLogic instance = new LoginLogic();
        
        //Add user to DB with testUser and testPass if it does not exist already
        boolean exist = new UserDB().userNameExists(userName);
        if (!exist) {
           String salt = Cipher.getSalt();
           String passHashed = Cipher.getSecurePassword(Passw, salt);
           new UserDB().createRegisteredUser(userName, passHashed, salt);
        }      
        
        //////////Test for checkUserAndPassword////////
        boolean result;
        boolean expResult = false;
        
        result = instance.checkUserAndPassword(userName, "different_password");
        assertEquals(expResult, result);
        
        result = instance.checkUserAndPassword("different_username", Passw);
        assertEquals(expResult, result);
        
        expResult = true;
        result = instance.checkUserAndPassword(userName, Passw);
        assertEquals(expResult, result);
        
        //Delete user testUser from DB
        new UserDB().deleteRegisteredUser(userName);
    }

    
    /**
     * Test of RegisterUser method, of class LoginLogic.
     */
    @Test
    
    public void testRegisterUser() throws Exception {
        System.out.println("RegisterUser");
        
        //Create variables for the test
        String userName = "testUser";
        String Passw = "testPass";
        LoginLogic instance = new LoginLogic();
        
        //Add user to DB with testUser and testPass if it does not exist already
        boolean exist = new UserDB().userNameExists(userName);
        if (!exist) {
           String salt = Cipher.getSalt();
           String passHashed = Cipher.getSecurePassword(Passw, salt);
           new UserDB().createRegisteredUser(userName, passHashed, salt);
        }  
        
        //////////Test for RegisterUser////////
        boolean expResult = false;
        //The user already exists so RegisterUser should return false
        boolean result = instance.RegisterUser(userName, Passw);
        assertEquals(expResult, result);
        
        
        //Delete user testUser from DB
        new UserDB().deleteRegisteredUser(userName);
        
        
        expResult = true;
        //The user has been deleted, it does not exist, so RegisterUser should 
        //register it and return true
        result = instance.RegisterUser(userName, Passw);
        assertEquals(expResult, result);
        //Check if it was registered correctly
        exist = new UserDB().userNameExists(userName);
        assertEquals(expResult, exist);
        
        //Delete user testUser from DB
        new UserDB().deleteRegisteredUser(userName);        
        
    }
    
}
