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
    protected String name;
    protected int damage;
    protected int level;
    protected int apLevel;
    protected int range;
    protected boolean movility;
    protected boolean running = true;
    protected boolean pause = false;
    protected int health;
    
    //Constructor
    public Personaje(String name, int apLevel, int level,int damage, int range) {
        this.name = name;
        this.apLevel = apLevel;
        this.damage = damage;
        this.level = level;
    }
    
    public void move(Point p){
        
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
    public void attack(Personaje p){
      p.decrementarVida(damage);
  }
   
    
}
