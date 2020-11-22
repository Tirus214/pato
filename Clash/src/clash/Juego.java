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
/**
 *
 * @author Jean Paul
 */
public class Juego extends Thread implements Serializable{
    public PantallaPartida refPantalla;
    public String name;
    public ArrayList<Guerrero> guerrerosDisponibles;
    private ArrayList<Guerrero> ejercito;
    private ArrayList<Defensa> defensa;
    private ArrayList<Guerrero> enemigo;
    private ArrayList<Defensa> defensasDisponibles;
    private int nivelPartida;
    private int cantTropas;
    private int cantDefensas;
    private boolean running;
    public ArrayList<String> nombreGuerreros;
    public ArrayList<Integer> numeroGuerreros;
    public boolean win;
    public boolean finish;

    
    public Juego(){
        nivelPartida = 1;
        defensasDisponibles = new ArrayList<Defensa>();
        guerrerosDisponibles = new ArrayList<Guerrero>();
        inicializar();
        putCantidad();
        guerrerosDisponibles.add(new GuerreroDeContacto("Barbaro", 3, 20, 1, 1, 1, 1, true, "src\\Imagenes\\ImagenesGuerreros\\Barbarian9.png", "src\\Imagenes\\ImagenesGuerreros\\Barbarian9.png"));
        guerrerosDisponibles.add(new GuerreroDeContacto("Barbaro", 3, 20, 1, 1, 1, 1, true, "src\\Imagenes\\ImagenesGuerreros\\Barbarian9.png", "src\\Imagenes\\ImagenesGuerreros\\Barbarian9.png"));
    }
    
    @Override
    public void run(){
        generarEnemigos();
        randomDefensas();
        while(running){
            int ejercitoMuerto = 0;
            for (int i = 0; i < ejercito.size(); i++){
                if(ejercito.get(i).health > 0){
                    if(ejercito.get(i).objetivo != null && ejercito.get(i).objetivo.health > 0){
                        if(ejercito.get(i).inRange) ejercito.get(i).start();
                        else refPantalla.moveLabeltoObjective(ejercito.get(i));
                    }
                    else searchAttackEnemy(ejercito.get(i), enemigo); 
                }
                else ejercitoMuerto++;
            }
            if(ejercitoMuerto == ejercito.size()){
                win = false;
                running = false;
                finish = true;
                break;
            }
            
            int enemigosMuertos = 0;
            for (int i = 0; i < enemigo.size(); i++) {
                if(ejercito.get(i).health > 0){
                    if(enemigo.get(i).objetivo != null && enemigo.get(i).objetivo.health > 0){
                        if(enemigo.get(i).inRange) enemigo.get(i).start();
                        else refPantalla.moveLabeltoObjective(enemigo.get(i));
                    }
                    else searchAttackEnemy(enemigo.get(i), ejercito); 
                }
                else enemigosMuertos++;
            }
            if(enemigosMuertos == enemigo.size()){
                win = true;
                running = false;
                finish = true;
            }
        }
        if(win){
            nextLevel();
        }
        else{
            inicializar();
        }
    }
    
    private void nextLevel(){
        nivelPartida++;
        //crecerGuerreros();
        inicializar();
        putCantidad();
        increaseNivel();
    }
    
    
    private void inicializar(){
        ejercito = new ArrayList<Guerrero>();
        defensa = new ArrayList<Defensa>();
        enemigo = new ArrayList<Guerrero>();
        nombreGuerreros = new ArrayList<String>();
        numeroGuerreros = new ArrayList<Integer>();
        running = true;
        finish = false;
        createDefensas();
    }
    
    private void putCantidad(){
        if(nivelPartida < 6){
            this.cantTropas = nivelPartida * 3 + 5;
            this.cantDefensas = nivelPartida * 3 + 3;
        }
    }
    /*
    public void crecerGuerreros(){
        for (int i = 0; i < guerrerosDisponibles.size(); i++) {
            try{
                GuerreroBestia g = (GuerreroBestia) guerrerosDisponibles.get(i);
                continue;
                try {
                    GuerreroHeroe h = (GuerreroHeroe) guerrerosDisponibles.get(i);
                    continue;
                }
                catch()
            }
            catch (InterruptedException e){
                guerrerosDisponibles.get(i).crecer();
            }
        }
    }
*/
    public void increaseNivel(){
        for (int i = 0; i < guerrerosDisponibles.size(); i++) {
            guerrerosDisponibles.get(i).nivelPartida = nivelPartida;
            try{
                GuerreroBestia b = (GuerreroBestia) guerrerosDisponibles.get(i);
                continue;
            } catch(Exception e){
                try{
                    GuerreroHeroe h = (GuerreroHeroe) guerrerosDisponibles.get(i);
                    continue;
                } catch(Exception f){
                    guerrerosDisponibles.get(i).crecer();
                }
            }
        }
    }
    
    public void fijarObjetivo(){ // fija los objetivos de enemigos y aliados
        Random ran = new Random();
        
        for (int i = 0; i < this.ejercito.size() ; i++) {
            ejercito.get(i).setObjetivo(enemigo.get(ran.nextInt(enemigo.size())));
        }
        for (int i = 0; i < this.enemigo.size() ; i++) {
            enemigo.get(i).setObjetivo(ejercito.get(ran.nextInt(ejercito.size())));
        }
        for (int i = 0; i < this.defensa.size() ; i++) {
            defensa.get(i).setObjetivo(enemigo.get(ran.nextInt(enemigo.size())));
        }
        for (int i = 0; i < this.defensa.size()/2 ; i++) {
            defensa.get(i).setObjetivo(ejercito.get(ran.nextInt(ejercito.size())));
        }
    }
    
    public void searchAttackEnemy(Personaje attacker, ArrayList<Guerrero> array){// se va a atacar al azar
        Random rand = new Random();
        int at = rand.nextInt(array.size()-1);
        attacker.objetivo = array.get(at);
    }
    
    
    public void generarEnemigos(){
        Random rand = new Random();
        int tropas2 = cantTropas;
        while (tropas2 > 0) {
            int at = rand.nextInt(guerrerosDisponibles.size()-1);
            Guerrero g = guerrerosDisponibles.get(at);
            tropas2 -= insertarGuerrero(tropas2, g, enemigo);
        }
    }
    
    
    //crea la plantilla de defensas para elegir
    private void createDefensas(){
        defensasDisponibles.add(new Defensa("Canon", 1, 1, 10, 3, true, false, "", ""));
        defensasDisponibles.add(new Defensa("TorreArqueras", 1, 1, 8, 3, true, true, "", ""));
        defensasDisponibles.add(new Defensa("Muro", 1, 1, 0, 0, false, false, "", ""));
        defensasDisponibles.add(new Defensa("Mortero", 10, 1, 10, 10, true, false, "", ""));
        defensasDisponibles.add(new Defensa("Cohetes", 5, 1, 10, 10, false, true, "", ""));
        defensasDisponibles.add(new Defensa("Bomba", 1, 1, 10, 1, false, true, "", ""));
    }
    
    //crea defensas aleatoriamente segun su nivel
    private void randomDefensas(){
        for (int i = 0; i < cantDefensas; i++) {
            int random = (int) Math.random()*5;
            while(defensasDisponibles.get(random).apLevel != this.nivelPartida){
                random = (int) Math.random()*5;
            }
            defensa.add(defensasDisponibles.get(random));
        }
    }
    
    
    public void generarGuerrero(String tipoGuerrero, String name, int damage, int life, int level, int range, int space, int apLevel, boolean movility, String img1, String img2){
        if(tipoGuerrero == "GuerreroDeContacto"){
            guerrerosDisponibles.add(new GuerreroDeContacto(name, damage, life, level, range, space, apLevel, movility, img1, img2));
        }
        else if(tipoGuerrero == "GuerreroMedianoAlcance"){
            guerrerosDisponibles.add(new GuerreroMedianoAlcance(name, damage, life, level, range, space, apLevel, movility, img1, img2));
        }
        else if(tipoGuerrero == "GuerreroAereo"){
            guerrerosDisponibles.add(new GuerreroAereo(name, damage, life, level, range, space, apLevel, movility, img1, img2));
        }
        else if(tipoGuerrero == "GuerreroBestia"){
            guerrerosDisponibles.add(new GuerreroBestia(name, damage, life, level, range, space, apLevel, movility, img1, img2));
        }
        else if(tipoGuerrero == "GuerreroHeroe"){
            guerrerosDisponibles.add(new GuerreroHeroe(name, damage, life, level, range, space, apLevel, movility, img1, img2));
        }
    }
    
    public int addGuerrero(String name, int cantropas){
        for (int i = 0; i < guerrerosDisponibles.size(); i++) {
            if(guerrerosDisponibles.get(i).name == name){
                Guerrero tmp = guerrerosDisponibles.get(i);
                return insertarGuerrero(cantropas, tmp, ejercito);
            }
        }
        return -1;
    }
    
    public int insertarGuerrero(int tropas, Guerrero tmp, ArrayList<Guerrero> array){
                if(GuerreroDeContacto.class == tmp.getClass() && cantTropas >= tmp.space) {
                    ejercito.add(new GuerreroDeContacto(name, tmp.damage, tmp.health, tmp.level, tmp.range, tmp.space, tmp.apLevel, tmp.movility, tmp.getImg1(), tmp.getImg2()));
                    return tmp.space;
                }
                else if(GuerreroMedianoAlcance.class == tmp.getClass() && cantTropas >= tmp.space) {
                    ejercito.add(new GuerreroMedianoAlcance(name, tmp.damage, tmp.health, tmp.level, tmp.range, tmp.space, tmp.apLevel, tmp.movility, tmp.getImg1(), tmp.getImg2()));
                    return tmp.space;
                }
                else if(GuerreroAereo.class == tmp.getClass() && cantTropas >= tmp.space) {
                    ejercito.add(new GuerreroAereo(name, tmp.damage, tmp.health, tmp.level, tmp.range, tmp.space, tmp.apLevel, tmp.movility, tmp.getImg1(), tmp.getImg2()));
                    return tmp.space;
                }
                else if(GuerreroBestia.class == tmp.getClass() && cantTropas >= tmp.space) {
                    ejercito.add(new GuerreroBestia(name, tmp.damage, tmp.health, tmp.level, tmp.range, tmp.space, tmp.apLevel, tmp.movility, tmp.getImg1(), tmp.getImg2()));
                    return tmp.space;
                }
                else if(GuerreroHeroe.class == tmp.getClass() && cantTropas >= tmp.space) {
                    ejercito.add(new GuerreroHeroe(name, tmp.damage, tmp.health, tmp.level, tmp.range, tmp.space, tmp.apLevel, tmp.movility, tmp.getImg1(), tmp.getImg2()));
                    return tmp.space;
                }
                return -1;
                
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
        return nivelPartida;
    }

    public void setNivel(int nivel) {
        this.nivelPartida = nivel;
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
    
    /////////////
    /*

    private static class GuerreroDeContacto extends Guerrero {

        public GuerreroDeContacto(String name, int damage, int health, int level, int range, int space, int apLevel, boolean movility, String img1, String img2) {
            super(name, damage, health, level, range, space, apLevel, movility, img1, img2);
        }
    }
    */
    
}
