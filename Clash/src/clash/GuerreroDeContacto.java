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
public class GuerreroDeContacto extends Guerrero{
    
    public GuerreroDeContacto(String name, int damage, int life, int level, int range, int space, int apLevel, String img1, String img2) {
        super(name, damage, life, level, range, space, apLevel, img1, img2);
        this.movility = true;
    }
    
}
