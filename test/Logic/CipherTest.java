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
public class CipherTest {
    
    public CipherTest() {
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
     * Test of getSalt method, of class Cipher.
     */
    @Test
    public void testGetSalt() throws Exception {
        System.out.println("getSalt");
        String expResult = "";
        String result = Cipher.getSalt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecurePassword method, of class Cipher.
     */
    @Test
    public void testGetSecurePassword() {
        System.out.println("getSecurePassword");
        String passwordToHash = "";
        String salt = "";
        String expResult = "";
        String result = Cipher.getSecurePassword(passwordToHash, salt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
