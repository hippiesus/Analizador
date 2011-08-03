/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;


import java.util.List;
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
        assertEquals(1,critico);
        assertEquals(7,medio);
        assertEquals(0,bajo);
        
        
    }
   
    @Test
    public void testAnalizarCierre() {
        System.out.println("analizarCierre");
        String patron="close (identificador)";
        String ident="c1";               
        String programa="/Users/juancarlos/tmp/findcourse.sql";
        Analisis instance = new Analisis();
        int res=instance.analizarCierre(ident, patron,programa);
        assertEquals(16,res);
        
    }

    /**
     * Test of generarXML method, of class Analisis.
     */
    @Test
    public void testGenerarXML() {
        System.out.println("generarXML");
        Analisis instance = new Analisis();
        ArrayList<Nodo> lista = new ArrayList<Nodo>();
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
        List result = instance.obtenerPatrones();
        assertEquals(3, result.size());
    }
    
}
