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
        String[] archivos = {"archivo.sql", "archivo2.sql"};
        String ubicacionArchivos="/Users/juancarlos/tmp/";
        Grafo instance = new Grafo();
        ArrayList result = instance.crearGrafo(ubicacionArchivos,archivos);
        assertEquals(2,result.size());
                
    }
}
