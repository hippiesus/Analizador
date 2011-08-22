/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

/**
 *
 * @author juancarlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Analisis analisis = new Analisis();
        if (args.length != 0) { // valida que se le pase la ruta
            args[0] = args[0].replace("\"", "");// cuando hay espacio en las rutas utilizan ""
            if (!args[0].substring(args[0].length() - 2, args[0].length()).contains("/")) {
                args[0] = args[0] + System.getProperty("file.separator");
            }
            System.out.println("Los archivos se buscaran en:" + args[0]);
            analisis.detectarDefectos(args[0]);

        }

    }
}
