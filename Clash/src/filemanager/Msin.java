/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.util.ArrayList;

/**
 *
 * @author diemo
 */
public class Msin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        ArrayList<MiObjeto> array = new ArrayList<MiObjeto>();
        MiObjeto o1 = new MiObjeto(2, "Diego");
        array.add(new MiObjeto(3, "esteban"));
        array.add(o1);
        
        
        FileManager.writeObject(array, "C:\\TEST\\miArchivoArray.dat");
        */
        ArrayList<MiObjeto> o2 = (ArrayList<MiObjeto>)FileManager.readObject("C:\\TEST\\miArchivoArray.dat");
        
        for (int i = 0; i < o2.size(); i++) {
            System.out.println(o2.get(i).toString() + "\n\n");
        }
    }
    
}
