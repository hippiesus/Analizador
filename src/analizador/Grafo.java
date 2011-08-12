/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author juancarlos
 */
public class Grafo {

    private final static Logger log = Logger.getLogger(Grafo.class);

    public Grafo() {
        BasicConfigurator.configure();

    }

    public List<Nodo> crearGrafo(String ubicacionArchivos, String[] archivos) {
        /*analizara el nombre de un archivo y lo buscara dentro de su archivo y de otros */
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        int numLinea = 0;
        List<Nodo> llamadas;//= new LinkedList<Nodo>();
        List<Nodo> lista = new ArrayList<Nodo>();
        boolean comentario = false;

        try {

            for (int i = 0; i < archivos.length; i++) {// para todos los archivos

                String nombreArchivo = ubicacionArchivos + archivos[i];
                log.info("Nombre Archivo " + nombreArchivo);

                llamadas = new LinkedList<Nodo>();

                for (int x = 0; x < archivos.length; x++) { // con todos los otros , incluyendose
                    archivo = new File(ubicacionArchivos + archivos[i]);
                    log.info("file "+archivo.toString());
                    String nombreFuncion = archivos[x].substring(0, archivos[x].length() - 4);// le quita la extension
                    log.info("Nombre Funcion " + nombreFuncion);
                    
                    if (archivo.isFile()) {
                        fr = new FileReader(archivo);
                        br = new BufferedReader(fr);

                        while ((linea = br.readLine()) != null) { // para cada linea del archivo

                            numLinea++;
                            if (linea.contains("--")) { // valida de que la  linea a analizar no sea comentario de solo 1 linea
                                continue;
                            }
                            if (linea.contains("/*") && linea.contains("*/")) {
                                continue;
                            }
                            if (linea.contains("/*")) {  /* validacion comentarios multiples*/
                                comentario = true;
                                System.out.println("apertura");
                            }
                            if (linea.contains("*/")) {
                                comentario = false;
                            }

                            if (comentario) {
                                System.out.println("comentario");
                                continue;
                            }



                            if (!(linea.toLowerCase().contains("create") || linea.toLowerCase().contains("replace"))) {
                                //no considera la declaracion de la funcion , procedimiento o trigger
                                if (linea.toLowerCase().contains(nombreFuncion.toLowerCase())) { // se busca en la linea el nombre de la funcion
                                    
                                    log.info("encontro " + nombreFuncion + " en " + ubicacionArchivos + archivos[x]);

                                    String programa = ubicacionArchivos + nombreFuncion + ".sql";
                                    if (!llamadas.isEmpty()) {
                                        for (int j = 0; j < llamadas.size(); j++) {
  
                                            if (!programa.equals(llamadas.get(j).getPrograma())) {

                                                Nodo n = new Nodo();
                                                n.setPrograma(programa);
                                                llamadas.add(n);
                                            }
                                        }
                                    } else {

                                        Nodo n = new Nodo();
                                        n.setPrograma(programa);
                                        llamadas.add(n);
                                    }

                                }

                            }
                        }
                    }
                }
                Nodo n = new Nodo();
                n.setPrograma(nombreArchivo);
                n.setLlamadas(llamadas);
                lista.add(n);
            }
        } catch (Exception e) {
        }
        return lista;
    }
}
