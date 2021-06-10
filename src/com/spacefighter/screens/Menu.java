package com.spacefighter.screens;

/**
 *
 * @author Pawan Suryavanshi
 */

import com.spacefighter.game.Game;
import java.awt.Color;

public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form MEnu
     */
    private String token;
    
    public Menu(String token) {
        initComponents();
        this.token = token;
        this.title1.setBackground( new Color(231, 245, 174, 100) );
        this.title2.setBackground( new Color(255, 176, 184, 100) );
        this.play.setBackground( new Color(255, 176, 184, 100) );
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title1 = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        play = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        title1.setFont(new java.awt.Font("Tahoma", 0, 90)); // NOI18N
        title1.setForeground(new java.awt.Color(232, 255, 135));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("Space");
        title1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        title1.setOpaque(true);
        getContentPane().add(title1);
        title1.setBounds(100, 90, 290, 130);

        title2.setBackground(new java.awt.Color(255, 255, 255));
        title2.setFont(new java.awt.Font("Tahoma", 0, 90)); // NOI18N
        title2.setForeground(new java.awt.Color(255, 87, 103));
        title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title2.setText("Fighter");
        title2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        title2.setOpaque(true);
        getContentPane().add(title2);
        title2.setBounds(390, 90, 320, 130);

        play.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        play.setForeground(new java.awt.Color(46, 38, 69));
        play.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        play.setText("Play");
        play.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 38, 69), 5));
        play.setOpaque(true);
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                playMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                playMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playMouseEntered(evt);
            }
        });
        getContentPane().add(play);
        play.setBounds(300, 320, 210, 150);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.gif"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMousePressed
        this.play.setBackground( new Color(250, 117, 130, 200) );
        this.dispose();
        Game game = new Game("Space Fighter",550,750,150, token);
        game.start();
    }//GEN-LAST:event_playMousePressed

    private void playMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseReleased
        
    }//GEN-LAST:event_playMouseReleased

    private void playMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseEntered
        
    }//GEN-LAST:event_playMouseEntered

    private void playMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseExited
        
    }//GEN-LAST:event_playMouseExited

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel play;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    // End of variables declaration//GEN-END:variables
public void setLabel(String val){
    this.title1.setText(val);
}
}
/*
class GameRunner extends Thread {
    private volatile JFrame Menu2;
    public GameRunner(JFrame obj){
        this.Menu2 = obj;
    }
    
    public void run()
    {
        try {
            this.Menu2.dispose();
            
            Game g;
            g = new Game("Space Fighter",550,750,150);
            g.start();
            while(g.isGameRunning()){
                this.sleep(1000);
            }
            
            GameOver gameOver = new GameOver(g.getScore());
            gameOver.setVisible(true);
            gameOver.setLocationRelativeTo(null);
            
            this.join();
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}*/