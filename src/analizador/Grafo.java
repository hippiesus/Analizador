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

    public List<Nodo> crearGrafo(String ubicacionArchivos, String[] archivos, String pack) {
        /*analizara el nombre de un archivo y lo buscara dentro de su archivo y de otros */
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        int numLinea = 0;
        List<Nodo> llamadas;
        List<Nodo> lista = new ArrayList<Nodo>();
        boolean comentario = false;
        List<String> archivosFiltrados = new ArrayList<String>();

        try {

            log.info("Tamaño lista " + archivos.length);
            log.info("Filtrando Archivos SQL");

            for (int x = 0; x < archivos.length; x++) {
                //valida que solo sean archivos .sql
                String ext = archivos[x].substring(archivos[x].length() - 3, archivos[x].length());

                if (ext.equals("sql") || !archivos[x].contains(".")) {
                    archivosFiltrados.add(archivos[x]);
                }
            }
            log.info("Tamaño lista filtrada " + archivosFiltrados.size());

            for (int i = 0; i < archivosFiltrados.size(); i++) {// para todos los archivos

                String nombreArchivo = ubicacionArchivos + archivosFiltrados.get(i);
                log.info("Nombre Archivo " + nombreArchivo);

                llamadas = new LinkedList<Nodo>();

                for (int x = 0; x < archivosFiltrados.size(); x++) { // con todos los otros , incluyendose
                    archivo = new File(ubicacionArchivos + archivosFiltrados.get(i));
                    log.info("file " + archivo.toString());
                    String nombreFuncion = archivosFiltrados.get(x).substring(0, archivosFiltrados.get(x).length() - 4);// le quita la extension
                    if (pack != null) {
                        nombreFuncion = pack + "." + nombreFuncion;
                    }
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
                            }
                            if (linea.contains("*/")) {
                                comentario = false;
                            }

                            if (comentario) {
                                continue;
                            }



                            if (!(linea.toLowerCase().contains("create") || linea.toLowerCase().contains("replace"))) {
                                //no considera la declaracion de la funcion , procedimiento o trigger

                                if (linea.toLowerCase().contains(nombreFuncion.toLowerCase())) { // se busca en la linea el nombre de la funcion

                                    log.info("encontro " + nombreFuncion + " en " + ubicacionArchivos + archivosFiltrados.get(x));

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
                    } else if (archivo.isDirectory()) {
                        log.info("Es directorio " + archivo.toString());
                        File f = new File(archivo.toString());
                        lista.addAll(crearGrafo(archivo.toString() + "/", f.list(), archivo.getName().toString()));
                        List<String> n = new ArrayList<String>();
                        n.add(archivosFiltrados.get(x));
                        archivosFiltrados.removeAll(n); // solo 1 remove no elimina todo

                    }
                }
                Nodo n = new Nodo();
                n.setPrograma(nombreArchivo);
                n.setLlamadas(llamadas);
                lista.add(n);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return lista;
    }
}
