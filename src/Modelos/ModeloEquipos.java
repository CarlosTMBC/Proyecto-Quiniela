/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.IOException;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/**
 *
 * @author carlt
 */
public class ModeloEquipos {
    Connection MyConexion;
    ResultSet result;
    public DefaultTableModel ListarEquipos(JComboBox<String> Ligas) throws IOException
    {
        DefaultTableModel TablaModelo = new DefaultTableModel();
        TablaModelo.setRowCount(0);
        TablaModelo.setColumnCount(0);
        TablaModelo.addColumn("N°");
        TablaModelo.addColumn("Equipo");
        String LigaSeleccionada = Ligas.getSelectedItem().toString();

        try
        {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("SELECT Equipos.idEquipo, Equipos.nombre FROM Equipos INNER JOIN Ligas ON Equipos.Liga = Ligas.idLiga WHERE Ligas.Liga =  '"+LigaSeleccionada+"';");


                while(result.next())
                {
                    TablaModelo.addRow(new Object[]{
                        result.getString("idEquipo"),
                        result.getString("nombre")
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
        public  JComboBox<String> listComboBoxItems(JComboBox<String> cmbLigas,JComboBox<String> cmbEquipos) throws IOException
        {
            String LigaSeleccionada = cmbLigas.getSelectedItem().toString();
            cmbEquipos.removeAllItems();
            cmbEquipos.addItem("Eliga Una Opcion");
            

        try
        {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("SELECT Equipos.idEquipo, Equipos.nombre FROM Equipos INNER JOIN Ligas ON Equipos.Liga = Ligas.idLiga WHERE Ligas.Liga =  '"+LigaSeleccionada+"';");
            while(result.next())
            {
                String nombreEquipo = result.getString("nombre");
                cmbEquipos.addItem(nombreEquipo);
            }
            
        }
    
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "No se Pudo Listar ...."+e.getMessage());
    }
    return cmbEquipos;
}
        
        public JComboBox[] DeslistarEquipos(JComboBox<String> cmbEquipo1, JComboBox<String> cmbEquipo2, DefaultTableModel tabla) {
    DefaultComboBoxModel<String> Equipo1 = (DefaultComboBoxModel<String>) cmbEquipo1.getModel();
    DefaultComboBoxModel<String> Equipo2 = (DefaultComboBoxModel<String>) cmbEquipo2.getModel();
    int rowCount = tabla.getRowCount();
    for (int i = 0; i < rowCount; i++) {
        String equipo1 = (String) tabla.getValueAt(i, 1); // Get team from column index 1
        String equipo2 = (String) tabla.getValueAt(i, 3); // Get team from column index 3
        Equipo1.removeElement(equipo1);
        Equipo2.removeElement(equipo1); // Remove the same team from cmbEquipo2
        Equipo1.removeElement(equipo2); // Remove the same team from cmbEquipo1
        Equipo2.removeElement(equipo2);
    }
    cmbEquipo1.setModel(Equipo1);
    cmbEquipo2.setModel(Equipo2);
    return new JComboBox[]{cmbEquipo1, cmbEquipo2};
}

         
         
}
