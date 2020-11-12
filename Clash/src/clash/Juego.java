/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;


import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Jean Paul
 */
public class Juego {
    public String name;
    private ArrayList<Guerrero> ejercito;
    private ArrayList<Defensa> defensa;
    private ArrayList<Guerrero> enemigo;
    private int nivel;
    private int cantTropas;
    private int cantDefensas;

    public Juego(){
        ejercito = new ArrayList<Guerrero>();
        defensa = new ArrayList<Defensa>();
        enemigo = new ArrayList<Guerrero>();
        nivel = 1;
        cantTropas = 5;
        cantDefensas = 3;
    }
    
    public void start(){
        
    }
    
    private void putCantidad(){
        this.cantTropas = nivel * 3 + 5;
        this.cantDefensas = nivel * 3 + 3;
    }
    
    
    public void searchAttackEnemy(Personaje attacker){// se va a atacar al azar
        Random rand = new Random();
        int at = rand.nextInt(enemigo.size());
        //attacker.move(enemigo.get(at));
        }
    
    
    //GETTER AND SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Guerrero> getEjercito() {
        return ejercito;
    }

    public void setEjercito(ArrayList<Guerrero> ejercito) {
        this.ejercito = ejercito;
    }

    public ArrayList<Defensa> getDefensa() {
        return defensa;
    }

    public void setDefensa(ArrayList<Defensa> defensa) {
        this.defensa = defensa;
    }

    public ArrayList<Guerrero> getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(ArrayList<Guerrero> enemigo) {
        this.enemigo = enemigo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCantTropas() {
        return cantTropas;
    }

    public void setCantTropas(int cantTropas) {
        this.cantTropas = cantTropas;
    }

    public int getCantDefensas() {
        return cantDefensas;
    }

    public void setCantDefensas(int cantDefensas) {
        this.cantDefensas = cantDefensas;
    }
    
    //////////////
    
    
}
