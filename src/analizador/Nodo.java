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
    
    private LinkedList<Nodo> llamadas= new LinkedList<Nodo>();
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

    /**
     * @return the llamadas
     */
    public LinkedList<Nodo> getLlamadas() {
        return llamadas;
    }

    /**
     * @param llamadas the llamadas to set
     */
    public void setLlamadas(LinkedList<Nodo> llamadas) {
        this.llamadas = llamadas;
    }
    
}
