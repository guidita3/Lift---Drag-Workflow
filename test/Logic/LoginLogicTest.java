/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pereira
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
        String userName = "testUser";
        String Passw = "testPass";
        LoginLogic instance = new LoginLogic();
        boolean expResult = false;
        boolean result = instance.checkUserAndPassword(userName, Passw);
        assertEquals(expResult, result);
        
        // add user to DB with userName and Passw
        result = instance.checkUserAndPassword(userName, "different_password");
        assertEquals(expResult, result);
        
        result = instance.checkUserAndPassword("different_username", Passw);
        assertEquals(expResult, result);
        
        expResult = true;
        result = instance.checkUserAndPassword(userName, Passw);
        assertEquals(expResult, result);
        
        // delete user from DB
    }
    
}
