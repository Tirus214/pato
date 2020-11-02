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
public abstract class Personaje {
    String name;
    int apLevel;
    boolean movility;
    Point location;

    //Constructor
    public Personaje(String name, int apLevel) {
        this.name = name;
        this.apLevel = apLevel;
    }
    
    
    
    void randomAppear(ArrayList matriz[]){
        this.location.x = generateRandom();
        this.location.y = generateRandom();
    }
    
    int generateRandom(){
        Random r = new Random();
        return r.nextInt(20-0)+0;
    }
    
}
