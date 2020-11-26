/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;

import GUI.PantallaInicial;
import filemanager.FileManager;
import java.util.ArrayList;

/**
 *
 * @author Jean Paul
 */
public class main {
    public static void main(String[] args) {
        
        PantallaInicial pantalla = new PantallaInicial();
        pantalla.setVisible(true);
        
        Configuracion config = new Configuracion();
        FileManager.writeObject(config, "src\\filemanager\\Files\\configuracion.dat");
        
    }
}
