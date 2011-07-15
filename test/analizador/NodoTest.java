/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juancarlos
 */
public class NodoTest {
    
    public NodoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPrograma method, of class Nodo.
     */
    @Test
    public void testGetPrograma() {
        System.out.println("getPrograma");
        Nodo instance = new Nodo();
        String expResult = "";
        String result = instance.getPrograma();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrograma method, of class Nodo.
     */
    @Test
    public void testSetPrograma() {
        System.out.println("setPrograma");
        String programa = "";
        Nodo instance = new Nodo();
        instance.setPrograma(programa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
