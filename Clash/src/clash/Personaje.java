/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;

import GUI.PantallaPartida;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author Jean Paul
 */
public abstract class Personaje extends Thread implements Serializable{
    public Juego juego;
    public transient PantallaPartida refPantalla;
    protected String name;
    protected int damage;
    protected int level;
    protected int apLevel;
    protected int range;
    protected int health;
    protected boolean movility;
    protected String img1;
    protected String img2;
    protected boolean aliado;
    
    protected boolean running;
    protected boolean pause;
    public transient JLabel refLabel;
    public int num;
    public Point posicion;
    public Guerrero objetivo;
    public boolean inRange;
    public int nivelPartida;
    
    //Constructor
    public Personaje(String name, int apLevel, int level,int damage, int range, String img1, String img2) {
        this.name = name;
        this.apLevel = apLevel;
        this.level = level;
        this.refLabel = new JLabel();
        this.img1 = img1;
        this.img2 = img2;
        this.posicion = new Point();
        this.running = true;
        this.pause = false;
        this.inRange = false;
        this.damage = damage;
        this.range = range;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
   
    

    public String getNombre() {
        return this.name;
    }

    public void setNombre(String name) {
        this.name = name;
    }
    
    /*
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
   }  
   */

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    
    public void setNum(int num){
        this.num = num;
    }
    
    public void stopThread(){
        this.running = false;
    }
    
    public void setPause(){
        this.pause = !this.pause;
    }
    
    public void attack(Personaje p){
      //p.decrementarVida(damage);
  }

    public PantallaPartida getRefPantalla() {
        return refPantalla;
    }

    public boolean isAliado() {
        return aliado;
    }

    public void setAliado(boolean aliado) {
        this.aliado = aliado;
    }

    
    
    public Personaje getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Guerrero objetivo) {
        this.objetivo = objetivo;
    }

    
    public void setRefPantalla(PantallaPartida refPantalla) {
        this.refPantalla = refPantalla;
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getApLevel() {
        return apLevel;
    }

    public void setApLevel(int apLevel) {
        this.apLevel = apLevel;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public boolean isMovility() {
        return movility;
    }

    public void setMovility(boolean movility) {
        this.movility = movility;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public JLabel getRefLabel() {
        return refLabel;
    }

    public void setRefLabel(JLabel refLabel) {
        this.refLabel = refLabel;
    }

    public int getIde() {
        return num;
    }

    public void setIde(int id) {
        this.num = id;
    }

    public Point getPosicion() {
        return posicion;
    }

    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }
   
    
    
    
    
    
    
    
}
