
package Modelos;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class GestorPass {
    Connection MyConexion;
    ResultSet result;
   public String validarCredenciales(String usuario, String contrasena) throws IOException {
       String mensaje = "";
        try {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            
            // Llamar al procedimiento almacenado validar_credenciales
            result = sentencia.executeQuery("exec ValidarCredenciales '"+usuario+"','"+contrasena+"';" );
            if (result.next()) {
                mensaje = result.getString("mensaje");
            }
          
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        
        return mensaje;
    }
   public String RetornarRol(String usuario) throws IOException {
        String mensaje = "";
        try {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            Statement sentencia = MyConexion.createStatement();
            
            // Llamar al procedimiento almacenado validar_credenciales
            result = sentencia.executeQuery("exec BuscarRol '"+usuario+"';" );
            if (result.next()) {
                mensaje = result.getString("rol");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        
        return mensaje;
    }
}
