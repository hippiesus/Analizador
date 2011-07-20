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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author juancarlos
 */
public class Analisis {
    
    final String delimitador = ":";
    static final String identificadorOracle = "[A-Za-z0-9._\\$#]+"; // doble \\ por ser caracter especial para java
    
    public Map<String, Integer> detectarDefectos(String ubicacionArchivos) {
        Map<String, Integer> mapa = new HashMap<String, Integer>();
        Grafo grafo = new Grafo();
        File archivo = new File(ubicacionArchivos);
        ArrayList<Nodo> lista = grafo.crearGrafo(ubicacionArchivos, archivo.list());
        
        for (int x = 0; x < lista.size(); x++) {
            //valida que solo sean archivos .sql
            String ext = lista.get(x).getPrograma().substring(lista.get(x).getPrograma().length() - 3, lista.get(x).getPrograma().length());
            //  System.out.println("Extencion" + ext);
            if (ext.equals("sql")) {
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
        ArrayList<PatronDefecto> pd = obtenerPatrones();
        
        try {
            
            archivo = new File(nodo.getPrograma());
            //  System.out.println(archivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            String linea;
            int numLinea = 0;
            int critico = 0;
            int numLineaInicio = -1;
            int numLineaFinal = -1;
            
            
            for (int x = 0; x < pd.size(); x++) { // para todos los patrones
                String patron = pd.get(x).getNombre();
                while ((linea = br.readLine()) != null) { // para cada linea del archivo
                    
                    numLinea++;
                    if (patron.contains("identificador")) {
                   
                        String patronR = patron.replaceAll("identificador",identificadorOracle);

                        if (patronR.contains(delimitador)) {
                            
                            int delimitadorPosicion = patronR.indexOf(delimitador);
                            String inicio = patronR.substring(0, delimitadorPosicion);
                            String fin = patronR.substring(delimitadorPosicion + 1, patronR.length());
                            
                            Pattern p = Pattern.compile(inicio);
                            Matcher m = p.matcher(linea);
                            if (m.find()) {
                                System.out.println("count inicio" + m.groupCount());
                                System.out.println(m.group(1));
                                numLineaInicio = numLinea;
                            }
                            Pattern pf = Pattern.compile(fin);
                            Matcher mf = pf.matcher(linea);
                            if (mf.find()) {
                                System.out.println("count fin" + mf.groupCount());
                                numLineaFinal = numLinea;
                                System.out.println(mf.group(1));
                            }
                            
                            
                        } else {
                            Pattern p = Pattern.compile(pd.get(x).getNombre());
                            Matcher m = p.matcher(linea);
                            if (m.find()) {
                                mapa.put("critico", critico++);
                                System.out.println("DEFECTO ENCONTRADO");
                                System.out.println("NUMERO DE LINEA" + numLinea + "\n" + linea);
                            }
                            
                        }
                        
                    }
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
    
    public ArrayList<PatronDefecto> obtenerPatrones() {
        
        ArrayList<PatronDefecto> p = new ArrayList<PatronDefecto>();
        try {
            
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File("patrones.xml"));
            
            doc.getDocumentElement().normalize();
            
            NodeList listBloqueos = doc.getElementsByTagName("patron");
            int totalBloqueos = listBloqueos.getLength();
            //  System.out.println("Total de PATRONES : " + totalBloqueos);

            for (int s = 0; s < listBloqueos.getLength(); s++) {
                
                Node patron = listBloqueos.item(s);
                if (patron.getNodeType() == Node.ELEMENT_NODE) {
                    
                    Element pa = (Element) patron;
                    PatronDefecto pd = new PatronDefecto();
                    // -------
                    NodeList identificador = pa.getElementsByTagName("identificador");
                    Element identificadorElement = (Element) identificador.item(0);
                    
                    NodeList identificadorList = identificadorElement.getChildNodes();
                    if (((Node) identificadorList.item(0)) != null) {
                        pd.setIdentificador(Integer.parseInt(((Node) identificadorList.item(0)).getNodeValue().trim()));
                    }

                    // -------
                    NodeList nombre = pa.getElementsByTagName("nombre");
                    Element nombreElement = (Element) nombre.item(0);
                    
                    NodeList nombreList = nombreElement.getChildNodes();
                    if (((Node) nombreList.item(0)) != null) {
                        pd.setNombre(((Node) nombreList.item(0)).getNodeValue().trim());
                        
                    }
                    // ----
                    NodeList clasificacion = pa.getElementsByTagName("clasificacion");
                    Element clasificacionElement = (Element) clasificacion.item(0);
                    
                    NodeList clasificacionList = clasificacionElement.getChildNodes();
                    if (((Node) clasificacionList.item(0)) != null) {
                        pd.setClasificacion(((Node) clasificacionList.item(0)).getNodeValue().trim());
                    }

                    // ----
                    NodeList descripcion = pa.getElementsByTagName("descripcion");
                    Element descripcionElement = (Element) descripcion.item(0);
                    
                    NodeList descripcionList = descripcionElement.getChildNodes();
                    if (((Node) descripcionList.item(0)) != null) {
                        pd.setDescripcion(((Node) descripcionList.item(0)).getNodeValue().trim());
                    }
                    
                    p.add(pd);
                    
                }
                
            }
            
        } catch (Exception ex) {
        }
        return p;
        
    }
}
