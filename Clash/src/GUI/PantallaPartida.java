/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import clash.Defensa;
import clash.Guerrero;
import clash.Juego;
import clash.Personaje;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Jean Paul
 */
public class PantallaPartida extends javax.swing.JFrame {
    Juego juego;
    Juego copia;
    public ArrayList<JLabel> arregloLabels;
    int index;  
    PantallaMenu pantalla;
    
    /**
     * Creates new form PantallaPartida
     */
    
    public PantallaPartida() {
        arregloLabels = new ArrayList<JLabel>();
        initComponents();
    }
    
    public void putJuego(Juego juego){
        this.juego = juego;
        juego.refPantalla = this;
        lblNivel.setText("Nivel " + juego.getNivel());
        copia = juego;
        juego.correr();
    }

   
    
    public void generateLabel(Personaje p){
        JLabel newLabel = new JLabel(p.getName());
        newLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        
        try{
            p = (Defensa) p;
        }
        catch(Exception e){
            if (p.isAliado())
                newLabel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLUE,2));
            else 
                newLabel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED,2));
        }
        newLabel.setSize(40, 40);
        jPanel1.add(newLabel);
       
        
        int x = ((new Random()).nextInt(1000)/40) * 40;
        int y = ((new Random()).nextInt(600) / 40)* 40;
        newLabel.setLocation(x , y);
        Point punto = new Point(x,y);
        p.setPosicion(punto);
        try{
            File f = new File(p.getImg1());
            BufferedImage img = null;
            img  = ImageIO.read(new File(f.getAbsolutePath()));
            Image img1 = img.getScaledInstance(newLabel.getWidth(), newLabel.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon format = new ImageIcon(img1);
            newLabel.setIcon(format);
        }
        catch(Exception e){
            //return newLabel;
        }
        try{
            arregloLabels.add(p.num ,newLabel);
        //return newLabel;
        }catch (Exception e){
            arregloLabels.add(newLabel);
        }
        
        
    }
    
    public boolean compararPoint(Point p){ //True si la casilla esta descoupada
        int num = 2;
        for (int i = 0; i < this.juego.getDefensa().size(); i++) {
            if(this.juego.getDefensa().get(i).getPosicion() == p) 
                return false;
        }
        for (int i = 0; i < this.juego.getEjercito().size(); i++) {
            if(this.juego.getEjercito().get(i).getPosicion() == p) 
                return false;
        }
        for (int i = 0; i < this.juego.getEnemigo().size(); i++) {
            if(this.juego.getEnemigo().get(i).getPosicion() == p) 
                return false;
        }
        return true;
    }
    
    public boolean moveLabeltoObjective2 (Guerrero g, int num){ //retorna true cuando esta en rango
        if ((abs(  g.getPosicion().x - g.getObjetivo().getPosicion().x)) <= 40 * g.getRange() || abs(g.getPosicion().y - g.getObjetivo().getPosicion().y) <= 40 * g.getRange()){
            g.inRange = true;
            return true;
        }
        else if ((abs(g.getPosicion().x - g.getObjetivo().getPosicion().x)) >= (abs(g.getPosicion().y - g.getObjetivo().getPosicion().y))){
            if ((g.getPosicion().x - g.getObjetivo().getPosicion().x) < 0){
                movLabel(g, 'i', num);
                return false;
            }
            else{
                movLabel(g, 'd', num);
                return false;
            }
        }
        else{
            if ((g.getPosicion().y - g.getObjetivo().getPosicion().y) < 0){
                movLabel(g, 'b', num);
                return false;
            }
            else{
                movLabel(g, 'a', num);
                return false;
            }
        }
    }
    
    public boolean moveLabeltoObjective (Guerrero g, int num){ //retorna true cuando esta en rango
        if ((abs(  g.getPosicion().x - g.getObjetivo().getPosicion().x)) <= 40 * g.getRange() || abs(g.getPosicion().y - g.getObjetivo().getPosicion().y) <= 40 * g.getRange()){
            g.inRange = true;
            return true;
        }
        else if (abs(g.getPosicion().x - g.getObjetivo().getPosicion().x) > 40 * g.getRange()){
           
            if (g.getPosicion().x > g.getObjetivo().getPosicion().x){
                movLabel(g, 'i', num);
                return true;
            }
            else{
                movLabel(g, 'd', num);
                return true;
            }
        }
        else if (abs(g.getPosicion().y - g.getObjetivo().getPosicion().y) > 40 * g.getRange()){
           
            if (g.getPosicion().y > g.getObjetivo().getPosicion().y){
                movLabel(g, 'b', num);
                return true;
            }
            else{
                movLabel(g, 'a', num);
                return true;
            }
        }
        else return false;
    }
    
   public void movLabel (Guerrero g, char direccion, int num){
       switch(direccion){
           case 'a': 
               int y = arregloLabels.get(num).getLocation().y + 40;
               int x = arregloLabels.get(num).getLocation().x;
               g.setPosicion(new Point(x,y));
               arregloLabels.get(num).setLocation(x, y);
           case 'b': 
               int y1 = arregloLabels.get(num).getLocation().y - 40;
               int x1 = arregloLabels.get(num).getLocation().x;
               g.setPosicion(new Point(x1,y1));
               arregloLabels.get(num).setLocation(x1, y1);
           case 'd': 
               int y2 = arregloLabels.get(num).getLocation().y;
               int x2 = arregloLabels.get(num).getLocation().x + 40;
               g.setPosicion(new Point(x2,y2));
               arregloLabels.get(num).setLocation(x2, y2);
           case 'i': 
               int y3 = arregloLabels.get(num).getLocation().y;
               int x3 = arregloLabels.get(num).getLocation().x - 40;
               g.setPosicion(new Point(x3,y3));
               arregloLabels.get(num).setLocation(x3, y3);;
       }    
       
   }
    
    
    public int isAvailablePostion(int x, int y, JLabel refLabel){      
        for (int i = 0; i < arregloLabels.size(); i++) {
            if(arregloLabels.get(i).getLocation().x == x && 
                    arregloLabels.get(i).getLocation().y == y
                        && !arregloLabels.get(i).equals(refLabel))
                return i;
        }
        return -1;
    }
    
    
    public void setPantalla(PantallaMenu pantalla){
        this.pantalla = pantalla;
    }
    
    
    public void volverMenu(){
        setVisible(false);
        PantallaMenu pantalla = new PantallaMenu();
        pantalla.setVisible(true);
        pantalla.putJuego(juego);
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
        jPanel2 = new javax.swing.JPanel();
        btnReelegir = new javax.swing.JButton();
        btnAvanzar = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        lblNivel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        btnReelegir.setText("Reelegir Tropas");
        btnReelegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReelegirActionPerformed(evt);
            }
        });

        btnAvanzar.setText("Avanzar Nivel");
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });

        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        lblNivel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNivel.setText("Nivel");
        lblNivel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvanzar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(btnReelegir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReelegir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(455, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        juego.stopGuerreros();
        juego.nextLevel();
        volverMenu();
    }//GEN-LAST:event_btnAvanzarActionPerformed

    private void btnReelegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReelegirActionPerformed
        juego.inicializar();
    }//GEN-LAST:event_btnReelegirActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        juego.reiniciar = true;
        setVisible(false);
        putJuego(copia);
        setVisible(true);
    }//GEN-LAST:event_btnReiniciarActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPartida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzar;
    private javax.swing.JButton btnReelegir;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNivel;
    // End of variables declaration//GEN-END:variables
}
