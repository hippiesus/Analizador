/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;


import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
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
        String ubicacionArchivos = "/Users/juancarlos/tmp/";
        boolean exp;
        Analisis instance = new Analisis();
        instance.detectarDefectos(ubicacionArchivos);
    }

    /**
     * Test of analizarNodo method, of class Analisis.
     */
    @Test
    public void testAnalizarNodo() {
        System.out.println("analizarNodo");
        Nodo nodo = new Nodo();
        nodo.setPrograma("/Users/juancarlos/tmp/findcourse.sql");
        Analisis instance = new Analisis();
        Map<String,Integer> mapa=instance.analizarNodo(nodo);
        assertEquals(3, mapa.size());
        int critico=mapa.get("critico");
        int medio=mapa.get("medio");
        int bajo=mapa.get("bajo");
        assertEquals(3,critico);
        assertEquals(1,medio);
        assertEquals(4,bajo);
        
        
    }
   
    @Test
    public void testAnalizarCierre() {
        System.out.println("analizarCierre");
        String patron="close\\s+([A-Za-z0-9._$#]+)";
        String ident="c1";               
        String programa="/Users/juancarlos/tmp/findcourse.sql";
        Analisis instance = new Analisis();
        int res=instance.analizarCierre(ident, patron,programa);
        assertEquals(14,res);
        
    }

    /**
     * Test of generarXML method, of class Analisis.
     */
    @Test
    public void testGenerarXML() {
        System.out.println("generarXML");
        Analisis instance = new Analisis();
        ArrayList<String> lista = new ArrayList<String>();
        HashMap<String,Integer> mapa= new HashMap<String, Integer>(); 
        boolean exp=instance.generarXML(mapa, lista);
        assertTrue(exp);
    }
        /**
     * Test of obtenerPatrones method, of class Analisis.
     */
    @Test
    public void testObtenerPatrones() {
        System.out.println("obtenerPatrones");
        Analisis instance = new Analisis();
        ArrayList result = instance.obtenerPatrones();
        assertEquals(4, result.size());
    }
    
}
