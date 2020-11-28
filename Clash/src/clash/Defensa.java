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
   private int range;
   
   
    
   public Defensa(String name, int apLevel, int level, int damage, int range, boolean ataqueTerrestre, boolean ataqueAereo, String img1, String img2){
        super(name, apLevel, level, damage, range, img1, img2);

        this.ataqueTerrestre = ataqueTerrestre;
        this.ataqueAereo = ataqueAereo;
        this.range = range;
   }
   
   public void attackRango(){
       int dx = this.getPosicion().x;
       int dy = this.getPosicion().y;
       System.out.println(name);
       for (int i = 0; i < juego.getEjercito().size(); i++) {
           int gix = juego.getEjercito().get(i).getPosicion().x;
           int giy = juego.getEjercito().get(i).getPosicion().y;
           if (Math.sqrt( ((dx-gix)*(dx-gix))  + ((dy-giy)*(dy-giy)) )/40  <= this.range){ //casillas de 40 x 40
               this.objetivo = juego.getEjercito().get(i);
               this.objetivo.health -= this.damage;
               System.out.println("disparo");
           }
       }
        for (int i = 0; i < juego.getEnemigo().size(); i++) {
            this.objetivo = juego.getEnemigo().get(i);
           int gix = juego.getEnemigo().get(i).getPosicion().x;
           int giy = juego.getEnemigo().get(i).getPosicion().y;
           
           if (Math.sqrt((dx-gix)*(dx-gix)  + (dy-giy)*(dy-giy))/40  <= this.range){ //casillas de 40 x 40
               this.objetivo.health -= this.damage;
               System.out.println("disparo");
           }
       }
   }  
   
   @Override
    public void run(){

        while (running){
            try {
                sleep(1000);
                } 
            catch (InterruptedException e) {
                //Logger.getLogger(Defensa.class.getName()).log(Level.SEVERE, null, ex);
            }
            attackRango();

            while(super.pause){
                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                   
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
