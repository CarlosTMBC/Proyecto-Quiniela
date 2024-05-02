/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author carlt
 */
public class Conexion {
    private static Connection conn = null;
     String URL = "jdbc:mysql://localhost:3306/quinielaDB";
     String user = "root";
     String pass = "9820";

    public Connection conectar() throws SQLException {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(URL, user, pass);
                JOptionPane.showMessageDialog(null, "Conexion Establecida");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error: No se encontró el driver JDBC");
            }
        }
        return conn;
    }

    public  void desconectar() throws SQLException {
        if (conn != null) {
            conn.close();
            conn = null;
        }
    }
}
