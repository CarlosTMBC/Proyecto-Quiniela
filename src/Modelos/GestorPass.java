
package Modelos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorPass {
    Connection MyConexion;
   public String validarCredenciales(String usuario, String contrasena) {
        String mensaje = "";
        
        try {
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.conectar();
            
            // Llamar al procedimiento almacenado validar_credenciales
            String query = "{call validar_credenciales(?, ?)}";
            CallableStatement stmt = MyConexion.prepareCall(query);
            stmt.setString(1, usuario);
            stmt.setString(2, contrasena);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                mensaje = rs.getString("mensaje");
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        
        return mensaje;
    }
}
