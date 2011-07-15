/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.util.Scanner;

/**
 *
 * @author juancarlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Analisis analisis= new Analisis();
        String ubicacionArchivos = args[0];
        System.out.println("Los archivos se buscaran en:"+ ubicacionArchivos);
        analisis.detectarDefectos(ubicacionArchivos);
        
    }
}
