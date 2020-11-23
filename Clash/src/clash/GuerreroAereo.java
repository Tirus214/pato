/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;

import java.io.Serializable;

/**
 *
 * @author Jean Paul
 */
public class GuerreroAereo extends Guerrero implements Serializable{
    
    public GuerreroAereo(String name, int damage, int life, int level, int range, int space, int apLevel, boolean movility, String img1, String img2) {
        super(name, damage, life, level, range, space, apLevel, movility, img1, img2);
        this.movility = false;
    }
}
