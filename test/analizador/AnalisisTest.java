/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 9a5c562ecb70c670dd959f045680580265297e74
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
   // @Test
    public void testDetectarDefectos() {
        System.out.println("detectarDefectos");
<<<<<<< HEAD
        String ubicacionArchivos = "/Users/juancarlos/tmp/";
<<<<<<< HEAD
=======
        boolean exp;
>>>>>>> patrones
        Analisis instance = new Analisis();
        Map<String,Integer> mapa=instance.detectarDefectos(ubicacionArchivos);
=======
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
>>>>>>> 9a5c562ecb70c670dd959f045680580265297e74
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
        
<<<<<<< HEAD
    }
   
    @Test
    public void testAnalizarCierre() {
        System.out.println("analizarCierre");
        String patron="close\\s+([A-Za-z0-9._$#]+)";
        String ident="c1";               
        String programa="/Users/juancarlos/tmp/archivo.sql";
        Analisis instance = new Analisis();
        int res=instance.analizarCierre(ident, patron,programa);
        assertEquals(14,res);
        
=======
>>>>>>> 9a5c562ecb70c670dd959f045680580265297e74
    }

    /**
     * Test of generarXML method, of class Analisis.
     */
  //  @Test
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
<<<<<<< HEAD
   // @Test
=======
        /**
     * Test of obtenerPatrones method, of class Analisis.
     */
    @Test
>>>>>>> patrones
    public void testObtenerPatrones() {
        System.out.println("obtenerPatrones");
        Analisis instance = new Analisis();
        ArrayList result = instance.obtenerPatrones();
<<<<<<< HEAD
        assertEquals(1,result.size());
    }
=======
        assertEquals(1, result.size());
    }
    
>>>>>>> patrones
}
