/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Jean Paul
 */
public class Configuracion implements Serializable{
    public ArrayList<Guerrero> array;

    public Configuracion() {
        this.array = new ArrayList<Guerrero>();
        addGuerreros();
    }
    
    public void addGuerreros(){
        array.add(new GuerreroDeContacto("Barbaro", 3, 20, 1, 1, 1, 1, true, "src\\Imagenes\\ImagenesGuerreros\\Barbarian9.png", "src\\Imagenes\\ImagenesGuerreros\\Barbarian9.png"));
        array.add(new GuerreroBestia("P.E.K.K.A", 50, 100, 1, 1, 15, 7, true, "src\\Imagenes\\ImagenesGuerreros\\PEKKA1.png", "src\\Imagenes\\ImagenesGuerreros\\PEKKA1.png"));
        array.add(new GuerreroMedianoAlcance("Mago", 10, 20, 1, 3, 4, 4, true, "src\\Imagenes\\ImagenesGuerreros\\magician.png", "src\\Imagenes\\ImagenesGuerreros\\magician.png"));
    }
}
