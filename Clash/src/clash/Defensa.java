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
   int damage;
   int health;
   Point position;
    
   public Defensa(String name, int apLevel, int damage, int health, Point position){
        super(name, apLevel, damage);
        this.health = 100;
   }
   @Override
   public String toString(){
       return ("Corriendo "+ this.health);
   }
   @Override
    public void run(){
        while (running){
            try {
                if (health == 0){
                    System.out.println("Mori");
                    break;}
                System.out.println(toString());
                sleep(1000);
                
                health -= 10;
                
            } catch (InterruptedException ex) {
                
            }
            
            //
            while(super.pause){
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    
                }
            }
            
        }    
    }
       
}
