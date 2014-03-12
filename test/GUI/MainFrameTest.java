/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

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
     * Test of transform_data_to_plot method, of class MainFrame.
     */
    @Test
    public void testTransform_data_to_plot() {
        System.out.println("transform_data_to_plot");
        double[][] data_from_db = null;
        MainFrame instance = new MainFrame();
        instance.transform_data_to_plot(data_from_db);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawChart method, of class MainFrame.
     */
    @Test
    public void testDrawChart() {
        System.out.println("drawChart");
        MainFrame instance = new MainFrame();
        instance.drawChart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lift method, of class MainFrame.
     */
    @Test
    public void testLift() {
        System.out.println("lift");
        double r = 0.0;
        double t = 0.0;
        double theta = 0.0;
        MainFrame instance = new MainFrame();
        double expResult = 0.0;
        double result = instance.lift(r, t, theta);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drag method, of class MainFrame.
     */
    @Test
    public void testDrag() {
        System.out.println("drag");
        double r = 0.0;
        double t = 0.0;
        double theta = 0.0;
        MainFrame instance = new MainFrame();
        double expResult = 0.0;
        double result = instance.drag(r, t, theta);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of optimizer method, of class MainFrame.
     */
    @Test
    public void testOptimizer() {
        System.out.println("optimizer");
        double lift_drag = 0.0;
        double old_lift_drag = 0.0;
        double[] old_param = null;
        double[] current_param = null;
        double[] step = null;
        int p = 0;
        MainFrame instance = new MainFrame();
        double[] expResult = null;
        double[] result = instance.optimizer(lift_drag, old_lift_drag, old_param, current_param, step, p);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
