/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelos.*;
import Vistas.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;
/**
 *
 * @author carlt
 */
public class Controlador implements ActionListener, MouseListener,PropertyChangeListener  {

    //Vistas de Programa
    frmLogin VistaPrincipal;
    frmCuentas VistaCuentas;
    frmRegistro VistaRegistrar;
    frmAdministrador VistaAdministrador;
    frmCrearJornadas VistaCrearJornadas;
    frmResultados VistaResultados;
    frmJornadas VistaJornadas;
    frmUsuario VistaUsuario;
    frmQuiniela VistaQuiniela;
    frmResultadosQuiniela VistaResultadosQuiniela;
    frmBoletin VistaBoletin;
    
    
    int indice =0;
    int Equipos ;
    //Modelos de Programa
    ModeloParticipantes modeloParticipantes;
    ModeloEquipos modeloEquipos;
    ModeloQuiniela modeloQuiniela;
    ModeloJornada modeloJornada;
    ModeloResultadosA modeloResultados;
    GestorPass GestorDeCuentas;

    public Controlador(frmLogin VistaPrincipal, frmCuentas VistaCuentas, 
        frmRegistro VistaRegistrar, frmAdministrador VistaAdministrador, 
        frmCrearJornadas VistaCrearJornadas, frmResultados VistaResultados,
        frmJornadas VistaJornadas, frmQuiniela VistaQuiniela,frmUsuario VistaUsuario,
        frmResultadosQuiniela VistaResultadosQuiniela,frmBoletin VistaBoletin,
        ModeloParticipantes modeloParticipantes, ModeloEquipos modeloEquipos,
        ModeloQuiniela modeloQuiniela, 
        ModeloJornada modeloJornada, ModeloResultadosA modeloResultados,GestorPass GestorDeCuentas) {
        
        this.VistaPrincipal = VistaPrincipal;
        this.VistaCuentas = VistaCuentas;
        this.VistaRegistrar = VistaRegistrar;
        this.VistaAdministrador = VistaAdministrador;
        this.VistaCrearJornadas = VistaCrearJornadas;
        this.VistaResultados = VistaResultados;
        this.VistaJornadas = VistaJornadas;
        this.VistaQuiniela = VistaQuiniela;
        this.modeloParticipantes = modeloParticipantes;
        this.modeloEquipos = modeloEquipos;
        this.modeloQuiniela = modeloQuiniela;
        this.modeloJornada = modeloJornada;
        this.VistaUsuario = VistaUsuario;
        this.modeloResultados = modeloResultados;
        this.VistaBoletin = VistaBoletin;
        this.GestorDeCuentas = GestorDeCuentas;
        this.VistaResultadosQuiniela = VistaResultadosQuiniela;
        this.VistaPrincipal.btnCrearCuenta.addActionListener(this);
        this.VistaPrincipal.btnIngresar.addActionListener(this);
        
        this.VistaPrincipal.setVisible(true);
        this.VistaPrincipal.setLocationRelativeTo(null);
        this.VistaCrearJornadas.tblPartidos.addMouseListener(this);
        this.VistaResultados.cmbJornada.addActionListener(this); 
        this.VistaResultados.cmbLigas.addActionListener(this);
        this.VistaCrearJornadas.jdcFecha.addPropertyChangeListener(this);
        this.VistaAdministrador.iBoletin.addActionListener(this);
        this.VistaUsuario.iQuiniela.addActionListener(this);
                        this.VistaUsuario.iResultadosQuiniela.addActionListener(this);
                        
                        this.VistaAdministrador.iCrearJornadas.addActionListener(this);
                            this.VistaAdministrador.iIngresoResultados.addActionListener(this);
                            this.VistaAdministrador.iVerJornadas.addActionListener(this);
                            this.VistaAdministrador.iVerUsuarios.addActionListener(this);
    this.VistaCrearJornadas.jdcFecha.addPropertyChangeListener("date", this);
        this.modeloJornada.ListarJorndada(this.VistaCrearJornadas.cmbJornada);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.VistaPrincipal.btnCrearCuenta)
        {
            this.VistaRegistrar.setVisible(true);
            this.VistaRegistrar.setLocationRelativeTo(null);
            
            this.VistaRegistrar.btnIngresar.addActionListener(this);
            this.VistaRegistrar.btnCancelar.addActionListener(this);
        }
        if(e.getSource() == this.VistaPrincipal.btnIngresar)
        {
            if(this.VistaPrincipal.txtUser.getText().isEmpty()||this.VistaPrincipal.txtPass.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Los Campos estan Vacios");
            }
            else
            {
                String validacion = null;
                try {
                    validacion = this.GestorDeCuentas.validarCredenciales(this.VistaPrincipal.txtUser.getText(), this.VistaPrincipal.txtPass.getText());
                    System.out.println(validacion);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String rol = null;
                
                try {
                    rol = this.GestorDeCuentas.RetornarRol(this.VistaPrincipal.txtUser.getText());
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if("Conexión establecida".equals(validacion))
                {
                    if("Administrador".equals(rol))
                    {
                        this.VistaAdministrador.setVisible(true);
                            this.VistaAdministrador.setLocationRelativeTo(null);
                            this.VistaAdministrador.setExtendedState(MAXIMIZED_BOTH);
                            
                            JOptionPane.showMessageDialog(null, "Bienvenido "+rol);
                            
                    }
                    else if("Usuario".equals(rol))
                    {
                        this.VistaUsuario.setVisible(true);
                        this.VistaUsuario.setLocationRelativeTo(null);  
                        this.VistaUsuario.setExtendedState(MAXIMIZED_BOTH);  
                        
                        JOptionPane.showMessageDialog(null, "Bienvenido "+rol);
                    }
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, validacion);
                }
        }
        }
        
        if(e.getSource() == this.VistaUsuario.iQuiniela)
        {
            this.VistaQuiniela.setVisible(true);
            this.VistaQuiniela.setLocationRelativeTo(null);
            DefaultTableModel TablaQuiniela = null;
                try {
                    TablaQuiniela = this.modeloQuiniela.ListarQuiniela(this.VistaQuiniela.cmbJornada, this.VistaQuiniela.cmbLiga);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            this.VistaQuiniela.Tabla.setModel(TablaQuiniela);
            for(int i =3;i<=5;i++)
            {
                TamañoPequeño(VistaQuiniela.Tabla,i);
            }
            this.VistaQuiniela.Tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleCellClick();
            }
        });

        }
        if(e.getSource() == this.VistaUsuario.iResultadosQuiniela)
        {
            this.VistaResultadosQuiniela.setVisible(true);
            this.VistaResultadosQuiniela.setLocationRelativeTo(null);
        }
        
        if(e.getSource() == this.VistaAdministrador.iCrearJornadas)
        {   
            
                try {
                    this.modeloJornada.ListarLigas(this.VistaCrearJornadas.cmbLigas);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            this.VistaCrearJornadas.btnEliminar.addActionListener(this);
            this.VistaCrearJornadas.btnCrearPartido.addActionListener(this);
            this.VistaCrearJornadas.btnIngresarJornada.addActionListener(this);
            
            this.VistaCrearJornadas.cmbLigas.addActionListener(this);
            
            
            this.VistaCrearJornadas.cmbJornada.addActionListener(this);
            this.VistaCrearJornadas.setVisible(true);
            this.VistaCrearJornadas.setLocationRelativeTo(null);
            this.VistaCrearJornadas.btnCrearJornada.addActionListener(this);
            
            this.VistaCrearJornadas.btnCrearJornada.setEnabled(true); 
            if (!this.VistaCrearJornadas.txtFechaInicio.isEnabled()&&!this.VistaCrearJornadas.txtFechaFin.isEnabled() || 
                    this.VistaCrearJornadas.txtFechaInicio.getDate() == null&&this.VistaCrearJornadas.txtFechaFin.getDate() == null
                     ) {
                // Deshabilitar el campo txtFechaInicio
                this.VistaCrearJornadas.btnCrearJornada.setEnabled(false);
            }
            
        }
        if(e.getSource() == this.VistaCrearJornadas.cmbJornada)
        {
//            this.VistaCrearJornadas.txtFechaInicio.setDate(null); 
//            this.VistaCrearJornadas.txtFechaFin.setDate(null);
            this.VistaCrearJornadas.txtFechaInicio.setEnabled(true);
            this.VistaCrearJornadas.txtFechaFin.setEnabled(true); 
            this.VistaCrearJornadas.btnCrearJornada.setEnabled(true); 
            if (!this.VistaCrearJornadas.txtFechaInicio.isEnabled()&&!this.VistaCrearJornadas.txtFechaFin.isEnabled() || 
                    this.VistaCrearJornadas.txtFechaInicio.getDate() == null&&this.VistaCrearJornadas.txtFechaFin.getDate() == null
                     ) {
                // Deshabilitar el campo txtFechaInicio
                this.VistaCrearJornadas.btnCrearJornada.setEnabled(false);
            }
                try {
                    this.modeloJornada.ListarJorndadaDisponible(this.VistaCrearJornadas.cmbJornadas1,this.VistaCrearJornadas.cmbLigas,
                            this.VistaCrearJornadas.txtFechaInicio,this.VistaCrearJornadas.txtFechaFin,this.VistaCrearJornadas.cmbJornada);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        
        if(e.getSource() == this.VistaCrearJornadas.btnCrearPartido)
        {
            String cmbEquipoLocal = this.VistaCrearJornadas.cmbEquipos1.getSelectedItem().toString();
            String cmbEquipoVisitante = this.VistaCrearJornadas.cmbEquipos2.getSelectedItem().toString();
            if(cmbEquipoLocal.equals("Eliga Una Opcion") || cmbEquipoVisitante.equals("Eliga Una Opcion"))
            {
                JOptionPane.showMessageDialog(null, "Elija Los Equipos");
            }
            else
            {
                DefaultTableModel TablaModelo2 =this.modeloJornada.ObtenerEquipo(this.VistaCrearJornadas.cmbEquipos1, 
                this.VistaCrearJornadas.cmbEquipos2,this.VistaCrearJornadas.jdcFecha);
                this.VistaCrearJornadas.tblPartidos.setModel(TablaModelo2);
                TamañoPequeño(this.VistaCrearJornadas.tblPartidos, 0); 
                TamañoPequeño(this.VistaCrearJornadas.tblPartidos, 2); 
                 
                centrarTextoTabla(this.VistaCrearJornadas.tblPartidos);
                               System.out.println(Equipos);
                

                if (this.VistaCrearJornadas.tblPartidos.getRowCount() == Equipos) {
                    
                    this.VistaCrearJornadas.btnIngresarJornada.setEnabled(true);
                }
                if(this.VistaCrearJornadas.tblPartidos.getRowCount() != 0)
                {
                    this.VistaCrearJornadas.btnEliminar.setEnabled(true);
                }
                this.VistaCrearJornadas.cmbLigas.enable(false);
                this.modeloEquipos.DeslistarEquipos(this.VistaCrearJornadas.cmbEquipos1, this.VistaCrearJornadas.cmbEquipos2, TablaModelo2);
                
            }
        }
        
        if(e.getSource() == this.VistaCrearJornadas.btnCrearJornada)
        {
            try {
                    this.modeloJornada.Jornadas(this.VistaCrearJornadas.cmbLigas, 
                    this.VistaCrearJornadas.cmbJornada, this.VistaCrearJornadas.txtFechaInicio,
                    this.VistaCrearJornadas.txtFechaFin);
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        if(e.getSource()==this.VistaCrearJornadas.cmbLigas)
        {
            DefaultTableModel TablaModelo1 = null;
                try {
                    TablaModelo1 = this.modeloEquipos.ListarEquipos(this.VistaCrearJornadas.cmbLigas);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            this.VistaCrearJornadas.tblEquipo.setModel(TablaModelo1);
                try {
                    this.modeloEquipos.listComboBoxItems(this.VistaCrearJornadas.cmbLigas,this.VistaCrearJornadas.cmbEquipos1);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {   
                    this.modeloEquipos.listComboBoxItems(this.VistaCrearJornadas.cmbLigas,this.VistaCrearJornadas.cmbEquipos2);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
             Equipos = (this.VistaCrearJornadas.cmbEquipos1.getItemCount()-1)/2; 
                try {
                    this.modeloJornada.ListarJorndadaDisponible(this.VistaCrearJornadas.cmbJornadas1,this.VistaCrearJornadas.cmbLigas,
                            this.VistaCrearJornadas.txtFechaInicio,this.VistaCrearJornadas.txtFechaFin,this.VistaCrearJornadas.cmbJornada);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            TamañoPequeño(this.VistaCrearJornadas.tblEquipo, 0);
        }
        
        if(e.getSource() == this.VistaCrearJornadas.btnIngresarJornada)
        {
            try {
                
                this.modeloJornada.Partidos(this.VistaCrearJornadas.tblPartidos, this.VistaCrearJornadas.cmbLigas,this.VistaCrearJornadas.cmbJornadas1);
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            this.VistaCrearJornadas.cmbLigas.enable(true);
        }
        
        
        if(e.getSource() == this.VistaCrearJornadas.btnEliminar)
        {
            
            this.modeloJornada.EliminarFilas(indice);   
        }
//        if(e.getSource() == this.VistaAdministrador.iIngresoResultados)
//        {
//            
//            DefaultTableModel TablaJornadas = this.modeloResultados.ListarJornadaTabla(this.VistaResultados.cmbJornada, this.VistaResultados.cmbLigas);
//            
//            this.VistaResultados.tblPartidos.setModel(TablaJornadas);
//            this.VistaResultados.tblPartidos.setEditingColumn(3);
//            this.VistaResultados.tblPartidos.setEditingColumn(4);
//            this.VistaResultados.setVisible(true);
//            this.VistaResultados.setLocationRelativeTo(null);
//        }
        
    if(e.getSource() == this.VistaAdministrador.iIngresoResultados)
    {
        this.VistaResultados.btnGuardarResultados.addActionListener(this);
        DefaultTableModel TablaJornadas = null;
                try {
                    TablaJornadas = this.modeloResultados.ListarJornadaTabla(this.VistaResultados.cmbJornada, this.VistaResultados.cmbLigas);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
        Tablas(TablaJornadas,this.VistaResultados.tblPartidos);

        this.VistaResultados.setVisible(true);
        this.VistaResultados.setLocationRelativeTo(null);
        this.VistaResultados.cmbJornada.addActionListener(this);
                this.VistaResultados.cmbLigas.addActionListener(this);
    }
    
    
    if(e.getSource() == this.VistaResultados.btnGuardarResultados)
    {
            try {
                this.modeloResultados.EstablecerResultados(this.VistaResultados.tblPartidos);
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
    }


        
        if(e.getSource() == this.VistaResultados.cmbJornada)
                
        {
            DefaultTableModel TablaJornadas = null;
                try {
                    TablaJornadas = this.modeloResultados.ListarJornadaTabla(this.VistaResultados.cmbJornada, this.VistaResultados.cmbLigas);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            this.VistaResultados.tblPartidos.setModel(TablaJornadas);
            Tablas(TablaJornadas,this.VistaResultados.tblPartidos);
            
        }
        if(e.getSource() == this.VistaResultados.cmbLigas)
                
        {
            DefaultTableModel TablaJornadas = null;
                try {
                    TablaJornadas = this.modeloResultados.ListarJornadaTabla(this.VistaResultados.cmbJornada, this.VistaResultados.cmbLigas);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            this.VistaResultados.tblPartidos.setModel(TablaJornadas);
            Tablas(TablaJornadas,this.VistaResultados.tblPartidos);
           
        }

        
        if(e.getSource() == this.VistaAdministrador.iVerJornadas)
        {
            DefaultTableModel TablaJornadas = null;
                try {
                    TablaJornadas = this.modeloJornada.ListarJornadaTabla(this.VistaJornadas.cmbJornada, this.VistaJornadas.cmbLiga);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            this.VistaJornadas.tblPartidos.setModel(TablaJornadas);
            this.VistaJornadas.cmbJornada.addActionListener(this);
            this.VistaJornadas.cmbLiga.addActionListener(this);
            this.VistaJornadas.setVisible(true);
            this.VistaJornadas.setLocationRelativeTo(null);
        }
        if(e.getSource() == this.VistaJornadas.cmbJornada)
                
        {
            DefaultTableModel TablaJornadas = null;
                try {
                    TablaJornadas = this.modeloJornada.ListarJornadaTabla(this.VistaJornadas.cmbJornada, this.VistaJornadas.cmbLiga);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            this.VistaJornadas.tblPartidos.setModel(TablaJornadas);
            
        }
        if(e.getSource() == this.VistaJornadas.cmbLiga)
                
        {
            DefaultTableModel TablaJornadas = null;
                try {
                    TablaJornadas = this.modeloJornada.ListarJornadaTabla(this.VistaJornadas.cmbJornada, this.VistaJornadas.cmbLiga);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            this.VistaJornadas.tblPartidos.setModel(TablaJornadas);
           
        }
        if(e.getSource() == this.VistaAdministrador.iVerUsuarios)
        {
            DefaultTableModel TablaModelo2 = null;
                try {
                    TablaModelo2 = this.modeloParticipantes.ListarParticipantes();
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            this.VistaCuentas.Tabla.setModel(TablaModelo2);
            this.VistaCuentas.setVisible(true);
            this.VistaCuentas.setLocationRelativeTo(null);
        }
        
        if(e.getSource() == this.VistaAdministrador.iBoletin)
        {
            this.VistaBoletin.setVisible(true);
            this.VistaBoletin.setLocationRelativeTo(null);
        }
    }
    
    
    
    public void centrarTextoTabla(JTable tabla)
    {
        for (int i = 0; i < tabla.getColumnCount(); i++) {
                tabla.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {{
                     setHorizontalAlignment(SwingConstants.CENTER);
                }   });}
    }
    
    public void TamañoPequeño(JTable tabla, int indice)
    {
       tabla.getColumnModel().getColumn(indice).setPreferredWidth(20);
    }

        
    public Vector getColumnNames(DefaultTableModel model) {
    int columnCount = model.getColumnCount();
    Vector columnNames = new Vector();
    for (int i = 0; i < columnCount; i++) {
        columnNames.add(model.getColumnName(i));
    }
    return columnNames;
}

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==this.VistaCrearJornadas.tblPartidos)
        {
            indice = this.VistaCrearJornadas.tblPartidos.getSelectedRow();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

   
    private void clearOtherColumns(DefaultTableModel model, int row, int col) {
        for (int i = 3; i < model.getColumnCount(); i++) {
            if (i != col) {
                model.setValueAt("", row, i);
            }
        }
    }
    
     private void handleCellClick() {
        DefaultTableModel model = (DefaultTableModel) this.VistaQuiniela.Tabla.getModel();
        int row = this.VistaQuiniela.Tabla.getSelectedRow();
        int col = this.VistaQuiniela.Tabla.getSelectedColumn();

        if (col == 3) { // Índice 3
            model.setValueAt("1", row, col);
            clearOtherColumns(model, row, col);
        } else if (col == 4) { // Índice 4
            model.setValueAt("X", row, col);
            clearOtherColumns(model, row, col);
        } else if (col == 5) { // Índice 5
            model.setValueAt("2", row, col);
            clearOtherColumns(model, row, col);
        }
    }
     
     
     private void Tablas(DefaultTableModel ModeloTabla,JTable tabla){
         DefaultTableModel customModel = new DefaultTableModel(ModeloTabla.getDataVector(), getColumnNames(ModeloTabla)) {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Permitir la edición solo en las columnas con índice 3 y 4
            return column == 3 || column == 4;
        }
    };
        
    customModel.addTableModelListener(new TableModelListener() {
    boolean isUpdating = false; // Variable interruptor

    @Override
    public void tableChanged(TableModelEvent e) {
        if (isUpdating) {
            return; // Si isUpdating es verdadero, no hacemos nada
        }

        if (e.getType() == TableModelEvent.UPDATE) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (column == 3 || column == 4) {
                String value = (String) customModel.getValueAt(row, column);
                try {
                    Integer.parseInt(value); // Intentar convertir el valor a entero
                } catch (NumberFormatException ex ) {
                    isUpdating = true; // Cambiamos isUpdating a verdadero antes de actualizar la celda
                    customModel.setValueAt("", row, column); // Limpiar la celda si no es un número
                    JOptionPane.showMessageDialog(null, "No pueden ingresarse letras", "Error", JOptionPane.ERROR_MESSAGE); // Mostrar un mensaje de error
                    isUpdating = false; // Cambiamos isUpdating a falso después de actualizar la celda
                }
            }
        }
    }
});
    
    tabla.setModel(customModel);
     }
     
     private void checkFields() {
        // Verificar si todos los campos están llenos y habilitar el botón en consecuencia
        if (this.VistaCrearJornadas.jdcFecha.getDate() == null) {
            this.VistaCrearJornadas.btnCrearPartido.setEnabled(false);
        } else {
            this.VistaCrearJornadas.btnCrearPartido.setEnabled(true);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("date".equals(evt.getPropertyName())) {
            checkFields();
        }
    }


}