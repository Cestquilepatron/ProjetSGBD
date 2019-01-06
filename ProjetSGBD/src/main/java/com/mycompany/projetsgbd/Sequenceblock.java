/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetsgbd;

/**
 *
 * @author Bastien
 */
public class Sequenceblock {
    private  int id;
    private int premierbloc;
    private  int taille;
    
    public void set(int num,int premier, int taille){
        this.id=num;
        this.taille=taille;
        this.premierbloc = premier;
    }
    
    public void affiche(){
        System.out.println("Séquence de bloc n'"+this.id+" commençant au bloc "+this.premierbloc+" de taille "+this.taille);     
    }
    
    public int[] get(){
        int tab [] = new int [] {id ,premierbloc ,taille};
        return tab;
    }
}
