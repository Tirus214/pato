/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jean Paul
 */
public abstract class Guerrero extends Personaje implements Serializable{
    protected int space;
    protected int health;
    protected String img2;
    protected boolean movility;
    protected boolean aliado;


    //Constructor
    public Guerrero(String name, int damage, int health, int level, int range, int space, int apLevel, boolean movility,String img1, String img2){
        super(name, apLevel, level, damage, range, img1, img2);
        this.space = space;
        this.img2 = img2;
        this.movility = movility;
        this.health = health;
        this.aliado = false;
    }
    
    public void crecer(){
        this.damage = nivelPartida*5 + damage;
        this.health = nivelPartida*5 + health;
    }
    
    //Procedimientos
    int Atack(){
        return damage;
    }
    
    public void lostHealth(int _damage){
        this.health -= _damage;
    }
    
    @Override
    public void run(){
        while (running){
                if(objetivo != null) {
                    if(objetivo.health > 0){
                        objetivo.health -= this.damage;
                        try {
                            sleep(1000);
                        } catch (InterruptedException ex){
                            Logger.getLogger(Guerrero.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else {
                        objetivo = null;
                        inRange = false;
                    }  
                } else juego.fijarObjetivoIndividual(this);
            if (health <= 0){
                running = false;
            }
            
            while(super.pause){
                try {
                    sleep(10000);
                } catch (InterruptedException ex) {
                   
                }
            }
        }    
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAliado() {
        return aliado;
    }

    public void setAliado(boolean aliado) {
        this.aliado = aliado;
    }
    
    
    
    
}
