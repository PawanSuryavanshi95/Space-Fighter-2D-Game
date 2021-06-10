package com.spacefighter.screens;


import com.spacefighter.utils.API;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author pawan
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private final String ENDPOINT = "http://127.0.0.1:5000/";
    private String token = "";
    private API api;
    
    public Login() {
        initComponents();
        
        api = new API(ENDPOINT);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        this.jPanel1.setBackground(new Color(0,0,0,0));
        this.jPanel2.setEnabled(false);
        this.jPanel2.setVisible(false);
        this.jPanel3.setEnabled(true);
        this.jPanel3.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Username");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTextField4.setBackground(new java.awt.Color(37, 23, 66));
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(204, 204, 204));
        jTextField4.setBorder(null);
        jTextField4.setCaretColor(new java.awt.Color(204, 204, 204));
        jTextField4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 370, 40));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator4.setFont(new java.awt.Font("Tahoma", 0, 5)); // NOI18N
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 370, 15));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jTextField5.setBackground(new java.awt.Color(37, 23, 66));
        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(204, 204, 204));
        jTextField5.setBorder(null);
        jTextField5.setCaretColor(new java.awt.Color(204, 204, 204));
        jTextField5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 370, 40));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setFont(new java.awt.Font("Tahoma", 0, 5)); // NOI18N
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 370, 15));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/register/btnlogin.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel12MousePressed(evt);
            }
        });
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 140, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 400, 480));

        jPanel2.setEnabled(false);
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTextField1.setBackground(new java.awt.Color(37, 23, 66));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 204, 204));
        jTextField1.setBorder(null);
        jTextField1.setCaretColor(new java.awt.Color(204, 204, 204));
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 370, 40));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 5)); // NOI18N
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 370, 15));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jTextField2.setBackground(new java.awt.Color(37, 23, 66));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(204, 204, 204));
        jTextField2.setBorder(null);
        jTextField2.setCaretColor(new java.awt.Color(204, 204, 204));
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 370, 40));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setFont(new java.awt.Font("Tahoma", 0, 5)); // NOI18N
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 370, 15));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Confirm Password");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jTextField3.setBackground(new java.awt.Color(37, 23, 66));
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(204, 204, 204));
        jTextField3.setBorder(null);
        jTextField3.setCaretColor(new java.awt.Color(204, 204, 204));
        jTextField3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 370, 40));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setFont(new java.awt.Font("Tahoma", 0, 5)); // NOI18N
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 370, 15));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/register/btnsignUp.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 140, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 400, 480));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/register/btnLoginSwitch.png"))); // NOI18N
        jLabel4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel4FocusGained(evt);
            }
        });
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, 140, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/register/btnSignUpSwitch.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 140, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/register/rightPanel (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 580, 700));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/register/leftPanelBack.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 560, 700));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 19, 1180, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        this.jPanel3.setEnabled(false);
        this.jPanel3.setVisible(false);
        this.jPanel2.setEnabled(true);
        this.jPanel2.setVisible(true);
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel4FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4FocusGained

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        this.jPanel2.setEnabled(false);
        this.jPanel2.setVisible(false);
        this.jPanel3.setEnabled(true);
        this.jPanel3.setVisible(true);
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
        String data_out = "{\"username\":\"" + this.jTextField4.getText() + "\",\"password\":\"" + this.jTextField5.getText() + "\"" + "}";
        String data_in = api.postRequest("login", data_out);
        
        System.out.println(data_in);
        String[] data = data_in.split(";");
        
        if(data[0].equals("1")){
            System.out.println("Logged in");
            token = data[1];
            Menu menu = new Menu(token);
            this.dispose();
            menu.setVisible(true);
        }
        else{
            System.out.println("not logged in");
        }
    }//GEN-LAST:event_jLabel12MousePressed

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        String username, pass, pass2;
        username = this.jTextField1.getText();
        pass = this.jTextField2.getText();
        pass2 = this.jTextField3.getText();
        System.out.println(pass);
        System.out.println(pass2);
        if(!pass.equals(pass2)){
            System.out.println("Passwords don't match");
        }
        else{
            String data_out = "{\"username\":\"" + username + "\",\"password\":\"" + pass + "\"" + "}";
            String data_in = api.postRequest("register", data_out);
            System.out.println(data_in);
        }
    }//GEN-LAST:event_jLabel8MousePressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
