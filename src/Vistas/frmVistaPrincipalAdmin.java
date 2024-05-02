
package Vistas;

import Modelos.ModelosParticipantesL;
import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

public class frmVistaPrincipalAdmin extends javax.swing.JFrame {

    /**
     * Creates new form frmVistaPrincipal
     */
    public frmVistaPrincipalAdmin() {
        
        
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);//maximiza la ventana en la que se ejecuta este código, haciéndola ocupar todo el espacio disponible en la pantalla del usuario.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        VentanaPrin = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mbarMenu = new javax.swing.JMenu();
        submnLiga = new javax.swing.JMenuItem();
        mbarGestionPartidos = new javax.swing.JMenu();
        submnCreaJornada = new javax.swing.JMenuItem();
        submnIngresoResultado = new javax.swing.JMenuItem();
        submnVerJornada = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemVerUsuarios = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VentanaPrin.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout VentanaPrinLayout = new javax.swing.GroupLayout(VentanaPrin);
        VentanaPrin.setLayout(VentanaPrinLayout);
        VentanaPrinLayout.setHorizontalGroup(
            VentanaPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 888, Short.MAX_VALUE)
        );
        VentanaPrinLayout.setVerticalGroup(
            VentanaPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        mbarMenu.setText("Menu");

        submnLiga.setText("Ligas");
        submnLiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submnLigaActionPerformed(evt);
            }
        });
        mbarMenu.add(submnLiga);

        jMenuBar1.add(mbarMenu);

        mbarGestionPartidos.setText("Gestión de Partidos");

        submnCreaJornada.setText("Creacion de Jornadas");
        submnCreaJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submnCreaJornadaActionPerformed(evt);
            }
        });
        mbarGestionPartidos.add(submnCreaJornada);

        submnIngresoResultado.setText("Ingreso de Resultados");
        submnIngresoResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submnIngresoResultadoActionPerformed(evt);
            }
        });
        mbarGestionPartidos.add(submnIngresoResultado);

        submnVerJornada.setText("Ver Jornadas");
        submnVerJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submnVerJornadaActionPerformed(evt);
            }
        });
        mbarGestionPartidos.add(submnVerJornada);

        jMenuBar1.add(mbarGestionPartidos);

        jMenu2.setText("Gestión de Usuarios");

        itemVerUsuarios.setText("VerUsuarios");
        itemVerUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVerUsuariosActionPerformed(evt);
            }
        });
        jMenu2.add(itemVerUsuarios);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Ayuda");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VentanaPrin, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VentanaPrin, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submnLigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submnLigaActionPerformed
        /*// TODO add your handling code here:
        frmLigas VistaLigas = new frmLigas();
        VistaLigas.setVisible(true);
       
        // Obtener el tamaño de la ventana principal
        Dimension ventanaPrinSize = VentanaPrin.getSize();

        // Calcular las coordenadas para centrar la ventana secundaria en la ventana principal
        int x = (ventanaPrinSize.width - VistaLigas.getWidth()) / 2;
        int y = (ventanaPrinSize.height - VistaLigas.getHeight()) / 2;

        // Establecer la ubicación de la ventana secundaria centrada en la ventana principal
        VistaLigas.setLocation(x, y);

       VentanaPrin.add(VistaLigas);
        //CentrarVentana(VistaLigas); */
        
        /*frmMenu VistaLigas = new frmMenu();
        VistaLigas.setVisible(true);
       
        // Obtener el tamaño de la ventana principal
        Dimension ventanaPrinSize = VentanaPrin.getSize();

        // Calcular las coordenadas para centrar la ventana secundaria en la ventana principal
        int x = (ventanaPrinSize.width - VistaLigas.getWidth()) / 2;
        int y = (ventanaPrinSize.height - VistaLigas.getHeight()) / 2;

        // Establecer la ubicación de la ventana secundaria centrada en la ventana principal
        VistaLigas.setLocation(x, y);

       VentanaPrin.add(VistaLigas);
        //CentrarVentana(VistaLigas);*/
        
    }//GEN-LAST:event_submnLigaActionPerformed

    private void submnCreaJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submnCreaJornadaActionPerformed
        // TODO add your handling code here:
        
        frmCreacionJornadas VistaCreaJornada = new frmCreacionJornadas();
        VistaCreaJornada.setVisible(true);
       
        // Obtener el tamaño de la ventana principal
        Dimension ventanaPrinSize = VentanaPrin.getSize();

        // Calcular las coordenadas para centrar la ventana secundaria en la ventana principal
        int x = (ventanaPrinSize.width - VistaCreaJornada.getWidth()) / 2;
        int y = (ventanaPrinSize.height - VistaCreaJornada.getHeight()) / 2;

        // Establecer la ubicación de la ventana secundaria centrada en la ventana principal
        VistaCreaJornada.setLocation(x, y);

       VentanaPrin.add(VistaCreaJornada);
    }//GEN-LAST:event_submnCreaJornadaActionPerformed

    private void submnVerJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submnVerJornadaActionPerformed
        // TODO add your handling code here:
       
        frmVerJornada VistaVerJornada = new frmVerJornada();
        VistaVerJornada.setVisible(true);
       
        // Obtener el tamaño de la ventana principal
        Dimension ventanaPrinSize = VentanaPrin.getSize();

        // Calcular las coordenadas para centrar la ventana secundaria en la ventana principal
        int x = (ventanaPrinSize.width - VistaVerJornada.getWidth()) / 2;
        int y = (ventanaPrinSize.height - VistaVerJornada.getHeight()) / 2;

        // Establecer la ubicación de la ventana secundaria centrada en la ventana principal
        VistaVerJornada.setLocation(x, y);

       VentanaPrin.add(VistaVerJornada);
    }//GEN-LAST:event_submnVerJornadaActionPerformed

    private void submnIngresoResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submnIngresoResultadoActionPerformed
        // TODO add your handling code here:
        
        frmResultadosAdmin VistaResultadosAdmin = new frmResultadosAdmin();
        VistaResultadosAdmin.setVisible(true);
       
        // Obtener el tamaño de la ventana principal
        Dimension ventanaPrinSize = VentanaPrin.getSize();

        // Calcular las coordenadas para centrar la ventana secundaria en la ventana principal
        int x = (ventanaPrinSize.width - VistaResultadosAdmin.getWidth()) / 2;
        int y = (ventanaPrinSize.height - VistaResultadosAdmin.getHeight()) / 2;

        // Establecer la ubicación de la ventana secundaria centrada en la ventana principal
        VistaResultadosAdmin.setLocation(x, y);

       VentanaPrin.add(VistaResultadosAdmin);    
    }//GEN-LAST:event_submnIngresoResultadoActionPerformed

    private void itemVerUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVerUsuariosActionPerformed
          Participantes part = new Participantes();
          ModelosParticipantesL modelo = new ModelosParticipantesL();
          DefaultTableModel TablaModelo2 = modelo.ListarParticipantes();
          part.Tabla.setModel(TablaModelo2);
          part.setVisible(true);
          part.setLocationRelativeTo(null);
    }//GEN-LAST:event_itemVerUsuariosActionPerformed

    void CentrarVentana(Frame frame){
        VentanaPrin.add(frame);
        Dimension dimension = VentanaPrin.getSize();
        Dimension frameVentana = frame.getSize();
        int x = (dimension.width - frameVentana.width) / 2;
        int y = (dimension.height - frameVentana.height) / 2;
        frame.setLocation(x, y);
        frame.setVisible(true);
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmVistaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVistaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVistaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVistaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVistaPrincipalAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane VentanaPrin;
    private javax.swing.JMenuItem itemVerUsuarios;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mbarGestionPartidos;
    private javax.swing.JMenu mbarMenu;
    private javax.swing.JMenuItem submnCreaJornada;
    private javax.swing.JMenuItem submnIngresoResultado;
    private javax.swing.JMenuItem submnLiga;
    private javax.swing.JMenuItem submnVerJornada;
    // End of variables declaration//GEN-END:variables
}
