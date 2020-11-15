/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;

import GUI.PantallaInicial;
import java.util.ArrayList;

/**
 *
 * @author Jean Paul
 */
public class main {
    public static void main(String[] args) {
        //Defensa a1 = new Defensa("Canon", 1, 1, 10, 3, true, false);
        
        //PantallaInicial pantalla = new PantallaInicial();
        //pantalla.setVisible(true);
        
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        
        l1.add(0);
        l1.add(1);
        l1.add(2);
        l1.add(3);
        
        l1.set(2, 55);
        
        System.out.println(l1.get(2));
        System.out.println(l1.get(3));
                
    }
}
