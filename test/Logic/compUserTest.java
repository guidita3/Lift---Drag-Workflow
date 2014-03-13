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
 * @author Joan Francesc
 * @author Miguel Angel Grimaldos 
 * @author Margarida Pereira
 * @author Marta Vitores
 */
public class compUserTest {
    
    public compUserTest() {
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
     * Test of getSalt method, of class compUser.
     */
    @Test
    public void testGetSalt() {
        System.out.println("getSalt");
        compUser instance = new compUser();
        String result = instance.getSalt();
        assertNull(result);
        
        instance = new compUser("user", "password", "[B@460dab4d");
        result = instance.getSalt();
        String expResult = "[B@460dab4d";
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class compUser.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        compUser instance = new compUser();
        String result = instance.getUsername();
        assertNull(result);
        
        instance = new compUser("user", "password", "[B@460dab4d");
        result = instance.getUsername();
        String expResult = "user";
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class compUser.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        compUser instance = new compUser();
        String result = instance.getPassword();
        assertNull(result);
        
        instance = new compUser("user", "password", "[B@460dab4d");
        result = instance.getPassword();
        String expResult = "password";
        assertEquals(expResult, result);
    }
    
}
