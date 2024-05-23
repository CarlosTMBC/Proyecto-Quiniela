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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
            "INNER JOIN Jornadas ON partidos.idJornada = Jornadas.nJornada " +
            "INNER JOIN Equipos AS EquiposLocal ON partidos.idEquipoLocal = EquiposLocal.idEquipo " +
            "INNER JOIN Equipos AS EquiposVisitante ON partidos.idEquipoVisitante = EquiposVisitante.idEquipo " +
            "INNER JOIN Ligas ON partidos.idLiga = Ligas.idLiga " +
            "WHERE Jornadas.nJornada =" + JornadaSeleccionada + " AND Ligas.liga = '" + LigaSeleccionada + "';");
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

public void ObtenerResultadoPartido(JTable tabla, JComboBox<String> cmbLigas, JComboBox<String> cmbJornada, JDateChooser fecha, JLabel usuario) throws IOException {
    PreparedStatement pstmt = null;    
    try {
        Date fPrediccion = fecha.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.conectar();
        Statement sentencia = MyConexion.createStatement();

        List<String> idsPartidos = idPartidos(cmbLigas, cmbJornada);
        int idUser = idUsuario(usuario.getText());
        
        // Iterar sobre las filas de la tabla
        for (int i = 0; i < tabla.getRowCount(); i++) { // Asumiendo que la predicción está en la columna 3
            
            // Obtener el voto para la fila actual
            String voto = BuscarVoto(tabla, i);
            
            // Si el voto es válido, insertarlo en la base de datos
            if (voto != null && !voto.isEmpty()) {
                String sqlInsert = "INSERT INTO Predicciones (idPartido, FechaPrediccion, Prediccion, idUser) VALUES (?, ?, ?, ?)";
                pstmt = MyConexion.prepareStatement(sqlInsert);
                pstmt.setInt(1, Integer.parseInt(idsPartidos.get(i)));
                pstmt.setString(2, dateFormat.format(fPrediccion));
                pstmt.setString(3, voto);
                pstmt.setInt(4, idUser);
                System.out.println(pstmt);
                pstmt.executeUpdate(); // Ejecutar la inserción
            }
        }
        
        JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se pudo listar o guardar los datos: " + e.getMessage() + pstmt);
    }
}

public String BuscarVoto(JTable tabla, int fila) {
    for (int j = 0; j < tabla.getColumnCount(); j++) {
        Object cellValue = tabla.getValueAt(fila, j);
        if (cellValue != null && (cellValue.equals("X") || cellValue.equals("1") || cellValue.equals("2"))) {
            return (String) cellValue;
        }
    }
    return null;
}

public List<String> idPartidos(JComboBox<String> cmbLigas, JComboBox<String> cmbJornada) throws IOException {
    List<String> idPartidos = new ArrayList<>();
    try {
        ModeloJornada metodo = new ModeloJornada();
        Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.conectar();
        Statement sentencia = MyConexion.createStatement();
        result = sentencia.executeQuery("SELECT partidos.idPartido FROM partidos WHERE idLiga = " + metodo.Ligas(cmbLigas) + " AND idJornada = " + Integer.parseInt(cmbJornada.getSelectedItem().toString()) + ";");
        
        while (result.next()) {
            idPartidos.add(result.getString("idPartido"));
        }
    } catch(SQLException e) {
        JOptionPane.showMessageDialog(null, "No se pudo listar los ID de partido: " + e.getMessage());
    }
    return idPartidos;
}


// Método para verificar si ya existe una predicción para el mismo partido, usuario y fecha
//private boolean yaExistePrediccion(String idPartido, int idUser, String fechaPrediccion) throws SQLException {
//    String sqlQuery = "SELECT COUNT(*) FROM Predicciones WHERE idPartido = ? AND idUser = ? AND FechaPrediccion = ?";
//    PreparedStatement pstmt = MyConexion.prepareStatement(sqlQuery);
//    pstmt.setInt(1, Integer.parseInt(idPartido));
//    pstmt.setInt(2, idUser);
//    pstmt.setString(3, fechaPrediccion);
//    ResultSet rs = pstmt.executeQuery();
//    rs.next();
//    return rs.getInt(1) > 0;
//}



 public String RetornarGanador() throws IOException{
     String resultado ="";
     int idPartido = 0;
     try{
            ModeloJornada metodo = new ModeloJornada();
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("exec CompararGoles");
            while(result.next()){
                idPartido= Integer.parseInt(result.getString("idPartido")) ;
                 resultado= result.getString("Resultado");
            }
        }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No se Pudo Listar ...."+e.getMessage());
    }
     return null;
 }
 
 
 public int idUsuario(String usuario) throws IOException{
        int idUsuario =0;
        try{
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("SELECT credenciales.idUser FROM credenciales WHERE credenciales.usuario = '"+usuario+"';");
            while(result.next()){
                idUsuario=result.getInt("idUser");
            }
        }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No se Pudo Listar ...."+e.getMessage());
    }
    return idUsuario;
}
}
