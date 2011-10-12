/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.util.List;
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
        String[] archivos = {"funcion1.sql", "funcion2.sql","archivoNoValido.txt"};
        String ubicacionArchivos = "/Users/juancarlos/tmp/";
        Grafo instance = new Grafo();
        List<Nodo> result = instance.crearGrafo(ubicacionArchivos, archivos, null);

        for (int y = 0; y < result.size(); y++) {
            System.out.println("archivo " + y + " " + result.get(y).getPrograma());
            for (int x = 0; x < result.get(y).getLlamadas().size(); x++) {
                System.out.println("archivo" + result.get(y).getPrograma() + " llama a " + result.get(y).getLlamadas().get(x).getPrograma());
            }
        }

    }
}
