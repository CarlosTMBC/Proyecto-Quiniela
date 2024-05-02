/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author carlt
 */
public class Participantes {
    /**
 * Clase que representa un participante en la base de datos.
 */

    private String nombre;
    private String apellido;
    private String telefono;
    private String dpi;

    /**
     * Constructor de la clase Participante.
     * @param nombre El nombre del participante.
     * @param apellido El apellido del participante.
     * @param telefono El teléfono del participante.
     * @param dpi El DPI (Documento Personal de Identificación) del participante.
     */
    public Participantes(String nombre, String apellido, String telefono, String dpi) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dpi = dpi;
    }

    /**
     * Método getter para el nombre del participante.
     * @return El nombre del participante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método setter para el nombre del participante.
     * @param nombre El nuevo nombre del participante.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getter para el apellido del participante.
     * @return El apellido del participante.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Método setter para el apellido del participante.
     * @param apellido El nuevo apellido del participante.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Método getter para el teléfono del participante.
     * @return El teléfono del participante.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método setter para el teléfono del participante.
     * @param telefono El nuevo teléfono del participante.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método getter para el DPI del participante.
     * @return El DPI del participante.
     */
    public String getDpi() {
        return dpi;
    }

    /**
     * Método setter para el DPI del participante.
     * @param dpi El nuevo DPI del participante.
     */
    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    
}


