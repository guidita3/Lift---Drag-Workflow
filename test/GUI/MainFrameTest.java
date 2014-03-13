

package GUI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for class MainFrame
 * @author Joan Francesc
 * @author Miguel Angel Grimaldos 
 * @author Margarida Pereira
 * @author Marta Vitores
 */
public class MainFrameTest {
    
    public MainFrameTest() {
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
     * Test of drawChart method, of class MainFrame.
     */
    @Test
    public void testDrawChart() {
        System.out.println("drawChart");
        MainFrame instance = new MainFrame();
        instance.drawChart();
        assertTrue(instance.isDisplayable());
    }

    /**
     * Test of lift method, of class MainFrame.
     */
    @Test
    public void testLift() {
        System.out.println("lift");
        double r = 1.0;
        double t = 1.0;
        double theta = 0.5;
        MainFrame instance = new MainFrame();
        double expResult = 2.72704339942458E8 ;
        double result = instance.lift(r, t, theta);
        assertEquals(expResult, result, 1000);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of drag method, of class MainFrame.
     */
    @Test
    public void testDrag() {
        System.out.println("drag");
        double r = 1.0;
        double t = 1.0;
        double theta = 0.5;
        MainFrame instance = new MainFrame();
        double expResult = 7925818.381141541;
        double result = instance.drag(r, t, theta);
        assertEquals(expResult, result, 1000);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

  /**
     * Test of optimizer method, of class MainFrame.
     */
    @Test
    public void testOptimizer() {
        System.out.println("optimizer");
        double lift_drag = 1.0;
        double old_lift_drag = 0.0;
        double[] old_params = new double[4];
        double[] current_params = new double[4];
        double[] step = new double[3];
        double[] result = new double[4];
        int p = 0;
        MainFrame instance = new MainFrame();
        
        //first set of tests (improving lift_drag)
        step[0] = 0.001;
        step[1] = 0.001;
        step[2] = 0.00001;
        
        current_params[0] = 1.0;
        current_params[1] = 1.0;
        current_params[2] = 0.5;
        current_params[3] = 0.0;

        old_params[0] = current_params[0] - step[0];
        old_params[1] = current_params[1] - step[1];
        old_params[2] = current_params[2] - step[2];
        old_params[3] = 0;
        
        double[] expResult = new double[4];
        expResult[0] = 1.001;
        expResult[1] = 1.0;
        expResult[2] = 0.5;
        expResult[3] = 1.0;
        
        result = instance.optimizer(lift_drag, old_lift_drag, old_params, current_params, step, p);
        org.junit.Assert.assertEquals(expResult[0], result[0], 1000);
        org.junit.Assert.assertEquals(expResult[1], result[1], 1000);
        org.junit.Assert.assertEquals(expResult[2], result[2], 0.01);
        org.junit.Assert.assertEquals(expResult[3], result[3], 0.1);
        
        
        lift_drag = 1.0;
        old_lift_drag = 0.0;
        p = 1;
        
        current_params[0] = 1.0;
        current_params[1] = 1.0;
        current_params[2] = 0.5;
        current_params[3] = 0.0;

        old_params[0] = current_params[0] - step[0];
        old_params[1] = current_params[1] - step[1];
        old_params[2] = current_params[2] - step[2];
        old_params[3] = 0;
        
        expResult[0] = 1.0;
        expResult[1] = 1.001;
        expResult[2] = 0.5;
        expResult[3] = 1.0;
        
        result = instance.optimizer(lift_drag, old_lift_drag, old_params, current_params, step, p);
        org.junit.Assert.assertEquals(expResult[0], result[0], 1000);
        org.junit.Assert.assertEquals(expResult[1], result[1], 1000);
        org.junit.Assert.assertEquals(expResult[2], result[2], 0.01);
        org.junit.Assert.assertEquals(expResult[3], result[3], 0.1);
        
        
        lift_drag = 1.0;
        old_lift_drag = 0.0;
        p = 2;
        
        current_params[0] = 1.0;
        current_params[1] = 1.0;
        current_params[2] = 0.5;
        current_params[3] = 0.0;

        old_params[0] = current_params[0] - step[0];
        old_params[1] = current_params[1] - step[1];
        old_params[2] = current_params[2] - step[2];
        old_params[3] = 0;
        
        expResult[0] = 1.0;
        expResult[1] = 1.0;
        expResult[2] = 0.500001;
        expResult[3] = 1.0;
        
        result = instance.optimizer(lift_drag, old_lift_drag, old_params, current_params, step, p);
        org.junit.Assert.assertEquals(expResult[0], result[0], 1000);
        org.junit.Assert.assertEquals(expResult[1], result[1], 1000);
        org.junit.Assert.assertEquals(expResult[2], result[2], 0.01);
        org.junit.Assert.assertEquals(expResult[3], result[3], 0.1);
        
        //second test (not improving lift_drag)
        lift_drag = 1.0;
        old_lift_drag = 2.0;
        p = 0;
        
        current_params[0] = 1.0;
        current_params[1] = 1.0;
        current_params[2] = 0.5;
        current_params[3] = 0.0;

        old_params[0] = current_params[0] - step[0];
        old_params[1] = current_params[1] - step[1];
        old_params[2] = current_params[2] - step[2];
        old_params[3] = 0;
        
        expResult[0] = 0.999;
        expResult[1] = 1.0;
        expResult[2] = 0.5;
        expResult[3] = 0.0;
        
        result = instance.optimizer(lift_drag, old_lift_drag, old_params, current_params, step, p);
        org.junit.Assert.assertEquals(expResult[0], result[0], 1000);
        org.junit.Assert.assertEquals(expResult[1], result[1], 1000);
        org.junit.Assert.assertEquals(expResult[2], result[2], 0.01);
        org.junit.Assert.assertEquals(expResult[3], result[3], 0.1);
        
        lift_drag = 1.0;
        old_lift_drag = 2.0;
        p = 1;
        
        current_params[0] = 1.0;
        current_params[1] = 1.0;
        current_params[2] = 0.5;
        current_params[3] = 0.0;

        old_params[0] = current_params[0] - step[0];
        old_params[1] = current_params[1] - step[1];
        old_params[2] = current_params[2] - step[2];
        old_params[3] = 0;
        
        expResult[0] = 1.0;
        expResult[1] = 0.999;
        expResult[2] = 0.5;
        expResult[3] = 0.0;
        
        result = instance.optimizer(lift_drag, old_lift_drag, old_params, current_params, step, p);
        org.junit.Assert.assertEquals(expResult[0], result[0], 1000);
        org.junit.Assert.assertEquals(expResult[1], result[1], 1000);
        org.junit.Assert.assertEquals(expResult[2], result[2], 0.01);
        org.junit.Assert.assertEquals(expResult[3], result[3], 0.1);
        
        lift_drag = 1.0;
        old_lift_drag = 2.0;
        p = 2;
        
        current_params[0] = 1.0;
        current_params[1] = 1.0;
        current_params[2] = 0.5;
        current_params[3] = 0.0;

        old_params[0] = current_params[0] - step[0];
        old_params[1] = current_params[1] - step[1];
        old_params[2] = current_params[2] - step[2];
        old_params[3] = 0;
        
        expResult[0] = 1.0;
        expResult[1] = 1.0;
        expResult[2] = 0.49999;
        expResult[3] = 0.0;
        
        result = instance.optimizer(lift_drag, old_lift_drag, old_params, current_params, step, p);
        org.junit.Assert.assertEquals(expResult[0], result[0], 1000);
        org.junit.Assert.assertEquals(expResult[1], result[1], 1000);
        org.junit.Assert.assertEquals(expResult[2], result[2], 0.01);
        org.junit.Assert.assertEquals(expResult[3], result[3], 0.1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
