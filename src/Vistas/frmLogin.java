/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Modelos.GestorPass;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danie
 */
public class frmLogin extends javax.swing.JFrame {
    private static frmLogin loginVentana;
    private static frmRegistro registroVentana;
    private static frmAdministrador adminVentana;
    /**
     * Creates new form frmLogin
     */
    public frmLogin() {
        //soy el original xd 
        initComponents();
        setLocationRelativeTo(null);
    }
    public static frmLogin getInstance() {
        if (loginVentana == null) {
            loginVentana = new frmLogin();
        }
        return loginVentana;
    }
     public void setAdminVentana(frmAdministrador adminVentana) {
        this.adminVentana = adminVentana;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblBienvenido1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblUsuario1 = new javax.swing.JLabel();
        txtUsuario1 = new javax.swing.JTextField();
        lblContraseña1 = new javax.swing.JLabel();
        txtContraseña1 = new javax.swing.JPasswordField();
        btnIngresar1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCrearCuenta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        lblBienvenido1.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        lblBienvenido1.setText("¡¡¡ BIENVENIDO!!!");

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblUsuario1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        lblUsuario1.setText("USUARIO");

        txtUsuario1.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        lblContraseña1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        lblContraseña1.setText("CONTRASEÑA");

        txtContraseña1.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        btnIngresar1.setBackground(new java.awt.Color(153, 204, 255));
        btnIngresar1.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        btnIngresar1.setText("INGRESAR");
        btnIngresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUsuario1)
                .addGap(95, 95, 95))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario1)
                            .addComponent(txtContraseña1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(lblContraseña1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnIngresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblUsuario1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblContraseña1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContraseña1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIngresar1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBienvenido1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblBienvenido1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 131, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(251, 252, 253));
        jPanel4.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel4.setPreferredSize(new java.awt.Dimension(830, 447));
        jPanel4.setLayout(null);

        btnIngresar.setBackground(new java.awt.Color(242, 242, 242));
        btnIngresar.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(102, 102, 102));
        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel4.add(btnIngresar);
        btnIngresar.setBounds(610, 340, 90, 30);

        txtUser.setBackground(new java.awt.Color(251, 252, 253));
        txtUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUser.setToolTipText("");
        txtUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(127, 219, 228)));
        txtUser.setName(""); // NOI18N
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserMouseClicked(evt);
            }
        });
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        jPanel4.add(txtUser);
        txtUser.setBounds(480, 150, 290, 18);
        txtUser.getAccessibleContext().setAccessibleName("");

        txtPass.setBackground(new java.awt.Color(251, 252, 253));
        txtPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(127, 219, 228)));
        txtPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassMouseClicked(evt);
            }
        });
        jPanel4.add(txtPass);
        txtPass.setBounds(480, 240, 290, 18);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("CONTRASEÑA");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(480, 210, 100, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("USUARIO");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(480, 120, 80, 17);

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Iniciar Sesión");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(480, 50, 140, 29);

        btnCrearCuenta.setBackground(new java.awt.Color(242, 242, 242));
        btnCrearCuenta.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        btnCrearCuenta.setForeground(new java.awt.Color(102, 102, 102));
        btnCrearCuenta.setText("Registrarse");
        btnCrearCuenta.setBorderPainted(false);
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaActionPerformed(evt);
            }
        });
        jPanel4.add(btnCrearCuenta);
        btnCrearCuenta.setBounds(150, 380, 130, 30);

        jLabel1.setBackground(new java.awt.Color(134, 164, 195));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/soccer.jpg"))); // NOI18N
        jLabel1.setOpaque(true);
        jPanel4.add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 440);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar1ActionPerformed
        this.setVisible(false); // Oculta la ventana de login
        if (adminVentana == null) {
            adminVentana = frmAdministrador.getInstance();
        }
        else{
        adminVentana.setVisible(true); // Muestra la ventana de administrador
        }
    }//GEN-LAST:event_btnIngresar1ActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
     
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMouseClicked
        // TODO add your handling code here:
        txtUser.setText("");//Esta linea limpia lo que se ha ingresado en el cajon de texto
    }//GEN-LAST:event_txtUserMouseClicked

    private void txtPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassMouseClicked
        // TODO add your handling code here:
        txtPass.setText("");//Esta linea limpia lo que se ha ingresado en el cajon de texto
    }//GEN-LAST:event_txtPassMouseClicked

    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
    this.setVisible(false); // Oculta la ventana de login
    if (registroVentana == null)
    {
        registroVentana = frmRegistro.getInstance();
    }
    else
    {
        registroVentana.setVisible(true); // Muestra la ventana de registro
    }

    }//GEN-LAST:event_btnCrearCuentaActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCrearCuenta;
    public javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnIngresar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblBienvenido1;
    private javax.swing.JLabel lblContraseña1;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JPasswordField txtContraseña1;
    public javax.swing.JPasswordField txtPass;
    public javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtUsuario1;
    // End of variables declaration//GEN-END:variables
}
