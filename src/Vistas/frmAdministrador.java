
package Vistas;

import Modelos.*;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.Vector;
import javax.swing.*;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class frmAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form frmVistaPrincipal
     */
    public frmAdministrador() {
        
        
        initComponents();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        VentanaPrin = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mbarGestionPartidos = new javax.swing.JMenu();
        iCrearJornadas = new javax.swing.JMenuItem();
        iIngresoResultados = new javax.swing.JMenuItem();
        iVerJornadas = new javax.swing.JMenuItem();
        lol = new javax.swing.JMenu();
        iVerUsuarios = new javax.swing.JMenuItem();
        iBoletin = new javax.swing.JMenuItem();

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

        mbarGestionPartidos.setText("Gestión de Partidos");

        iCrearJornadas.setText("Creacion de Jornadas");
        iCrearJornadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iCrearJornadasActionPerformed(evt);
            }
        });
        mbarGestionPartidos.add(iCrearJornadas);

        iIngresoResultados.setText("Ingreso de Resultados");
        iIngresoResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iIngresoResultadosActionPerformed(evt);
            }
        });
        mbarGestionPartidos.add(iIngresoResultados);

        iVerJornadas.setText("Ver Jornadas");
        iVerJornadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iVerJornadasActionPerformed(evt);
            }
        });
        mbarGestionPartidos.add(iVerJornadas);

        jMenuBar1.add(mbarGestionPartidos);

        lol.setText("Gestión de Usuarios");

        iVerUsuarios.setText("VerUsuarios");
        iVerUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iVerUsuariosActionPerformed(evt);
            }
        });
        lol.add(iVerUsuarios);

        iBoletin.setText("BoletinQuiniela");
        lol.add(iBoletin);

        jMenuBar1.add(lol);

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

    private void iCrearJornadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iCrearJornadasActionPerformed

    }//GEN-LAST:event_iCrearJornadasActionPerformed

    private void iVerJornadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iVerJornadasActionPerformed

    }//GEN-LAST:event_iVerJornadasActionPerformed

    private void iIngresoResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iIngresoResultadosActionPerformed

    }//GEN-LAST:event_iIngresoResultadosActionPerformed

    private void iVerUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iVerUsuariosActionPerformed
          
    }//GEN-LAST:event_iVerUsuariosActionPerformed


    
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
            java.util.logging.Logger.getLogger(frmAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane VentanaPrin;
    public javax.swing.JMenuItem iBoletin;
    public javax.swing.JMenuItem iCrearJornadas;
    public javax.swing.JMenuItem iIngresoResultados;
    public javax.swing.JMenuItem iVerJornadas;
    public javax.swing.JMenuItem iVerUsuarios;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenu lol;
    private javax.swing.JMenu mbarGestionPartidos;
    // End of variables declaration//GEN-END:variables
}
