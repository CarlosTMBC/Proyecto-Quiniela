/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlt
 */
public class ModeloParticipantes {
    Connection MyConexion;
    ResultSet result;
    public void Guardar(int id, String nombre, String apellidos, String usuario, String pass, String telefono, String dpi)
{
    try
        {
          Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.conectar();
        Statement sentencia = MyConexion.createStatement();
        sentencia.executeUpdate("INSERT INTO participantes VALUES (" + id + ", '" + nombre + "', '" + apellidos + "', '" + telefono + "', '" + dpi + "')");
        
        sentencia.executeUpdate("INSERT INTO credenciales (usuario, contrasena, idUser) VALUES ('" + usuario + "', '" + pass + "', " + id + ")");

        JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
        
        }
    
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Guardar..."+ex.getMessage());
        }  
}
}
