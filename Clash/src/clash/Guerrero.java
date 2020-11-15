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
public abstract class Guerrero extends Personaje{
    protected int space;
    protected int health;
    String img2;


    //Constructor
    public Guerrero(String name, int damage, int health, int level, int range, int space, int apLevel, String img1, String img2){
        super(name, apLevel, level, damage, range, img1, img2);
        this.health = health;
        this.space = space;
        this.img2 = img2;
    }
    
    //Procedimientos
    int Atack(){
        return damage;
    }
    
    void lostHealth(int _damage){
        this.health -= _damage;
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
                
            } catch (InterruptedException ex){
                
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

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    
    
    
}
