/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;
import java.awt.Point;

/**
 *
 * @author Mauricio
 */
public class Defensa extends Personaje {
   int damage;
    int health;
    Point position;
    
    public Defensa(String name, int apLevel, int damage, int health, Point position){
        super(name, apLevel);
        this.damage = damage;
        this.health = 100;
    }
}
