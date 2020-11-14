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
public class GuerreroBestia extends Guerrero{
    
    public GuerreroBestia(String name, int damage, int life, int level, int range, int space, int apLevel) {
        super(name, damage, life, level, range, space, apLevel);
        this.movility = true;
    }
    
}
