/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author carlt
 */
public class ModeloJornada {
    Connection MyConexion;
    ResultSet result;
//    public JComboBox<String> ListarEquipos(JComboBox<String> equipos) throws IOException
//    {
//        try
//        {
//            Conexion nuevaConexion = new Conexion();
//            MyConexion = nuevaConexion.conectar();
//            Statement sentencia = MyConexion.createStatement();
//            result = sentencia.executeQuery("SELECT * FROM equipos;");
//            // Crear un JComboBox y cargar los nombres de los equipos
//          
//            while (result.next()) {
//                String nombreEquipo = result.getString("nombre");
//                equipos.addItem(nombreEquipo);
//            }
//        }
//        catch(SQLException e)
//        {
//            JOptionPane.showMessageDialog(null, "No se Pudo Listar ...."+e.getMessage());
//        }
//    return equipos;
//    }
        List<Object[]> filasAgregadas = new ArrayList<>();
        DefaultTableModel TablaModelo = new DefaultTableModel();
        
public DefaultTableModel ObtenerEquipo(JComboBox<String> EquipoLocal, JComboBox<String> EquipoVisitante, JDateChooser fPartido) {
    
    
    
    // Obtener los valores seleccionados de los JComboBox
    String local = (String) EquipoLocal.getSelectedItem();
    String visitante = (String) EquipoVisitante.getSelectedItem();
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String FechaPartido = dateFormat.format(fPartido.getDate());
    
    // Verificar si los equipos son iguales
    if (!local.equals("Eliga Una Opcion") && !visitante.equals("Eliga Una Opcion") && !local.equals(visitante)) {
        // Añadir una fila a la tabla y establecer los valores
     // Crear una nueva instancia
     TablaModelo = new DefaultTableModel();
        // Limpiar las columnas existentes y añadir las nuevas columnas
        TablaModelo.addColumn("N°"); 
        TablaModelo.addColumn("Equipo Local");
        TablaModelo.addColumn("vs");
        TablaModelo.addColumn("Equipo Visitante");
        TablaModelo.addColumn("Fecha Partido");
        int ConteoFilas = filasAgregadas.size() + 1;
        
        Object[] fila = {ConteoFilas, local, "vs", visitante,FechaPartido};
        filasAgregadas.add(fila);
        
        while (TablaModelo.getRowCount() > 0) {
            TablaModelo.removeRow(0);
        }
        // Actualizar la tabla con las filas agregadas
        for (Object[] filla : filasAgregadas) {
            TablaModelo.addRow(filla);
        }
    } else {
        // Si los equipos son iguales o alguna opción no ha sido seleccionada, no agregar la fila
        JOptionPane.showMessageDialog(null,"Los Equipos son iguales");
    }
    
    return TablaModelo;
}
 
 
    public void EliminarFilas(int indice) {
    if (indice >= 0 && indice < TablaModelo.getRowCount()) {
        // Eliminar la fila del modelo de tabla
        TablaModelo.removeRow(indice);

        // Eliminar la fila correspondiente de la lista filasAgregadas
        filasAgregadas.remove(indice);
        
        // Recalcular los números de fila para todas las filas restantes
        for (int i = indice; i < filasAgregadas.size(); i++) {
            Object[] fila = filasAgregadas.get(i);
            fila[0] = i + 1; // El primer elemento de la fila es el número de fila
        }
    } else {
        System.out.println("El índice está fuera de los límites.");
    }
}



   
    public void obtenerDatosTabla(DefaultTableModel tablaModelo) {
        for (int i = 0; i < tablaModelo.getRowCount(); i++) {
            Object[] fila = new Object[tablaModelo.getColumnCount()];
            for (int j = 0; j < tablaModelo.getColumnCount(); j++) {
                fila[j] = tablaModelo.getValueAt(i, j);
            }
            filasAgregadas.add(fila);
        }
    }
    
    public void Jornadas(JComboBox<String> cmbLigas, JComboBox<String> jornada,JDateChooser inicio,JDateChooser fin) throws SQLException, IOException {
    int lol =Integer.parseInt((String) jornada.getSelectedItem());try
        {
            //String consul = Consulta(cmbJornadas);
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            Date dInicio = inicio.getDate();
            Date dFin = fin.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String FechaInicio = dateFormat.format(dInicio);
            String FechaFin = dateFormat.format(dFin);
            
                sentencia.executeUpdate("INSERT INTO Jornadas (nJornada, idLiga,FechaInicio,FechaFin) VALUES ("+lol+
                        ", "+Ligas(cmbLigas)+", '"+FechaInicio+"', '"+FechaFin+"')");
                    
            //sentencia.executeUpdate(consul);
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Guardar las Jornadas..."+ex.getMessage());
            System.out.println(lol);
        }  
}

public void Partidos(JTable tabla, JComboBox<String> cmbLigas, JComboBox<String> jornada) throws SQLException, IOException {
    int lol =Integer.parseInt((String) jornada.getSelectedItem());try
        {
            //String consul = Consulta(cmbJornadas);
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            
            for(int i =0;i<tabla.getRowCount();i++)
            {
                sentencia.executeUpdate("INSERT INTO partidos (idLiga, idEquipoLocal,idEquipoVisitante,idJornada) VALUES ("+Ligas(cmbLigas)+
                        ", "+Equipos((String) tabla.getValueAt(i, 1))+", "+Equipos((String) tabla.getValueAt(i, 3))+", "+lol+")");
            }            
            //sentencia.executeUpdate(consul);
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Guardar Los partidos..."+ex.getMessage());
            System.out.println(lol);
        }  
}

    public String Ligas(JComboBox<String> Ligas) throws IOException{
        String idLiga ="";
        try{
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("SELECT ligas.idLiga FROM ligas WHERE ligas.liga =  '"+Ligas.getSelectedItem().toString()+"';");
            while(result.next()){
                idLiga=result.getString("idLiga");
                System.out.println(idLiga);
            }
        }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No se Pudo Listar la Liga ...."+e.getMessage());
    }
    return idLiga;
}
    
    public String Equipos(String Equipo) throws IOException{
        String idEquipo ="";
        try{
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("SELECT Equipos.idEquipo FROM Equipos WHERE Equipos.nombre  =  '"+Equipo+"';");
            while(result.next()){
                idEquipo=result.getString("idEquipo");
            }
        }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No se Pudo Listar ...."+e.getMessage());
    }
    return idEquipo;
}
    

public JComboBox<String> ListarLigas(JComboBox<String> ligas) throws IOException
    {
        try
        {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("SELECT * FROM Ligas;");
            // Crear un JComboBox y cargar los nombres de los equipos
          
            while (result.next()) {
                String nombreEquipo = result.getString("liga");
                ligas.addItem(nombreEquipo);
            }
        }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "No se Pudo Listar ...."+e.getMessage());
    }
    return ligas;
}

public void ListarJorndadaDisponible( JComboBox<String> cmbJornadas, JComboBox<String> cmbLigas,JDateChooser date1,JDateChooser date2,JComboBox<String> cmbCrearJornada ) throws IOException{
   try
        {
            Date dInicio ,dFin;
            date1.setDate(null); // Limpiar la fecha del JDateChooser
            date2.setDate(null);
                    JTextField txtDate1 = (JTextField) date1.getDateEditor().getUiComponent();
                    JTextField txtDate2 = (JTextField) date2.getDateEditor().getUiComponent();
        
            cmbJornadas.removeAllItems();
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("SELECT nJornada, FechaInicio,FechaFin FROM Jornadas WHERE idLiga = "+Ligas(cmbLigas)
                    +" and nJornada = "+cmbCrearJornada.getSelectedItem()+";");
            
            // Crear un JComboBox y cargar los nombres de los equipos
            while (result.next()) {
                String nombreEquipo = result.getString("nJornada");
                dInicio = result.getDate("FechaInicio");
                dFin = result.getDate("FechaFin");
                cmbJornadas.addItem(nombreEquipo);
                date1.setDate(dInicio);
                date2.setDate(dFin);
                
                    
                if(date1!=null &&date2!=null)
                {
                    date1.setEnabled(false);
                    txtDate1.setDisabledTextColor(Color.BLACK);
                    date2.setEnabled(false);
                    txtDate2.setDisabledTextColor(Color.BLACK);
                    
                }
            }
        }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "No se Pudo Listar ...."+e.getMessage());
    }
}
public void ListarJorndada( JComboBox<String> cmbJornadas){
   for (int i = 1; i <= 38; i++)
        {
            String lol = Integer.toString(i);
            cmbJornadas.addItem(lol);
        }
}

    public DefaultTableModel ListarJornadaTabla(JComboBox<String> cmbJornada,JComboBox<String> liga) throws IOException
    {
        DefaultTableModel TablaJornada = new DefaultTableModel();
        TablaJornada.setRowCount(0);
        TablaJornada.setColumnCount(0);
        TablaJornada.addColumn("N°");
        TablaJornada.addColumn("Equipo Local");
        TablaJornada.addColumn("Equipo Visitante");
        String JornadaSeleccionada = cmbJornada.getSelectedItem().toString();
        String LigaSeleccionada = liga.getSelectedItem().toString();

        try
        {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("SELECT partidos.idPartido, Ligas.liga AS Liga_Local, " +
            "EquiposLocal.nombre AS Equipo_Local, EquiposVisitante.nombre AS Equipo_Visitante, Jornadas.idJornada " +
            "FROM partidos " +
            "INNER JOIN Jornadas ON partidos.idJornada = Jornadas.idJornada " +
            "INNER JOIN Equipos AS EquiposLocal ON partidos.idEquipoLocal = EquiposLocal.idEquipo " +
            "INNER JOIN Equipos AS EquiposVisitante ON partidos.idEquipoVisitante = EquiposVisitante.idEquipo " +
            "INNER JOIN Ligas ON partidos.idLiga = Ligas.idLiga " +
            "WHERE Jornadas.idJornada =" + JornadaSeleccionada + " AND Ligas.liga = '" + LigaSeleccionada + "';");
            while(result.next()) {
                TablaJornada.addRow(new Object[]{
                    result.getString("idPartido"),
                    result.getString("Equipo_Local"),
                    result.getString("Equipo_Visitante"),
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
}

