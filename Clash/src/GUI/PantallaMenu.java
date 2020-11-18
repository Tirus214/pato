/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import clash.Juego;
import filemanager.FileManager;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JComboBox;

/**
 *
 * @author Jean Paul
 */
public class PantallaMenu extends javax.swing.JFrame {
    Juego juego;
    private ArrayList<String> nombreGuerreros;
    private ArrayList<Integer> numeroGuerreros;
    int cantTropas;
    PantallaAdmin pantalla;
    private String seleccion;
    
    /**
     * Creates new form PantallaMenu
     */
    
    public PantallaMenu() {  
        initComponents();
    }
    
    
    public void putJuego(Juego juego){
        this.juego = juego;
        nombreGuerreros = juego.nombreGuerreros;
        numeroGuerreros = juego.numeroGuerreros;
        putComponentes();
    }
    
    public void putComponentes(){
        lblNivel.setText("Nivel actual: " + juego.getNivel() + "");
        cantTropas = juego.getCantTropas();
        lblEjercitoFaltante.setText("Campos de ejercito disponibles: " + cantTropas);
        txfTropasSeleccionadas.setText("");
        addItems();
       
    }
    
    private void addItems(){
        for (int i = 0; i < juego.guerrerosDisponibles.size(); i++) {
            //nombreGuerreros.add(juego.guerrerosDisponibles.get(i).getName());
            cmbGuerreros.addItem(nombreGuerreros.get(i));
            numeroGuerreros.add(0);
        }
    }
    
    
    private void showPropeties(){
        for (int i = 0; i < juego.guerrerosDisponibles.size(); i++) {
            if(juego.guerrerosDisponibles.get(i).getName() == seleccion){
                txfEspecificaciones.setText("Nombre: " + juego.guerrerosDisponibles.get(i).getName());
                txfEspecificaciones.append("\nDaño: " + juego.guerrerosDisponibles.get(i).getDamage() + "golpes por segundo");
                txfEspecificaciones.append("\nVida: " + juego.guerrerosDisponibles.get(i).getHealth() + "golpes");
                txfEspecificaciones.append("\nNivel: " + juego.guerrerosDisponibles.get(i).getLevel());
                txfEspecificaciones.append("\nRango: " + juego.guerrerosDisponibles.get(i).getRange());
                txfEspecificaciones.append("\nEspacio en ejercito: " + juego.guerrerosDisponibles.get(i).getDamage() + "unidades");
                txfEspecificaciones.append("\nNivel de aparicion: " + juego.guerrerosDisponibles.get(i).getApLevel());
                Icon icono = new Icon() {
                    @Override
                    public void paintIcon(Component cmpnt, Graphics grphcs, int i, int i1) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public int getIconWidth() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public int getIconHeight() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
            }
        }
    }
    
    private void buscarNombre(){
        boolean find = false;
        for (int i = 0; i < nombreGuerreros.size(); i++) {
            if(this.seleccion == nombreGuerreros.get(i)){
                int valor = numeroGuerreros.get(i);
                valor++;
                numeroGuerreros.set(i, valor);
                find = !find;
            }
        }
        if(!find){
            nombreGuerreros.add(seleccion);
            numeroGuerreros.add(1);
        }
    }
    
    private void printGuerreros(){
        for (int i = 0; i < numeroGuerreros.size(); i++) {
            if(numeroGuerreros.get(i) > 0){
                txfTropasSeleccionadas.append("\n" + nombreGuerreros.get(i) + " x" + numeroGuerreros.get(i));
            }
        }
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
        lblNivel = new javax.swing.JLabel();
        btnConfiguracion = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblEjercitoFaltante = new javax.swing.JLabel();
        lblTropas = new javax.swing.JLabel();
        lblSMStropa = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txfEspecificaciones = new javax.swing.JTextArea();
        lblImagenTropa = new javax.swing.JLabel();
        btnIncluir = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        lblEspecificaciones = new javax.swing.JLabel();
        cmbGuerreros = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txfTropasSeleccionadas = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setLayout(null);

        lblNivel.setBackground(new java.awt.Color(102, 153, 0));
        lblNivel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNivel.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(lblNivel);
        lblNivel.setBounds(20, 10, 257, 93);

        btnConfiguracion.setText("Configuracion");
        btnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfiguracion);
        btnConfiguracion.setBounds(60, 640, 130, 25);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(60, 680, 130, 25);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(300, 850, 0, 0);

        lblEjercitoFaltante.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEjercitoFaltante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEjercitoFaltante.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(lblEjercitoFaltante);
        lblEjercitoFaltante.setBounds(340, 120, 340, 34);

        lblTropas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTropas.setText("Guerreros Seleccionados");
        jPanel1.add(lblTropas);
        lblTropas.setBounds(760, 40, 156, 35);

        lblSMStropa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSMStropa.setText("Seleccione una tropa:");
        jPanel1.add(lblSMStropa);
        lblSMStropa.setBounds(240, 200, 125, 16);

        txfEspecificaciones.setColumns(20);
        txfEspecificaciones.setRows(5);
        jScrollPane2.setViewportView(txfEspecificaciones);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(340, 280, 328, 234);

        lblImagenTropa.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(lblImagenTropa);
        lblImagenTropa.setBounds(20, 310, 238, 169);

        btnIncluir.setText("Incluir Guerrero");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnIncluir);
        btnIncluir.setBounds(410, 540, 205, 38);

        btnIniciar.setBackground(new java.awt.Color(255, 51, 51));
        btnIniciar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIniciar.setText("Iniciar Batalla");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciar);
        btnIniciar.setBounds(710, 650, 230, 57);

        lblEspecificaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEspecificaciones.setText("Especificaciones del guerrero");
        jPanel1.add(lblEspecificaciones);
        lblEspecificaciones.setBounds(390, 250, 230, 16);

        cmbGuerreros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGuerrerosItemStateChanged(evt);
            }
        });
        cmbGuerreros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmbGuerrerosMouseExited(evt);
            }
        });
        jPanel1.add(cmbGuerreros);
        cmbGuerreros.setBounds(380, 190, 257, 30);

        txfTropasSeleccionadas.setColumns(20);
        txfTropasSeleccionadas.setRows(5);
        jScrollPane3.setViewportView(txfTropasSeleccionadas);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(730, 90, 231, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionActionPerformed
        pantalla = new PantallaAdmin();
        pantalla.putPantalla(this);
        pantalla.putJuego(juego);
        setVisible(false);
        pantalla.setVisible(true);
    }//GEN-LAST:event_btnConfiguracionActionPerformed

    private void cmbGuerrerosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbGuerrerosMouseExited
        
    }//GEN-LAST:event_cmbGuerrerosMouseExited

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        if(cantTropas > 0){
            txfTropasSeleccionadas.setText("");
            buscarNombre();
            printGuerreros();
            int valor = juego.addGuerrero(seleccion, cantTropas);
            if(valor != -1) cantTropas -= valor;
            lblEjercitoFaltante.setText("Campos de ejercito disponibles: " + cantTropas);
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void cmbGuerrerosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbGuerrerosItemStateChanged
        this.seleccion = (String) cmbGuerreros.getSelectedItem();
        showPropeties();
    }//GEN-LAST:event_cmbGuerrerosItemStateChanged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        FileManager.writeObject(juego, "src\\filemanager\\Files\\" + juego.name + ".dat");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        if(!juego.getEjercito().isEmpty()){
            PantallaPartida pantalla2 = new PantallaPartida();
            setVisible(false);
            pantalla2.putJuego(juego);
            pantalla.setVisible(true);
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfiguracion;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JComboBox<String> cmbGuerreros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEjercitoFaltante;
    private javax.swing.JLabel lblEspecificaciones;
    private javax.swing.JLabel lblImagenTropa;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblSMStropa;
    private javax.swing.JLabel lblTropas;
    private javax.swing.JTextArea txfEspecificaciones;
    private javax.swing.JTextArea txfTropasSeleccionadas;
    // End of variables declaration//GEN-END:variables
}
