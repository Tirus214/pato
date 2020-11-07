/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author diemo
 */
public class MiObjeto implements Serializable{
    public int id;
    public String nombre;
    public double precio;
    public boolean isActive;
    public ArrayList<SecondaryObject> arrayObjetos;

    public MiObjeto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        isActive = true;
        precio = 1000.0;
        arrayObjetos = new ArrayList<SecondaryObject>();
        arrayObjetos.add(new SecondaryObject(nombre+ " secundario" , id*10));
        arrayObjetos.add(new SecondaryObject(nombre+ " tercero" , id*20));
    }

    @Override
    public String toString() {
        String str = "MiObjeto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", isActive=" + isActive + "}\n";
        for (int i = 0; i < arrayObjetos.size(); i++) {
            str += arrayObjetos.get(i)+ "\n";
        }
        return str;
    }
    
    
    
    
}
