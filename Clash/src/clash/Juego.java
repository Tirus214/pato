/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;


import GUI.PantallaPartida;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Jean Paul
 */
public class Juego extends Thread{
    public PantallaPartida refPantalla;
    public String name;
    public ArrayList<Guerrero> guerrerosDisponibles;
    private ArrayList<Guerrero> ejercito;
    private ArrayList<Defensa> defensa;
    private ArrayList<Guerrero> enemigo;
    private ArrayList<Defensa> defensasDisponibles;
    private int nivel;
    private int cantTropas;
    private int cantDefensas;
    private boolean running;

    
    
    public Juego(){
        ejercito = new ArrayList<Guerrero>();
        defensa = new ArrayList<Defensa>();
        enemigo = new ArrayList<Guerrero>();
        defensasDisponibles = new ArrayList<Defensa>();
        nivel = 1;
        cantTropas = 5;
        cantDefensas = 3;
        // createDefensas(); fix
        running = true;
    }
    /*
    @Override
    public void run(){
        randomDefensas();
        while(running){
            for (int   = 0;   < ejercito.size();  ++) {
                Guerrero get = ejercito.get( );
                
            }
        }
    }*/
    
    private void putCantidad(){
        this.cantTropas = nivel * 3 + 5;
        this.cantDefensas = nivel * 3 + 3;
    }
    
    
    public void searchAttackEnemy(Personaje attacker){// se va a atacar al azar
        Random rand = new Random();
        int at = rand.nextInt(enemigo.size());
        //attacker.move(enemigo.get(at));
    }
    
    //crea la plantilla de defensas para elegir
    private void createDefensas(){
        defensasDisponibles.add(new Defensa("Canon", 1, 1, 10, 3, true, false));
        defensasDisponibles.add(new Defensa("Torre de Arqueras", 1, 1, 8, 3, true, true));
        defensasDisponibles.add(new Defensa("Muro", 1, 1, 0, 0, false, false));
        defensasDisponibles.add(new Defensa("Mortero", 10, 1, 10, 10, true, false));
        defensasDisponibles.add(new Defensa("Cohetes", 5, 1, 10, 10, false, true));
        defensasDisponibles.add(new Defensa("Bomba", 1, 1, 10, 1, false, true));
    }
    
    //crea defensas aleatoriamente segun su nivel
    private void randomDefensas(){
        for (int i = 0; i < cantDefensas; i++) {
            int random = (int) Math.random()*5;
            while(defensasDisponibles.get(random).apLevel != this.nivel){
                random = (int) Math.random()*5;
            }
            defensa.add(defensasDisponibles.get(random));
        }
    }
    
    
    public void generarGuerrero(String tipoGuerrero, String name, int damage, int life, int level, int range, int space, int apLevel){
        if(tipoGuerrero == "GuerreroDeContacto"){
            guerrerosDisponibles.add(new GuerreroDeContacto(name, damage, life, level, range, space, apLevel));
        }
        else if(tipoGuerrero == "GuerreroMedianoAlcance"){
            guerrerosDisponibles.add(new GuerreroMedianoAlcance(name, damage, life, level, range, space, apLevel));
        }
        else if(tipoGuerrero == "GuerreroAereo"){
            guerrerosDisponibles.add(new GuerreroAereo(name, damage, life, level, range, space, apLevel));
        }
        else if(tipoGuerrero == "GuerreroBestia"){
            guerrerosDisponibles.add(new GuerreroBestia(name, damage, life, level, range, space, apLevel));
        }
        else if(tipoGuerrero == "GuerreroHeroe"){
            guerrerosDisponibles.add(new GuerreroHeroe(name, damage, life, level, range, space, apLevel));
        }
    }
    
    
    public void startGuerreros(){
        for (int i = 0; i < ejercito.size(); i++) {
            ejercito.get(i).start();
            enemigo.get(i).start();
        }
        for (int j = 0; j < defensa.size(); j++) {
            defensa.get(j).stopThread();
        }
    }
    
    public void stopGuerreros(){
        for (int i = 0; i < ejercito.size(); i++) {
            ejercito.get(i).stopThread();
            enemigo.get(i).stopThread();
        }
        for (int j = 0; j < defensa.size(); j++) {
            defensa.get(j).stopThread();
        }
    }
    
    public void pauseGuerreros(){
        for (int i = 0; i < ejercito.size(); i++) {
            ejercito.get(i).setPause();
            enemigo.get(i).setPause();
        }
        for (int j = 0; j < defensa.size(); j++) {
            defensa.get(j).setPause();
        }
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
