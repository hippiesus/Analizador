/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author juancarlos
 */
public class Analisis {

    public Map<String, Integer> detectarDefectos(String ubicacionArchivos) {
        Map<String, Integer> mapa = new HashMap<String, Integer>();
        Grafo grafo = new Grafo();
        File archivo = new File(ubicacionArchivos);
        ArrayList<Nodo> lista = grafo.crearGrafo(ubicacionArchivos, archivo.list());
        System.out.println(lista.size());

        for (int x = 0; x < lista.size(); x++) {
            //valida que solo sean archivos .sql
            String ext=lista.get(x).getPrograma().substring(lista.get(x).getPrograma().length()-3,lista.get(x).getPrograma().length());
            System.out.println("Extencion"+ext);                    
            if(ext.equals("sql")){
                analizarNodo(lista.get(x));
            }

        }
        return mapa;

    }

    public Map<String, Integer> analizarNodo(Nodo nodo) {

        Map<String, Integer> mapa = new HashMap<String, Integer>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            archivo = new File(nodo.getPrograma());
            System.out.println(archivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                Pattern p = Pattern.compile("open");
                Matcher m = p.matcher(linea);
                if (m.find()) {
                    System.out.println("DEFECTO ENCONTRADO");
                    System.out.println(linea);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }


        return mapa;
    }

    public boolean generarXML(String usuario, String ubicacionArchivos, int cantidadDefectos, int cantidadDefectosBajo, int cantidadDefectosMedio, int cantidadDefectosCritico) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "xml", null);
            Element raiz = document.createElement("UltimaEjecucion");

            Element fechaElem = document.createElement("fecha");
            Text textFecha = document.createTextNode(new Date().toString());


            Element usuarioElem = document.createElement("usuario");
            Text text = document.createTextNode(usuario);

            Element ubicacionElem = document.createElement("ubicacionArchivos");
            Text textUb = document.createTextNode(ubicacionArchivos);

            Element cantDefElem = document.createElement("cantidadDefectos");
            Text textCd = document.createTextNode(String.valueOf(cantidadDefectos));

            Element cantDefBElem = document.createElement("cantidadDefectosBajo");
            Text textCdb = document.createTextNode(String.valueOf(cantidadDefectosBajo));

            Element cantDefMElem = document.createElement("cantidadDefectosMedio");
            Text textCdm = document.createTextNode(String.valueOf(cantidadDefectosMedio));

            Element cantDefCElem = document.createElement("cantidadDefectosCritico");
            Text textCdc = document.createTextNode(String.valueOf(cantidadDefectosCritico));

            document.getDocumentElement().appendChild(raiz);

            raiz.appendChild(fechaElem);
            raiz.appendChild(usuarioElem);
            raiz.appendChild(ubicacionElem);
            raiz.appendChild(cantDefElem);
            raiz.appendChild(cantDefBElem);
            raiz.appendChild(cantDefMElem);
            raiz.appendChild(cantDefCElem);

            fechaElem.appendChild(textFecha);
            usuarioElem.appendChild(text);
            ubicacionElem.appendChild(textUb);
            cantDefElem.appendChild(textCd);
            cantDefBElem.appendChild(textCdb);
            cantDefMElem.appendChild(textCdc);
            cantDefCElem.appendChild(textCdc);



            document.setXmlVersion("1.0");
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("defectos.xml"));
            Result console = new StreamResult(System.out);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            transformer.transform(source, console);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }
}
