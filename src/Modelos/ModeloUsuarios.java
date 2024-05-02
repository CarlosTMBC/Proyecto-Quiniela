/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author carlt
 */

import java.sql.*;

import Modelos.Usuarios;
import javax.swing.JOptionPane;

/**
 * Clase que maneja la lógica de negocio y las operaciones con la base de datos.
 */
public class ModeloUsuarios {
   Connection MyConexion;
    ResultSet result;
    /**
     * Método para iniciar sesión de usuario.
     * @param nombreUsuario El nombre de usuario.
     * @param contrasena La contraseña del usuario.
     * @return true si la sesión se inicia con éxito, false en caso contrario.
     */
   public void Guardar(String nombre, String apellido,String telefono, String dpi,String Usuario,String pass) throws ClassNotFoundException
{
    try
        {
          Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.conectar();
        Statement sentencia = (Statement) MyConexion.createStatement();
        sentencia.executeQuery("Insert into credenciales values("+"'"+Usuario+"',"+"'"+pass+"')");
        sentencia.executeQuery("Insert into participantes values("+"'"+nombre+"',"+"'"+apellido+"',"+"'"+telefono+"')");
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Guardar..."+ex.getMessage());
        }  
}
}

