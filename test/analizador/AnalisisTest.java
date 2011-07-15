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
public class AnalisisTest {
    
    public AnalisisTest() {
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
     * Test of detectarDefectos method, of class Analisis.
     */
    @Test
    public void testDetectarDefectos() {
        System.out.println("detectarDefectos");
        String ubicacionArchivos = "";
        Analisis instance = new Analisis();
        int expResult = 0;
        instance.detectarDefectos(ubicacionArchivos);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analizarNodo method, of class Analisis.
     */
    @Test
    public void testAnalizarNodo() {
        System.out.println("analizarNodo");
        Nodo nodo = null;
        Analisis instance = new Analisis();
        instance.analizarNodo(nodo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarXML method, of class Analisis.
     */
    @Test
    public void testGenerarXML() {
        System.out.println("generarXML");
        String usuario = "";
        String ubicacionArchivos = "/Users/juancarlos/tmp";
        int cantidadDefectos = 0;
        int cantidadDefectosBajo = 0;
        int cantidadDefectosMedio = 0;
        int cantidadDefectosCritico = 0;
        Analisis instance = new Analisis();
        boolean expResult = true;
        boolean result = instance.generarXML(usuario, ubicacionArchivos, cantidadDefectos, cantidadDefectosBajo, cantidadDefectosMedio, cantidadDefectosCritico);
        assertEquals(expResult, result);
    }
}
