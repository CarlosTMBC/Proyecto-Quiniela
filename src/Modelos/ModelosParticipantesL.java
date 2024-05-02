/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlt
 */
public class ModelosParticipantesL {
    Connection MyConexion;
    ResultSet result;
    public DefaultTableModel ListarParticipantes()
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
