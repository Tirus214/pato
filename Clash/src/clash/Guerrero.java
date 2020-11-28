/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;

import java.awt.Point;
import java.io.Serializable;


/**
 *
 * @author Jean Paul
 */
public abstract class Guerrero extends Personaje implements Serializable{
    protected int space;
    protected int health;
    protected String img2;
    protected boolean movility;
    protected boolean aliado = false;


    //Constructor
    public Guerrero(String name, int damage, int health, int level, int range, int space, int apLevel, boolean movility,String img1, String img2){
        super(name, apLevel, level, damage, range, img1, img2);
        this.space = space;
        this.img2 = img2;
        this.movility = movility;
        this.health = health;
    }
    
    public void crecer(){
        this.damage = nivelPartida*5 + damage;
        this.health = nivelPartida*5 + health;
    }
    
    //Procedimientos
    int Atack(){
        return damage;
    }
    
    public void lostHealth(int _damage){
        this.health -= _damage;
    }
    
    @Override
    public void run(){

        while (running){
            //System.out.println("Guerrero: " + num + "   vida: " + health);
                if(objetivo != null) {
                    if(inRange){
                        
                        if(objetivo.health > 0){
                            objetivo.health -= this.damage;
                            System.out.println("Guerrero: {" + objetivo.num + "}   Vida: " + objetivo.health);
                        }
                        else {
                            objetivo = null;
                            inRange = false;
                        }
                        
                    }else {
                        Point pos = new Point(this.refLabel.getLocation().x +0 ,this.refLabel.getLocation().y + 0 );
                        refPantalla.moveLabeltoObjective(this, num);
                        if (pos.x == this.refLabel.getLocation().x  && pos.y == this.refLabel.getLocation().y)
                            objetivo = juego.fijarObjetivoIndividual(aliado);
                        }
                }else   
                    try{
                    objetivo = juego.fijarObjetivoIndividual(aliado);
              
                    }catch(Exception e){

                    }
                try {
                    sleep(500);
                } catch (InterruptedException ex){
                    // Logger.getLogger(Guerrero.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            if (health <= 0){
                System.out.println("Guerrero: {" + num +"} -> Ah weon me mataron");
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

    public boolean isAliado() {
        return aliado;
    }

    public void setAliado(boolean aliado) {
        this.aliado = aliado;
    }
    
    
    
    
}
