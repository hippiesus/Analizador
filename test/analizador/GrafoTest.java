/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.util.ArrayList;
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
public class GrafoTest {
    
    public GrafoTest() {
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
     * Test of crearGrafo method, of class Grafo.
     */
    @Test
    public void testCrearGrafo() {
        System.out.println("crearGrafo");
        String[] archivos = null;
        Grafo instance = new Grafo();
        ArrayList expResult = null;
        ArrayList result = instance.crearGrafo(archivos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
