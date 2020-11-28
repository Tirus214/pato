/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;

import java.awt.Point;
import java.io.Serializable;
import static java.lang.Thread.sleep;

/**
 *
 * @author Jean Paul
 */
public class GuerreroAereo extends Guerrero implements Serializable{
    
    public GuerreroAereo(String name, int damage, int life, int level, int range, int space, int apLevel, boolean movility, String img1, String img2) {
        super(name, damage, life, level, range, space, apLevel, movility, img1, img2);
        this.movility = false;
    }
    
    public void attackRango(){
       int dx = this.getPosicion().x;
       int dy = this.getPosicion().y;
       if(!aliado){
            for (int i = 0; i < juego.getEjercito().size(); i++) {
                int gix = juego.getEjercito().get(i).getPosicion().x;
                int giy = juego.getEjercito().get(i).getPosicion().y;
                if (Math.sqrt( ((dx-gix)*(dx-gix))  + ((dy-giy)*(dy-giy)) )/40  <= this.range){ //casillas de 40 x 40
                    this.objetivo = juego.getEjercito().get(i);
                    this.objetivo.health -= this.damage;
                    if(objetivo.aliado) System.out.println("Enemigo: {" + objetivo.num + "}   Vida: " + objetivo.health);
                    else System.out.println("Aliado: {" + objetivo.num + "}   Vida: " + objetivo.health); 
                }
            }
        }
       else{
            for (int i = 0; i < juego.getEnemigo().size(); i++) {
                this.objetivo = juego.getEnemigo().get(i);
               int gix = juego.getEnemigo().get(i).getPosicion().x;
               int giy = juego.getEnemigo().get(i).getPosicion().y;

               if (Math.sqrt((dx-gix)*(dx-gix)  + (dy-giy)*(dy-giy))/40  <= this.range){ //casillas de 40 x 40
                   this.objetivo.health -= this.damage;
                   if(objetivo.aliado) System.out.println("Enemigo: {" + objetivo.num + "}   Vida: " + objetivo.health);
                   else System.out.println("Aliado: {" + objetivo.num + "}   Vida: " + objetivo.health);
               }
           }
       }
   } 
    
    @Override
    public void run(){
        while (running){
            //System.out.println("Guerrero: " + num + "   vida: " + health);
                
                try {
                    sleep(700);
                } catch (InterruptedException ex){
                    // Logger.getLogger(Guerrero.class.getName()).log(Level.SEVERE, null, ex);
                }
                attackRango();
            if (health <= 0){
                if(aliado) System.out.println("Aliado: {" + num + "}     -> AH WEON ME MATAROOON!");
                else System.out.println("Enemigo: {" + num + "}     -> AH WEON ME MATAROOON!");
                running = false;
                refPantalla.arregloLabels.get(num).setLocation(1000, 1000);
                juego.verificarGanador();
            }
            while(super.pause){
                try {
                    sleep(10000);
                } catch (InterruptedException ex) {
                   
                }
            }
        }
    }
}