/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlt
 */
public class ModeloResultadosA {
    
    Connection MyConexion;
    ResultSet result;
    public DefaultTableModel ListarJornadaTabla(JComboBox<String> cmbJornada,JComboBox<String> liga) throws IOException
    {
        DefaultTableModel TablaJornada = new DefaultTableModel();
        TablaJornada.setRowCount(0);
        TablaJornada.setColumnCount(0);
        TablaJornada.addColumn("N°");
        TablaJornada.addColumn("Equipo Local");
        TablaJornada.addColumn("Equipo Visitante");
        TablaJornada.addColumn("Goles Equipo Local");
        TablaJornada.addColumn("Goles Equipo Visitante");
        String JornadaSeleccionada = cmbJornada.getSelectedItem().toString();
        String LigaSeleccionada = liga.getSelectedItem().toString();

        try
        {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("SELECT partidos.idPartido, Ligas.liga AS Liga_Local, " +
            "EquiposLocal.nombre AS Equipo_Local, EquiposVisitante.nombre AS Equipo_Visitante, Jornadas.nJornada " +
            ",partidos.GolesEquipoLocal, partidos.GolesEquipoVisitante FROM partidos " +
            "INNER JOIN Jornadas ON partidos.idJornada = Jornadas.nJornada " +
            "INNER JOIN Equipos AS EquiposLocal ON partidos.idEquipoLocal = EquiposLocal.idEquipo " +
            "INNER JOIN Equipos AS EquiposVisitante ON partidos.idEquipoVisitante = EquiposVisitante.idEquipo " +
            "INNER JOIN Ligas ON partidos.idLiga = Ligas.idLiga " +
            "WHERE Jornadas.nJornada =" + JornadaSeleccionada + " AND Ligas.liga = '" + LigaSeleccionada + "';");
            while(result.next()) {
                TablaJornada.addRow(new Object[]{
                    result.getString("idPartido"),
                    result.getString("Equipo_Local"),
                    result.getString("Equipo_Visitante"),result.getString("GolesEquipoLocal"),
                     result.getString("GolesEquipoVisitante")
                      
                });
            }
            return TablaJornada;
        }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "No se Pudo Listar ...."+e.getMessage());
    }
    return TablaJornada;
    }
    
    
    public void EstablecerResultados(JTable tabla) throws SQLException, IOException {
    
        try
        {
            //String consul = Consulta(cmbJornadas);
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            
            for(int i =0;i<tabla.getRowCount();i++)
            {
                sentencia.executeUpdate("UPDATE partidos SET GolesEquipoLocal = "+tabla.getValueAt(i, 3)+" WHERE idEquipoLocal = "+Equipos((String) tabla.getValueAt(i, 1))+";");
                sentencia.executeUpdate("UPDATE partidos SET GolesEquipoVisitante = "+tabla.getValueAt(i, 4)+" WHERE idEquipoVisitante = "+Equipos((String) tabla.getValueAt(i, 2))+";");

            }            
            //sentencia.executeUpdate(consul);
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Guardar Los partidos..."+ex.getMessage());
        }  
}

    
        public String Equipos(String equipo) throws IOException{
        String idEquipo ="";
        try{
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("SELECT Equipos.idEquipo FROM Equipos WHERE Equipos.nombre =  '"+equipo+"';");
            while(result.next()){
                idEquipo=result.getString("idEquipo");
            }
        }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No se Pudo Listar ...."+e.getMessage());
    }
    return idEquipo;
}
    
    
    
}
