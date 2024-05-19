/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Modelos.ModeloJornada.*;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author carlt
 */
public class ModeloQuiniela {
    Connection MyConexion;
    ResultSet result;


public DefaultTableModel ListarQuiniela(JComboBox<String> cmbJornada,JComboBox<String> liga) throws IOException
    {
        DefaultTableModel TablaJornada = new DefaultTableModel();
        TablaJornada.setRowCount(0);
        TablaJornada.setColumnCount(0);
        TablaJornada.addColumn("N°");
        TablaJornada.addColumn("Equipo Local");
        TablaJornada.addColumn("Equipo Visitante");
        TablaJornada.addColumn("1");
        TablaJornada.addColumn("X");
        TablaJornada.addColumn("2");
        String JornadaSeleccionada = cmbJornada.getSelectedItem().toString();
        String LigaSeleccionada = liga.getSelectedItem().toString();

        try
        {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("SELECT partidos.idPartido, Ligas.liga AS Liga_Local, " +
            "EquiposLocal.nombre AS Equipo_Local, EquiposVisitante.nombre AS Equipo_Visitante, Jornadas.idJornada " +
            ",partidos.GolesEquipoLocal, partidos.GolesEquipoVisitante FROM partidos " +
            "INNER JOIN Jornadas ON partidos.idJornada = Jornadas.idJornada " +
            "INNER JOIN Equipos AS EquiposLocal ON partidos.idEquipoLocal = EquiposLocal.idEquipo " +
            "INNER JOIN Equipos AS EquiposVisitante ON partidos.idEquipoVisitante = EquiposVisitante.idEquipo " +
            "INNER JOIN Ligas ON partidos.idLiga = Ligas.idLiga " +
            "WHERE Jornadas.idJornada =" + JornadaSeleccionada + " AND Ligas.liga = '" + LigaSeleccionada + "';");
            while(result.next()) {
                TablaJornada.addRow(new Object[]{
                    result.getString("idPartido"),
                    result.getString("Equipo_Local"),
                    result.getString("Equipo_Visitante")
                      
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

public void ObtenerResultadoPartido(JTable tabla,JComboBox<String> cmbLigas,JComboBox<String> cmbJornada,JDateChooser fecha) throws IOException
{

    try
        {
             Date fPrediccion =  fecha.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             
          Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.conectar();
        Statement sentencia = MyConexion.createStatement();
        //sentencia.executeUpdate("INSERT INTO Predicciones VALUES (" + idPartido(cmbLigas,cmbJornada) + ", '" + dateFormat.format(fPrediccion) + "', '" + BuscarVoto(tabla) + "', '" + telefono + "', '" + dpi + "')");
//        for(int i =0;i<tabla.getRowCount();i++)
//            {
//                sentencia.executeUpdate("INSERT INTO partidos (idLiga, idEquipoLocal,idEquipoVisitante,idJornada) VALUES ("+Ligas(cmbLigas)+
//                        ", "+Equipos((String) tabla.getValueAt(i, 1))+", "+Equipos((String) tabla.getValueAt(i, 3))+", "+lol+")");
//            }     
        JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
        
        }
    
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Guardar..."+ex.getMessage());
        }  

}

 public String idPartido(JComboBox<String> cmbLigas,JComboBox<String> cmbJornada) throws IOException{
        String idEquipo ="";
        try{
            ModeloJornada metodo = new ModeloJornada();
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("SELECT partidos.idPartidos FROM partidos WHERE idLiga  =  "+metodo.Ligas(cmbLigas)+" and idJornada " + cmbJornada.getSelectedItem() + ";");
            while(result.next()){
                idEquipo=result.getString("idPartidos");
            }
        }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No se Pudo Listar ...."+e.getMessage());
    }
    return idEquipo;
}
 
 public String BuscarVoto(JTable tabla){
     String valor ="";
     for(int i =3;i<=tabla.getColumnCount();i++)
     {
         for(int j =3;j<=tabla.getRowCount();j++)
        {
            if(tabla.getValueAt(j, i)!=null)
            {
                valor = (String) tabla.getValueAt(j, i);
                return valor;
            }
            
        }
         
     }
        return null;
 }
 
 public String RetornarGanador() throws IOException{
     String mensaje ="";
     try{
            ModeloJornada metodo = new ModeloJornada();
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("exec CompararGoles");
            while(result.next()){
                mensaje=result.getString("idPartidos");
            }
        }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No se Pudo Listar ...."+e.getMessage());
    }
     return null;
 }
}
