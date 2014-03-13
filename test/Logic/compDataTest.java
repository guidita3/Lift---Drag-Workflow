

package Logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for class compData
 * @author Joan Francesc
 * @author Miguel Angel Grimaldos 
 * @author Margarida Pereira
 * @author Marta Vitores
 */
public class compDataTest {
    
    public compDataTest() {
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
     * Test of getIteration method, of class compData.
     */
    @Test
    public void testGetIteration() {
        System.out.println("getIteration");
        compData instance = new compData();
        int expResult = -1;
        int result = instance.getIteration();
        assertEquals(expResult, result);
        
        instance = new compData(2, 3, 4, 5, 6);
        expResult = 2;
        result = instance.getIteration();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIteration method, of class compData.
     */
    @Test
    public void testSetIteration() {
        System.out.println("setIteration");
        int iteration = 7;
        compData instance = new compData(2, 3, 4, 5, 6);
        instance.setIteration(iteration);
        assertEquals(iteration, instance.getIteration());
    }

    /**
     * Test of getR method, of class compData.
     */
    @Test
    public void testGetR() {
        System.out.println("getR");
        compData instance = new compData(2, 3, 4, 5, 6);
        double expResult = 3;
        double result = instance.getR();
        assertEquals(expResult, result, 0.0);

        instance = new compData();
        expResult = -1;
        result = instance.getR();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setR method, of class compData.
     */
    @Test
    public void testSetR() {
        System.out.println("setR");
        double r = 0.0;
        compData instance = new compData(2, 3, 4, 5, 6);
        instance.setR(r);
        assertEquals(r, instance.getR(), 0.0);
    }

    /**
     * Test of getT method, of class compData.
     */
    @Test
    public void testGetT() {
        System.out.println("getT");
        compData instance = new compData(2, 3, 4, 5, 6);
        double expResult = 4;
        double result = instance.getT();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setT method, of class compData.
     */
    @Test
    public void testSetT() {
        System.out.println("setT");
        double t = 0.0;
        compData instance = new compData(2, 3, 4, 5, 6);
        instance.setT(t);
        assertEquals(t, instance.getT(), 0.0);
    }

    /**
     * Test of getTheta method, of class compData.
     */
    @Test
    public void testGetTheta() {
        System.out.println("getTheta");
        compData instance = new compData(2, 3, 4, 5, 6);
        double expResult = 5;
        double result = instance.getTheta();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setTheta method, of class compData.
     */
    @Test
    public void testSetTheta() {
        System.out.println("setTheta");
        double theta = 0.0;
        compData instance = new compData(2, 3, 4, 5, 6);
        instance.setTheta(theta);
        assertEquals(theta, instance.getTheta(), 0.0);
    }

    /**
     * Test of getCoeficient method, of class compData.
     */
    @Test
    public void testGetCoeficient() {
        System.out.println("getCoeficient");
        compData instance = new compData(2, 3, 4, 5, 6);
        double expResult = 6;
        double result = instance.getCoeficient();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setCoeficient method, of class compData.
     */
    @Test
    public void testSetCoeficient() {
        System.out.println("setCoeficient");
        double coeficient = 6;
        compData instance = new compData(2, 3, 4, 5, 6);
        instance.setCoeficient(coeficient);
        assertEquals(coeficient, instance.getCoeficient(), 0.0);
    }
    
}
