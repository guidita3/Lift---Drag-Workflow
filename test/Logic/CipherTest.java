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
        String result = Cipher.getSalt();
        assertNotNull(result);
    }

    /**
     * Test of getSecurePassword method, of class Cipher.
     */
    @Test
    public void testGetSecurePassword() {
        System.out.println("getSecurePassword");
        String passwordToHash = "password";
        String salt = "[B@73e171d3";
        String expResult = "f90276f437977afc0577e06e906a4a2db3e39371";
        String result = Cipher.getSecurePassword(passwordToHash, salt);
        assertEquals(expResult, result);
    }
    
}
