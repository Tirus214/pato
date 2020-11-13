/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;

import GUI.PantallaPartida;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author Jean Paul
 */
public abstract class Personaje extends Thread{
    public PantallaPartida refPantalla;
    protected String name;
    protected int damage;
    protected int level;
    protected int apLevel;
    protected int range;
    protected boolean movility;
    protected boolean running = true;
    protected boolean pause = false;
    protected int health;
    public JLabel refLabel;
    private int id = -1;
    private Point posicion;
    
    //Constructor
    public Personaje(String name, int apLevel, int level,int damage, int range) {
        this.name = name;
        this.apLevel = apLevel;
        this.damage = damage;
        this.level = level;
        this.id++;
        this.refLabel = refPantalla.generateLabel(id);
        
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
