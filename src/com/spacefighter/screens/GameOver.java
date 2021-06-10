package com.spacefighter.screens;


import com.spacefighter.game.Game;
import com.spacefighter.utils.API;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pawan
 */
public class GameOver extends javax.swing.JFrame {

    /**
     * Creates new form GameOver
     */
    private int score, kills, highScore = Integer.MAX_VALUE, bestKills = Integer.MAX_VALUE;
    private String token;
    private static final Object[] columnNames = {"Id", "Rank", "Name", "Score", "Kills"};
    private static final Object[][] rowData = {};
    private final String ENDPOINT = "http://127.0.0.1:5000/";//private final String ENDPOINT = "https://space-fighter-backend.herokuapp.com/";
    private API api;
    
    public GameOver(int score, int kills, String token) {
        initComponents();
        
        this.score = score;
        this.kills = kills;
        this.token = token;
        
        api = new API(ENDPOINT);
        
        this.jLabel2.setText(this.jLabel2.getText() + String.valueOf(score));
        this.setBounds(0, 0, 1000, 670);
        this.setMaximumSize(new Dimension(1000,670));
        this.setMinimumSize(new Dimension(1000,670));
        this.setLocationRelativeTo(null);
        this.play.setBackground( new Color(255, 255, 255, 255) );
        this.setResizable(false);
        
        DefaultTableModel listTableModel = new DefaultTableModel(rowData, columnNames);
        this.jTable1.setModel(listTableModel);
        this.jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        this.jTable1.getTableHeader().setOpaque(false);
        this.jTable1.getTableHeader().setBackground(new Color(230, 219, 255));
        this.jTable1.getTableHeader().setForeground(new Color(47,39,66));
        this.jTable1.setRowHeight(25);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        this.jTable1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        play = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(47, 39, 66));
        setMinimumSize(new java.awt.Dimension(418, 337));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(47, 39, 66));
        jPanel2.setMaximumSize(new java.awt.Dimension(460, 408));
        jPanel2.setMinimumSize(new java.awt.Dimension(460, 408));
        jPanel2.setPreferredSize(new java.awt.Dimension(460, 408));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 45)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Score : ");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(300, 160, 220, 55);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 65)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Game Over");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(330, 20, 360, 80);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(10, 117, 1000, 7);

        play.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        play.setText("Play Again");
        play.setDoubleBuffered(true);
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                playMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playMouseEntered(evt);
            }
        });
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        jPanel2.add(play);
        play.setBounds(660, 150, 180, 70);

        jScrollPane1.setFocusable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(204, 204, 204));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(137, 115, 189));
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTable1ComponentAdded(evt);
            }
        });
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable1ComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(70, 270, 580, 320);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel3);
        jLabel3.setBounds(850, 280, 100, 60);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Personal Best :");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(740, 280, 100, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseEntered

    }//GEN-LAST:event_playMouseEntered

    private void playMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseExited

    }//GEN-LAST:event_playMouseExited

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        this.dispose();
        Game game = new Game("Space Fighter",550,750,150, token);
        game.start();
    }//GEN-LAST:event_playActionPerformed

    private void jTable1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTable1ComponentAdded
       // TODO add your handling code here:
    }//GEN-LAST:event_jTable1ComponentAdded

    private void jTable1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentShown
        
    }//GEN-LAST:event_jTable1ComponentShown

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Retreiving Highscores
        String data_out = "{\"token\":\"" + "pawan" + "\"" + "}";
        String data_in = api.postRequest("highscores", data_out);
        
        String[] data = data_in.split("#");
        DefaultTableModel listTableModel = new DefaultTableModel(rowData, columnNames);

        highScore = Integer.parseInt(data[data.length-1].split(";")[0]);
        bestKills = Integer.parseInt(data[data.length-1].split(";")[1]);

        for (int i=0;i<(data.length-1);i++) {
            String[] values = data[i].split(";");
            listTableModel.addRow(new Object[]{"none",i+1, values[2], values[0], values[1]});
        }
        this.jTable1.setModel(listTableModel);
        
        // Uploading Highscore
        if(highScore<score || (highScore==score && bestKills<kills)){
            
            System.out.println("uploading ...");
            data_out = "{\"score\":\"" + Integer.toString(score) + "\",\"kills\":\"" + Integer.toString(kills) + "\",\"token\":\"" + "pawan" + "\"" + "}";
            data_in = api.postRequest("upload", data_out);
            
            System.out.println(data_in);
        }
        this.jLabel3.setText(Integer.toString(highScore) + Integer.toString(bestKills));
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameOver(0,0,"").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton play;
    // End of variables declaration//GEN-END:variables
}