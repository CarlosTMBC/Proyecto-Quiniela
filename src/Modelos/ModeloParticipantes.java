/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.IOException;
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
    public void Guardar(int id, String nombre, String apellidos, String usuario, String pass, String telefono, String dpi) throws IOException
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
    
    public int  numeroRegistros() throws IOException{
        int numeroRegistros = 0;
        try {
            
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            String consulta = "SELECT COUNT(*) AS NumeroDeRegistros FROM participantes;";
            result = sentencia.executeQuery(consulta);
                
                
                if (result.next()) {
                    numeroRegistros = result.getInt("NumeroDeRegistros");
                }
                System.out.println("El número de registros en la tabla es: " + numeroRegistros);
                
            }
             catch (SQLException e) {
                 System.out.println("algo salio mal");
        }
        return numeroRegistros;
    }
        public DefaultTableModel ListarParticipantes() throws IOException
        {
        DefaultTableModel TablaModelo = new DefaultTableModel();
        TablaModelo.setRowCount(0);
        TablaModelo.setColumnCount(0);
        TablaModelo.addColumn("Codigo");
        TablaModelo.addColumn("Nombre");
        TablaModelo.addColumn("Apellidos");

        try
        {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("SELECT p.idParticipante, p.nombre, p.apellido " +"FROM credenciales c " + "INNER JOIN participantes p ON c.idUser = p.idParticipante");


                while(result.next())
                {
                    TablaModelo.addRow(new Object[]{
                        result.getString("idParticipante"),
                        result.getString("nombre"),
                        result.getString("apellido")
                    });
                }
            return TablaModelo;
        }
    
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "No se Pudo Listar ...."+e.getMessage());
    }
    return TablaModelo;
}
        
}

