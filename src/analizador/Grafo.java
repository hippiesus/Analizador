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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        try {
            for (int i = 0; i < archivos.length; i++) {// para todos los archivos
                String nombreArchivo = ubicacionArchivos + archivos[i];
                //  System.out.println("funcion a buscar" + nombreArchivo);
                String nombreFuncion = archivos[i].substring(0, archivos[i].length() - 4);
                llamadas = new LinkedList<Nodo>();

                for (int x = 0; x < archivos.length; x++) { // con todos los otros , incluyendose
                    archivo = new File(ubicacionArchivos + archivos[x]);

                    if (archivo.isFile()) {
                        fr = new FileReader(archivo);
                        br = new BufferedReader(fr);

                        while ((linea = br.readLine()) != null) { // para cada linea del archivo
//                        System.out.println(linea);
                            numLinea++;

                            Pattern p = Pattern.compile(nombreFuncion, Pattern.CASE_INSENSITIVE);
                            Matcher m = p.matcher(linea);
                            if (m.find()) {
                                //   System.out.println("encontro " + p.toString() + " en " + ubicacionArchivos + archivos[x]);
                                String programa = ubicacionArchivos + archivos[x];
                                if (!llamadas.isEmpty()) {
                                    for (int j = 0; j < llamadas.size(); j++) {
                                        //  System.out.println("");
                                        if (!programa.equals(llamadas.get(j).getPrograma())) {
                                            //     System.out.println("aaaaaaaaa");
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
                //System.out.println("size" + lista.size());
                Nodo n = new Nodo();
                n.setPrograma(nombreArchivo);
                n.setLlamadas(llamadas);
                lista.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
