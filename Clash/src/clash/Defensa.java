/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio
 */
public class Defensa extends Personaje implements Serializable{
   private boolean ataqueAereo;
   private boolean ataqueTerrestre;
   
   
    
   public Defensa(String name, int apLevel, int level, int damage, int range, boolean ataqueTerrestre, boolean ataqueAereo, String img1, String img2){
        super(name, apLevel, level, damage, range, img1, img2);
        this.ataqueTerrestre = ataqueTerrestre;
        this.ataqueAereo = ataqueAereo;
   }
   
   public void attackRango(){
       int dx = this.getPosicion().x;
       int dy = this.getPosicion().y;
       
       for (int i = 0; i < juego.getEjercito().size(); i++) {
           int gix = juego.getEjercito().get(i).getPosicion().x;
           int giy = juego.getEjercito().get(i).getPosicion().y;
           
           if (Math.sqrt((dx-gix)*(dx-gix)/40  + (dy-giy)*(dy-giy))/40  <= range){ //casillas de 40 x 40
               attack(juego.getEjercito().get(i));
           }
       }
        for (int i = 0; i < juego.getEnemigo().size(); i++) {
           int gix = juego.getEnemigo().get(i).getPosicion().x;
           int giy = juego.getEnemigo().get(i).getPosicion().y;
           
           if (Math.sqrt((dx-gix)*(dx-gix)/40  + (dy-giy)*(dy-giy))/40  <= range){ //casillas de 40 x 40
               attack(juego.getEnemigo().get(i));
           }
       }
   }  
   
   @Override
    public void run(){
        while (running){
            System.out.println("a");
            attackRango();
            try {
                sleep(1000);
                } 
            catch (InterruptedException ex) {
                Logger.getLogger(Defensa.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (health <= 0){
                running = false;
            }
            while(super.pause){
                try {
                    sleep(10000);
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
