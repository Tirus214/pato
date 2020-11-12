/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;


import java.awt.Point;
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
    private ArrayList<Defensa> defensasDisponibles;
    private int nivel;
    private int cantTropas;
    private int cantDefensas;

    public Juego(){
        ejercito = new ArrayList<Guerrero>();
        defensa = new ArrayList<Defensa>();
        enemigo = new ArrayList<Guerrero>();
        defensasDisponibles = new ArrayList<Defensa>();
        nivel = 1;
        cantTropas = 5;
        cantDefensas = 3;
        createDefensas();
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
    
    
    private void createDefensas(){
        defensasDisponibles.add(new Defensa("Canon", 1, 1, 10, 3, true, false));
        defensasDisponibles.add(new Defensa("Torre de Arqueras", 1, 1, 8, 3, true, true));
        defensasDisponibles.add(new Defensa("Muro", 1, 1, 0, 0, false, false));
        defensasDisponibles.add(new Defensa("Mortero", 10, 1, 10, 10, true, false));
        defensasDisponibles.add(new Defensa("Cohetes", 5, 1, 10, 10, false, true));
        defensasDisponibles.add(new Defensa("Bomba", 1, 1, 10, 1, false, true));
    }
    
    private void randomDefensas(){
        for (int i = 0; i < cantDefensas; i++) {
            int random = (int) Math.random()*5;
            while(defensasDisponibles.get(random).apLevel != this.nivel){
                random = (int) Math.random()*5;
            }
            defensa.add(defensasDisponibles.get(random));
    }
    
    
    
    
    
    //GETTER AND SETTER

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
