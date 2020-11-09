/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clash;


import java.util.ArrayList;

/**
 *
 * @author Jean Paul
 */
public class Juego {
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
}
