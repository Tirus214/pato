/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;
import java.awt.Point;

/**
 *
 * @author Mauricio
 */
public class Defensa extends Personaje {
   private int range;
   private boolean ataqueAereo;
   private boolean ataqueTerrestre;
   
   
    
   public Defensa(String name, int apLevel, int level, int damage, int range, boolean ataqueTerrestre, boolean ataqueAereo, String img1, String img2){
        super(name, apLevel, level, damage, range, img1, img2);
        this.ataqueTerrestre = ataqueTerrestre;
        this.ataqueAereo = ataqueAereo;
   }
   
   @Override
    public void run(){
        while (running){
            if(objetivo != null) {
                if(objetivo.health > 0){
                    objetivo.health -= this.damage;
                }
                else objetivo = null;
            } 
            
            //
            while(super.pause){
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                   
                }
            }
            
        }    
    }

    public int getApLevel() {
        return apLevel;
    }

    public void setApLevel(int apLevel) {
        this.apLevel = apLevel;
    }
    
       
}
