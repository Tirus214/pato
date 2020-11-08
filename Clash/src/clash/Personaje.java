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
    
    //Constructor
    public Personaje(String name, int apLevel, int damage) {
        this.name = name;
        this.apLevel = apLevel;
        this.damage = damage;
    }
    
}
