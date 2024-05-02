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
public class ModeloQuiniela {
    Connection MyConexion;
    ResultSet result;
    
public DefaultTableModel ListarDatosConsulta()  {
    DefaultTableModel TablaModelo = new DefaultTableModel();
    TablaModelo.setRowCount(0);
    TablaModelo.setColumnCount(0);
    
    TablaModelo.addColumn("Equipo Local");
    TablaModelo.addColumn("Equipo Visitante");
    TablaModelo.addColumn("Fecha");
    TablaModelo.addColumn("Liga");
    TablaModelo.addColumn("Jornada");

    try {
        Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.conectar(); // Aquí inicializas MyConexion con una conexión válida

        if (MyConexion != null) {
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("select * from Partidos");
            
            while(result.next()) {
                TablaModelo.addRow(new Object[]{
                    result.getString("eLocal"),
                    result.getString("eVisitante"),
                    result.getDate("fecha"),
                    result.getString("liga"),
                    result.getString("jornada")
                });
            }
            JOptionPane.showMessageDialog(null, "ListadoCorrectamente");
            return TablaModelo;
        } else {
            JOptionPane.showMessageDialog(null, "La conexión a la base de datos es nula.");
        }
    } catch(SQLException e) {
        JOptionPane.showMessageDialog(null, "No se Pudo Listar Empleados...."+e.getMessage());
    }
    return TablaModelo;
}

public DefaultTableModel DatosCategorias()
{
    DefaultTableModel TablaModelo = new DefaultTableModel();
    TablaModelo.setRowCount(0);
    TablaModelo.setColumnCount(0);
    TablaModelo.addColumn("Equipo Local");
    TablaModelo.addColumn("Equipo Visitante");
    TablaModelo.addColumn("Fecha");
    TablaModelo.addColumn("Liga");
    TablaModelo.addColumn("Jornada");

    try
    {
        Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.conectar();
        Statement sentencia = MyConexion.createStatement();
        result = sentencia.executeQuery("select * from Partidos");
        
        
            while(result.next())
            {
                TablaModelo.addRow(new Object[]{
                 result.getString("eLocal"),
                    result.getString("eVisitante"),
                    result.getDate("fecha"),
                    result.getString("liga"),
                    result.getString("jornada")
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
