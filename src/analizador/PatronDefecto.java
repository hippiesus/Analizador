/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

/**
 *
 * @author juancarlos
 */
public class PatronDefecto {
    private String identificador;
    private String nombre;
    private String clasificacion;
    private String descripcion;

    public PatronDefecto(String identificador, String nombre, String clasificacion, String descripcion) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.descripcion = descripcion;
    }

    
    
    /**
     * @return the identificador
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the clasificacion
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
            
    
}