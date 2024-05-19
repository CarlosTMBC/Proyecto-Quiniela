/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Properties;
/**
 *
 * @author carlt
 */
public class Conexion {
     
 public Connection conectar() throws SQLException, IOException {
        // Cargar las propiedades desde el archivo config.properties
        Properties properties = new Properties();
        
        try (FileInputStream input = new FileInputStream("src/resources/config.properties")) {
            properties.load(input);
            
        }

        String dbUser = properties.getProperty("db.user");
        String dbPassword = properties.getProperty("db.password");
        String dbServer = properties.getProperty("db.server");
        String dbName = properties.getProperty("db.name");

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String URL = "jdbc:sqlserver://" + dbServer + ":1433;databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;user=" + dbUser + ";password=" + dbPassword;

            // Crear y retornar la conexión
            Connection connection = DriverManager.getConnection(URL);
            return connection;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: No se encontró el driver JDBC de SQL Server");
            return null;
        }
    }
}
