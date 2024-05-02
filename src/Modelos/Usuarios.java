/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author carlt
 */
public class Usuarios {
    /**
 * Clase que representa los datos del usuario.
 */

    private String nombreUsuario;
    private String contrasena;

    /**
     * Constructor de la clase Usuario.
     * @param nombreUsuario El nombre de usuario.
     * @param contrasena La contraseña del usuario.
     */
    public Usuarios(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    /**
     * Método getter para el nombre de usuario.
     * @return El nombre de usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Método setter para el nombre de usuario.
     * @param nombreUsuario El nuevo nombre de usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Método getter para la contraseña.
     * @return La contraseña.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Método setter para la contraseña.
     * @param contrasena La nueva contraseña.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}


