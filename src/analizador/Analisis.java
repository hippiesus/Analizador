/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author juancarlos
 */
public class Analisis {

    public int detectarDefectos(String ubicacionArchivos) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        Grafo grafo = new Grafo();

        archivo = new File(ubicacionArchivos);
        ArrayList<Nodo> lista = grafo.crearGrafo(archivo.list());
        System.out.println(lista.size());
        for (int x = 0; x < lista.size(); x++) {
            try {
                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).
                archivo = new File(ubicacionArchivos + "/" + lista.get(x).getPrograma());
                System.out.println(archivo);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);

                // Lectura del fichero
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // En el finally cerramos el fichero, para asegurarnos
                // que se cierra tanto si todo va bien como si salta 
                // una excepcion.
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

        }
        return 0;

    }

    public void analizarNodo(Nodo nodo) {
    }

    public boolean generarXML(String usuario, String ubicacionArchivos, int cantidadDefectos, int cantidadDefectosBajo, int cantidadDefectosMedio, int cantidadDefectosCritico) {

        return true;
    }
}
