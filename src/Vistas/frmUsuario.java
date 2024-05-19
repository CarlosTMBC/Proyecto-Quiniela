
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

public class frmUsuario extends javax.swing.JFrame {

    /**
     * Creates new form frmVistaPrincipal
     */
    public frmUsuario() {
        
        
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
        iQuiniela = new javax.swing.JMenuItem();
        iResultadosQuiniela = new javax.swing.JMenuItem();

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

        mbarGestionPartidos.setText("Gestion de Quiniela");

        iQuiniela.setText("Quiniela");
        iQuiniela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iQuinielaActionPerformed(evt);
            }
        });
        mbarGestionPartidos.add(iQuiniela);

        iResultadosQuiniela.setText("Resultados de Quiniela");
        iResultadosQuiniela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iResultadosQuinielaActionPerformed(evt);
            }
        });
        mbarGestionPartidos.add(iResultadosQuiniela);

        jMenuBar1.add(mbarGestionPartidos);

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

    private void iQuinielaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iQuinielaActionPerformed

    }//GEN-LAST:event_iQuinielaActionPerformed

    private void iResultadosQuinielaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iResultadosQuinielaActionPerformed

    }//GEN-LAST:event_iResultadosQuinielaActionPerformed


    
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
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane VentanaPrin;
    public javax.swing.JMenuItem iQuiniela;
    public javax.swing.JMenuItem iResultadosQuiniela;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mbarGestionPartidos;
    // End of variables declaration//GEN-END:variables
}
