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
public class Block {
    private  int nb;
    private  int taille;
    private  Donnees Don [];
    private int curseur;
    
    public void set(int num, int taille){
        this.nb=num;
        this.taille=taille;
        this.Don = new Donnees [taille];
    }
    public void integration(int place,Donnees a){
        this.Don[place]= a; 
        this.curseur=this.curseur+1;
    }
    
    public void integration2(Donnees a){
        this.Don[curseur]= a; 
        this.curseur=this.curseur+1;
    }
    
    public boolean remplis(){
        return curseur==taille;
    }
    
    public Donnees utilisation(int place){
       return this.Don[place];
    }
    
    public void affiche(){
        System.out.println("Block n:"+this.nb+" de taille:"+this.taille);
        for( int i = 0 ; i<taille; i++){
           try{
               this.Don[i].affiche();
           }catch (Exception e){}
        }
    }
    
    public int taille(){
        return this.taille;
    }
    
    public int get(){
        //int tab [] = new int [] {nb , taille};
        return this.nb;
    }
}
