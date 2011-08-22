/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author juancarlos
 */
public class Nodo {
    private  String programa;
    
    private List<Nodo> relaciones= new LinkedList<Nodo>();
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
    public List<Nodo> getLlamadas() {
        return relaciones;
    }

    /**
     * @param llamadas the llamadas to set
     */
    public void setLlamadas(List<Nodo> llamadas) {
        this.relaciones = llamadas;
    }
    
}
