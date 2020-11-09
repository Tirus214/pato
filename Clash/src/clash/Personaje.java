/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jean Paul
 */
public abstract class Personaje extends Thread{
    String name;
    int damage;
    int apLevel;
    boolean movility;
    boolean running = true;
    private boolean pause = false;
    int health;
    
    //Constructor
    public Personaje(String name, int apLevel, int damage) {
        this.name = name;
        this.apLevel = apLevel;
        this.damage = damage;
    }
        @Override
    public void run(){
        int repeticiones = 100;
        while (running){
            
            try {
                if (repeticiones == 0) break;
                sleep(1000);
                
                repeticiones--;
                
            } catch (InterruptedException ex) {
                
            }
            
            
            //
            while(pause){
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    
                }
            }
            
        }    
    }
    
    public void stopThread(){
        this.running = false;
    }
    
    public void setPause(){
        this.pause = !this.pause;
    }
    
    void decrementarVida(int golpePower){
        this.health -= golpePower; 
    }
}
