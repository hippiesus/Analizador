/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.io.File;
import java.util.ArrayList;


/**
 *
 * @author juancarlos
 */
public class Grafo {

    public ArrayList<Nodo> crearGrafo(String ubicacionArchivos,String[] archivos) {

        ArrayList<Nodo> lista= new ArrayList<Nodo>();

            for (int x = 0; x < archivos.length; x++) {
                lista.add(new Nodo());
                lista.get(x).setPrograma(ubicacionArchivos+archivos[x]);
            }
       return lista; 
    }
}
