/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.Serializable;

/**
 *
 * @author diemo
 */
public class SecondaryObject implements Serializable{
    public String nombre;
    public int identificacion;

    public SecondaryObject(String nombre, int identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "SecondaryObject{" + "nombre=" + nombre + ", identificacion=" + identificacion + '}';
    }
    
    
}
