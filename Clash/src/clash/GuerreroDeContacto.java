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
    
    public GuerreroDeContacto(String name, int damage, int life, int level, int space, int apLevel) {
        super(name, damage, life, level, space, apLevel);
        this.movility = true;
    }
    
}
