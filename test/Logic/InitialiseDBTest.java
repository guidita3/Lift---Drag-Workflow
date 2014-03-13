

package Logic;

import Persistence.DataDB;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for class InitialiseDB
 * @author Joan Francesc
 * @author Miguel Angel Grimaldos 
 * @author Margarida Pereira
 * @author Marta Vitores
 */
public class InitialiseDBTest {
    
    public InitialiseDBTest() {
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
     * Test of init method, of class InitialiseDB.
     */
    @Test
    public void testInit() throws Exception {
        System.out.println("init");
        InitialiseDB instance = new InitialiseDB();
        instance.init();
        
        assertNull(new DataDB().findLastData());
    }
    
}
