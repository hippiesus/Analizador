/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

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
        String ubicacionArchivos = "";
        boolean exp;
        Analisis instance = new Analisis();
        Map<String,Integer> mapa=instance.detectarDefectos(ubicacionArchivos);
        if(mapa.size()==2){
            exp=true;
        }else{
            exp=false;
        }
        
        assertTrue(exp);
    }

    /**
     * Test of analizarNodo method, of class Analisis.
     */
    @Test
    public void testAnalizarNodo() {
        System.out.println("analizarNodo");
        Nodo nodo = new Nodo();
        nodo.setPrograma("/Users/juancarlos/tmp/archivo.sql");
        Analisis instance = new Analisis();
        Map<String,Integer> mapa=instance.analizarNodo(nodo);
        assertEquals(1, mapa.size());
        
    }

    /**
     * Test of generarXML method, of class Analisis.
     */
    @Test
    public void testGenerarXML() {
        System.out.println("generarXML");
        String usuario = "";
        String ubicacionArchivos = "/Users/juancarlos/tmp/";
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
