/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 *
 * @author yan
 */
public class ExerciceRubberBanding extends javax.swing.JFrame {
    
    //Tous les etat de notre Automate
    private enum State {
        INIT, //etat initial
        DRAW_POINT,
        DRAW_LINE
    }
    
    /* l'etat en cours */
    private State etatEnCours;
    
    /* les dernières coordonnées de la souris */
    private int lastX,lastY;
    
    private int actualX,actualY;
    
    private Color colorLine;
    
    /**
     * Creates new form ExerciceRubberBanding
     */
    public ExerciceRubberBanding() {
        initComponents();
        init();
    }
    
    public void init(){
        this.lastX =0;
        this.lastY =0;
        this.actualX=0;
        this.actualY=0;
        changeState(State.INIT);
    }
    
    public void changeLastPosition(int x, int y){
        this.lastX = x;
        this.lastY = y;
    }
    
    public void changeActualPosition(int x, int y){
        this.actualX = x;
        this.actualY = y;
    }
    
    public void etatInit(MouseEvent evt){
        changeLastPosition(evt.getX(),evt.getY());
        changeState(State.INIT);
    }
    
    public void etatDrawBlackLine(MouseEvent evt){
        changeActualPosition(evt.getX(),evt.getY());
        changeColorLine(Color.BLACK);
        repaint();
        changeState(State.DRAW_LINE);
    }
    
    public void etatDrawRedLine(MouseEvent evt){
        changeActualPosition(evt.getX(),evt.getY());
        changeColorLine(Color.RED);
        repaint();
        changeState(State.INIT);
    }
    
    public void etatDrawPoint(MouseEvent evt){
        changeLastPosition(evt.getX(),evt.getY());
        changeActualPosition(evt.getX(),evt.getY());
        changeState(State.DRAW_POINT);
    }
    
    public void removeLine(){
        changeColorLine(Color.WHITE);
        repaint();
    }
    
    
    public void changeColorLine(Color color){
        this.colorLine = color;
    }
    
    /* Permet de changer d'état */
    public void changeState(State state){
        this.etatEnCours = state;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        System.out.println("PRESSED : "+etatEnCours);
        switch(this.etatEnCours){
            case INIT:
                etatDrawPoint(evt);
                break;
            case DRAW_POINT:
                /* Interdit */
                break;
            case DRAW_LINE:
                /* Interdit */
                break;
            default:
                /* Interdit */
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        System.out.println("RELEASED : "+etatEnCours);
        switch(this.etatEnCours){
            case INIT:
                /* Interdit */
                break;
            case DRAW_POINT:
                etatDrawRedLine(evt);
                break;
            case DRAW_LINE:
                removeLine();
                etatDrawRedLine(evt);
                break;
            default:
                /* Interdit */
        }
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        System.out.println("MOVED : "+etatEnCours);        
        switch(this.etatEnCours){
            case INIT:
                etatInit(evt);
                break;
            case DRAW_POINT:
                etatDrawBlackLine(evt);
                break;
            case DRAW_LINE:;
                removeLine();
              
                etatDrawBlackLine(evt);
                break;
            default:
                /* Interdit */
        }
    }//GEN-LAST:event_formMouseDragged

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(colorLine);
        g.drawLine(lastX, lastY, actualX, actualY);
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
            java.util.logging.Logger.getLogger(ExerciceRubberBanding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExerciceRubberBanding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExerciceRubberBanding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExerciceRubberBanding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExerciceRubberBanding().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
