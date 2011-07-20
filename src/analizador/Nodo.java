/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.util.LinkedList;
/**
 *
 * @author juancarlos
 */
public class Nodo {
    private  String programa;
    
    LinkedList<Nodo> llamadas= new LinkedList<Nodo>();
    /**
     * @return the programa
     */
    public String getPrograma() {
        return programa;
    }

    /**
     * @param programa the programa to set
     */
    public void setPrograma(String programa) {
        this.programa = programa;
    }
    
}
