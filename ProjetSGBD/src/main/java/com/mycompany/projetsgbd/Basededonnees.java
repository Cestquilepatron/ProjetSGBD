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
public class Basededonnees {
    private Block[] base;
    private Bucket[] basedetri;
    private int nbbloc;
    private int nbbucket;
    
    public void set(int taille){
        this.base = new Block[taille];
        this.basedetri= new Bucket[taille];
        this.nbbucket=0;
        this.nbbloc=0;
    }
    
    public int get(){
        return this.nbbloc;
    }
    
     public int get2(){
        return this.nbbucket;
    }
    
    public Block research (int indice){
        for (int i =0 ; i<=nbbloc ; i++)
        {
            if (this.base[i].get() == indice) {
                return this.base[i];
            }
        }
        Block b = new Block();
        b.set(1000000000, 1);
        Donnees Err = new Donnees();
        Err.set(1000000000, 0, 1);
        Err.insertiondonnee(0, "Erreur, bloc non-existant");
        b.integration(0, Err);
        return b;
    }
    
    public Bucket research2 (int indice){
        for (int i =0 ; i<=nbbucket ; i++)
        {
            if (this.basedetri[i].get() == indice) {
                return this.basedetri[i];
            }
        }
        Bucket b = new Bucket();
        b.set(1000000000, 1,-1);
        Donnees Err = new Donnees();
        Err.set(1000000000, 0, 1);
        Err.insertiondonnee(0, "Erreur, bloc non-existant");
        b.integration(Err);
        return b;
    }
    
    public void add (Block b){
        this.base[nbbloc] = b;
        this.nbbloc= this.nbbloc +1;
    }
    
    public void add2 (Bucket b){
        this.basedetri[nbbucket] = b;
        this.nbbucket= this.nbbucket +1;
    }
}
