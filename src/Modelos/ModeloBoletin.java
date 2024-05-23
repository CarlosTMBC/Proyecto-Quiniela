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
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlt
 */
public class ModeloBoletin {
    Connection MyConexion;
    ResultSet result;
public DefaultTableModel ListarBoletin(JComboBox<String> liga) throws IOException
    {
        DefaultTableModel TablaJornada = new DefaultTableModel();
        TablaJornada.setRowCount(0);
        TablaJornada.setColumnCount(0);

        
        String LigaSeleccionada = liga.getSelectedItem().toString();

        try
        {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("SELECT idParticipante, Nombre_Participante, [1] AS Jornada_1, " +
            "[2] AS Jornada_2, [3] AS Jornada_3, [4] AS Jornada_4, [5] AS Jornada_5, [6] AS Jornada_6, " +
            "[7] AS Jornada_7, [8] AS Jornada_8, [9] AS Jornada_9, [10] AS Jornada_10, [11] AS Jornada_11, " +
            "[12] AS Jornada_12, [13] AS Jornada_13, [14] AS Jornada_14, [15] AS Jornada_15, " +
            "[16] AS Jornada_16, [17] AS Jornada_17, [18] AS Jornada_18, [19] AS Jornada_19, " +
            "[20] AS Jornada_20, [21] AS Jornada_21, [22] AS Jornada_22, [23] AS Jornada_23, " +
            "[24] AS Jornada_24, [25] AS Jornada_25, [26] AS Jornada_26, [27] AS Jornada_27, " +
            "[28] AS Jornada_28, [29] AS Jornada_29, [30] AS Jornada_30, [31] AS Jornada_31, " +
            "[32] AS Jornada_32, [33] AS Jornada_33, [34] AS Jornada_34, [35] AS Jornada_35, " +
            "[36] AS Jornada_36, [37] AS Jornada_37, [38] AS Jornada_38, Total_Aciertos " +
            "FROM (  SELECT p.idParticipante, CONCAT(p.nombre, ' ', p.apellido) AS Nombre_Participante, j.nJornada AS Jornada, " +
            "CAST(pr.Aciertos AS INT) AS Aciertos, SUM(CAST(pr.Aciertos AS INT)) OVER (PARTITION BY p.idParticipante) AS Total_Aciertos " +
            "FROM participantes p INNER JOIN Predicciones pr ON p.idParticipante = pr.idUser " +
            "INNER JOIN partidos pa ON pr.idPartido = pa.idPartido " +
            "INNER JOIN Jornadas j ON pa.idJornada = j.nJornada " +
            "INNER JOIN Ligas l ON pa.idLiga = l.idLiga " +
            "WHERE l.liga = '"+LigaSeleccionada+"' " +
            ") AS SourceTable " +
            "PIVOT (" +
            "    SUM(Aciertos) " +
            "    FOR Jornada IN ([1], [2], [3], [4], [5], [6], [7], [8], [9], [10], [11], [12], [13], [14], [15], [16], [17], [18], [19], [20], [21], [22], [23], [24], [25], [26], [27], [28], [29], [30], [31], [32], [33], [34], [35], [36], [37], [38]) " +
            ") AS PivotTable " +
            "ORDER BY " +
            "    Nombre_Participante;");



// Añadir columnas para idParticipante y Nombre_Participante
TablaJornada.addColumn("N°");
TablaJornada.addColumn(" Nombre_Participante ");

// Añadir columnas para las jornadas del 1 al 38
for (int i = 1; i <= 38; i++) {
    TablaJornada.addColumn(i);
}

// Añadir columna para Total_Aciertos
TablaJornada.addColumn(" Total_Aciertos ");

while (result.next()) {
    Object[] rowData = new Object[41]; // idParticipante, Nombre_Participante, Jornadas 1-38, Total_Aciertos
    
    rowData[0] = result.getString("idParticipante");
    rowData[1] = result.getString("Nombre_Participante");

    for (int i = 1; i <= 38; i++) {
        rowData[i + 1] = result.getString("Jornada_" + (i)); // Jornadas comienzan desde el índice 2
    }

    rowData[40] = result.getString("Total_Aciertos"); // Total_Aciertos en la última posición

    TablaJornada.addRow(rowData);
}

          
            
            return TablaJornada;
        }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "No se Pudo Listar ...."+e.getMessage());
    }
    return TablaJornada;
    }

    public void ObtenerGanadores(JLabel ganador1,JLabel ganador2,JLabel ganador3,JTable tabla)
    {
        ganador1.setText(tabla.getValueAt(0, 1).toString());
        ganador2.setText(tabla.getValueAt(1, 1).toString());
        
    }
    
    public void EstablecerPremios(ArrayList<String> premios,ArrayList<String> ganadores) throws IOException
    {
    try
        {
          Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.conectar();
        Statement sentencia = MyConexion.createStatement();
        for(int i =0;i<3;i++)
        {
            sentencia.executeUpdate("INSERT INTO premios VALUES ('" + premios.get(i) + "', '" + ganadores(ganadores.get(i)) + "')");
        }
        

        JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
        
        }
    
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Guardar..."+ex.getMessage());
        }  
}
     public String ganadores(String nombre) throws IOException{
        String idParticipante ="";
        try{
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            result = sentencia.executeQuery("SELECT participantes.idParticipante FROM participantes WHERE CONCAT(participantes.nombre,' ',participantes.apellido)  =  '"+nombre+"';");
            while(result.next()){
                idParticipante=result.getString("idParticipante");
            }
        }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No se Pudo Listar ...."+e.getMessage());
    }
    return idParticipante;
}
    

}
