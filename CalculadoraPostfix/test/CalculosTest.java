/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea Arguello
 * @author Sergio Marchena 
 * @since 2/02/2018
 */
public class CalculosTest {
    
    public CalculosTest() {
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
     * Test of operar method, of class Calculos.
     */
    @Test
    public void testOperar() {
        System.out.println("operar");
        String expresion = "1 2 + 4 * 3 + 1 + 1 +";
        Calculos instance = new Calculos();
        double expResult = 17.0;
        double result = instance.operar(expresion);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult) {
            fail("The test case is a prototype.");
        }
    }

    
}
