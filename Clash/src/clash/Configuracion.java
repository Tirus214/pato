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
    //public GuerreroDeContacto(String name, int damage, int life, int level, int range, int space, int apLevel, boolean movility, String img1, String img2) {
        array.add(new GuerreroMedianoAlcance("Arquera", 2, 15, 1, 5, 1, 1, true, "src\\Imagenes\\ImagenesGuerreros\\Archer.png", "src\\Imagenes\\ImagenesGuerreros\\Archer.png"));
        array.add(new GuerreroDeContacto("Barbaro", 3, 20, 1, 1, 1, 1, true, "src\\Imagenes\\ImagenesGuerreros\\Barbarian9.png", "src\\Imagenes\\ImagenesGuerreros\\Barbarian9.png"));
        array.add(new GuerreroBestia("P.E.K.K.A", 50, 100, 1, 1, 15, 7, true, "src\\Imagenes\\ImagenesGuerreros\\PEKKA1.png", "src\\Imagenes\\ImagenesGuerreros\\PEKKA1.png"));
        array.add(new GuerreroMedianoAlcance("Mago", 10, 20, 1, 3, 4, 4, true, "src\\Imagenes\\ImagenesGuerreros\\magician.png", "src\\Imagenes\\ImagenesGuerreros\\magician.png"));
        array.add(new GuerreroBestia("Maradona", 10000, 10000, 10, 10, 15, 15, true, "src\\Imagenes\\ImagenesGuerreros\\maladroga.jpg", "src\\Imagenes\\ImagenesGuerreros\\maladroga.jpg"));
        array.add(new GuerreroHeroe("Rey Barbaro", 100, 125, 1, 1, 10, 8, true, "src\\Imagenes\\ImagenesGuerreros\\Barbarian_King.png", "src\\Imagenes\\ImagenesGuerreros\\Barbarian_King.png"));
        array.add(new GuerreroHeroe("Reina Arquera", 75, 150, 1, 4, 7, 10, true, "src\\Imagenes\\ImagenesGuerreros\\Archer_Queen.png", "src\\Imagenes\\ImagenesGuerreros\\Archer_Queen.png"));
        array.add(new GuerreroAereo("Dragon", 75, 100, 1, 6, 10, 10, false, "src\\Imagenes\\ImagenesGuerreros\\Dragon_info.png", "src\\Imagenes\\ImagenesGuerreros\\Dragon_info.png"));
        }
}
