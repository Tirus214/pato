/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;


/**
 *
 * @author Jean Paul
 */
public abstract class Guerrero extends Personaje{
    int damage;
    int health;
    int level;
    int space;


    //Constructor
    public Guerrero(String name, int damage, int health, int level, int space, int apLevel) {
        super(name, apLevel);
        this.damage = damage;
        this.health = health;
        this.level = level;
        this.space = space;
    }
    
    //Procedimientos
    int Atack(){
        return damage;
    }
    
    void lostHealth(int _damage){
        this.health -= _damage;
    }
    
    
    
    
}
