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
public class Juego implements Serializable{
    public transient PantallaPartida refPantalla;
    public String nameJuego;
    public transient ArrayList<Guerrero> guerrerosDisponibles;
    private transient ArrayList<Guerrero> ejercito;
    private transient ArrayList<Defensa> defensa;
    private transient ArrayList<Guerrero> enemigo;
    private transient ArrayList<Defensa> defensasDisponibles;
    private int nivelPartida;
    private int cantTropas;
    private int cantDefensas;
    public boolean running;
    public ArrayList<String> nombreGuerreros;
    public ArrayList<Integer> numeroGuerreros;
    public boolean win;
    public boolean finish;
    public boolean reiniciar = false;

    
    public Juego(){
        nivelPartida = 1;
        defensasDisponibles = new ArrayList<Defensa>();
        guerrerosDisponibles = new ArrayList<Guerrero>();
        inicializar();
        putCantidad();
    }
    
    public void searchAttackEnemy(Personaje attacker, ArrayList<Guerrero> array){// se va a atacar al azar
        Random ran = new Random();
        int at = ran.nextInt(array.size());
        attacker.objetivo = array.get(at);
    }
    
    public void correr(){
        generarEnemigos();
        randomDefensas();
        putNum();
        makeAliados();
        startGuerreros();
        
    }
    
    
    public void putNum(){
        int indice = 0;
        for (int i = 0; i < ejercito.size(); i++) {
            ejercito.get(i).num = indice;
            indice++;
        }
        for (int i = 0; i < enemigo.size(); i++) {
            enemigo.get(i).num = indice;
            indice++;
        }
        for (int i = 0; i < defensa.size(); i++) {
            defensa.get(i).num = indice;
            indice++;
        }
    }
    
    public void makeAliados(){
        for (int i = 0; i < ejercito.size(); i++) {
            ejercito.get(i).aliado = true;
        }
    }
    
    public void startGuerreros(){
        for (int i = 0; i < ejercito.size(); i++){
            try{
                try{
                    GuerreroBestia g = (GuerreroBestia) ejercito.get(i);
                    g.start();
                }
                catch (Exception e ){
                    ejercito.get(i).start();
                }
                ejercito.get(i).setJuego(this);
                ejercito.get(i).refPantalla = refPantalla;
                refPantalla.generateLabel(ejercito.get(i));
            }
            catch(Exception e){
                // System.out.println(defensa.get(i).toString());
            }
        }
            
        for (int i = 0; i < enemigo.size(); i++){
            try{
                try{
                    GuerreroBestia g = (GuerreroBestia) enemigo.get(i);
                    g.start();
                }
                catch (Exception e ){
                    enemigo.get(i).start();
                }
                enemigo.get(i).setJuego(this);
                enemigo.get(i).refPantalla = refPantalla;
                refPantalla.generateLabel(enemigo.get(i));
            }
            catch(Exception e){
                // System.out.println(defensa.get(i).toString());
            }
        }
        for (int i = 0; i < defensa.size(); i++){
            try{
                defensa.get(i).start();
                defensa.get(i).setJuego(this);
                defensa.get(i).refPantalla = refPantalla;
                refPantalla.generateLabel(defensa.get(i));
            }
            catch(Exception e){
                // System.out.println(defensa.get(i).toString());
            }
        }
    }
    
    
    public void stopGuerreros(){
        for (int i = 0; i < ejercito.size(); i++){
            ejercito.get(i).running = false;
        }
        for (int i = 0; i < enemigo.size(); i++){
            enemigo.get(i).running = false;
        }
        for (int i = 0; i < defensa.size(); i++){
            defensa.get(i).running = false;
        } 
    }
    
    
    public void verificarGanador(){
            if(verificarEjercito()){
                    stopGuerreros();
                    inicializar();
                    refPantalla.perdio();
                    refPantalla.volverMenu();            }
            else if(verificarEnemigo()){
                    stopGuerreros();
                    nextLevel();
                    refPantalla.gano();
                    refPantalla.volverMenu();
            }
    }
    
    public boolean verificarEjercito(){
        int muertos = 0;
        for (int i = 0; i < ejercito.size(); i++){
            if(ejercito.get(i).health <= 0) muertos++;
        }
        if(muertos == ejercito.size()) {
            return true;
        }
            return false;
    }
    
    public boolean verificarEnemigo(){
        int muertos = 0;
        for (int i = 0; i < enemigo.size(); i++){
            if(enemigo.get(i).health <= 0) muertos++;
        }
        if(muertos == enemigo.size()) {
            return true;
        }
            return false;
    }
    
    
    public   void nextLevel(){
        nivelPartida++;
        //crecerGuerreros();
        inicializar();
        putCantidad();
        increaseNivel();
    }
    
    
    public void inicializar(){
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
        this.cantTropas = 2 + nivelPartida * 3;
        this.cantDefensas = 1 + nivelPartida * 2;
    }

    
    public void increaseNivel(){
        if(nivelPartida < 6){
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
    
    
    public Guerrero fijarObjetivoIndividual(boolean aliado){
        Random ran = new Random();
        if(aliado){
            return enemigo.get(ran.nextInt(enemigo.size()));
        }
        else{
            return ejercito.get(ran.nextInt(ejercito.size()));
        }
    }
    
    
    
    public void generarEnemigos(){
        Random ran = new Random();
        int tropas2 = cantTropas;
        while (tropas2 > 0) {
            int at = ran.nextInt(guerrerosDisponibles.size());
            Guerrero g = guerrerosDisponibles.get(at);
            int i = insertarGuerrero(tropas2, g, enemigo);
            if (i != -1) tropas2 -= i;
        }
    }
    
    
    //crea la plantilla de defensas para elegir
    private void createDefensas(){
                    //public Defensa(String name, int apLevel, int level, int damage, int range, boolean ataqueTerrestre, boolean ataqueAereo, String img1, String img2){
        defensasDisponibles.add(new Defensa("Canon", 1, 1, 10, 3, true, false, "src\\Imagenes\\ImagenesDefensas\\canon.png", "src\\Imagenes\\ImagenesDefensas\\canon.png"));
        defensasDisponibles.add(new Defensa("TorreArqueras", 1, 1, 8, 5, true, true, "src\\Imagenes\\ImagenesDefensas\\torreArqueras.png", "src\\Imagenes\\ImagenesDefensas\\torreArqueras.png"));
        defensasDisponibles.add(new Defensa("Muro", 1, 1, 0, 0, false, false, "src\\Imagenes\\ImagenesDefensas\\wall.png", "src\\Imagenes\\ImagenesDefensas\\wall.png"));
        defensasDisponibles.add(new Defensa("Mortero", 10, 1, 10, 10, true, false, "src\\Imagenes\\ImagenesDefensas\\Mortar7.png", "src\\Imagenes\\ImagenesDefensas\\Mortar7.png"));
        defensasDisponibles.add(new Defensa("Cohetes", 5, 1, 10, 10, false, true, "src\\Imagenes\\ImagenesDefensas\\cohetes.png", "src\\Imagenes\\ImagenesDefensas\\cohetes.png"));
        defensasDisponibles.add(new Defensa("Bomba", 1, 1, 10, 1, false, true, "src\\Imagenes\\ImagenesDefensas\\bomb.png", "src\\Imagenes\\ImagenesDefensas\\bomb.png"));
        defensasDisponibles.add(new Defensa("Tesla", 1, 1, 10, 7, true, true, "src\\Imagenes\\ImagenesDefensas\\teslatower.png", "src\\Imagenes\\ImagenesDefensas\\teslatower.png"));
    }
    
    //crea defensas aleatoriamente segun su nivel
    private void randomDefensas(){
        Random ran = new Random();
        for (int i = 0; i < cantDefensas; i++) {
            int random = ran.nextInt(defensasDisponibles.size());
            while(defensasDisponibles.get(random).apLevel > this.nivelPartida){
                random = ran.nextInt(defensasDisponibles.size());
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
            if(guerrerosDisponibles.get(i).getNombre() == name){
                Guerrero tmp = guerrerosDisponibles.get(i);
                return insertarGuerrero(cantropas, tmp, ejercito);
            }
        }
        return -1;
    }
    
    public int insertarGuerrero(int tropas, Guerrero tmp, ArrayList<Guerrero> array){
        if(tmp.apLevel <= nivelPartida){
                if(GuerreroDeContacto.class == tmp.getClass() && tropas >= tmp.space) {
                    array.add(new GuerreroDeContacto(tmp.name, tmp.damage, tmp.health, tmp.level, tmp.range, tmp.space, tmp.apLevel, tmp.movility, tmp.getImg1(), tmp.getImg2()));
                    return tmp.space;
                }
                else if(GuerreroMedianoAlcance.class == tmp.getClass() && tropas >= tmp.space) {
                    array.add(new GuerreroMedianoAlcance(tmp.name, tmp.damage, tmp.health, tmp.level, tmp.range, tmp.space, tmp.apLevel, tmp.movility, tmp.getImg1(), tmp.getImg2()));
                    return tmp.space;
                }
                else if(GuerreroAereo.class == tmp.getClass() && tropas >= tmp.space) {
                    array.add(new GuerreroAereo(tmp.name, tmp.damage, tmp.health, tmp.level, tmp.range, tmp.space, tmp.apLevel, tmp.movility, tmp.getImg1(), tmp.getImg2()));
                    return tmp.space;
                }
                else if(GuerreroBestia.class == tmp.getClass() && tropas >= tmp.space) {
                    array.add(new GuerreroBestia(tmp.name, tmp.damage, tmp.health, tmp.level, tmp.range, tmp.space, tmp.apLevel, tmp.movility, tmp.getImg1(), tmp.getImg2()));
                    return tmp.space;
                }
                else if(GuerreroHeroe.class == tmp.getClass() && tropas >= tmp.space) {
                    array.add(new GuerreroHeroe(tmp.name, tmp.damage, tmp.health, tmp.level, tmp.range, tmp.space, tmp.apLevel, tmp.movility, tmp.getImg1(), tmp.getImg2()));
                    return tmp.space;
                }
                return -1;
        }
        return -1;
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
