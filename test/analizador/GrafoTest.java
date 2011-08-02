/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.util.List;
import java.util.LinkedList;
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
        String[] archivos = {"archivo2.sql", "findcourse.sql"};
        String ubicacionArchivos = "/Users/juancarlos/tmp/";
        Grafo instance = new Grafo();
        List<Nodo> result = instance.crearGrafo(ubicacionArchivos, archivos);
        List<Nodo> llamadas1 = result.get(0).getLlamadas();
        List<Nodo> llamadas2 = result.get(1).getLlamadas();

        assertEquals(2, result.size());
        assertEquals(1, llamadas1.size());
        assertEquals(1, llamadas2.size());
        for (int x = 0; x < llamadas1.size(); x++) {
            System.out.println(llamadas1.get(x).getPrograma());
        }
        for (int x = 0; x < llamadas2.size(); x++) {
            System.out.println(llamadas2.get(x).getPrograma());
        }

    }
}
