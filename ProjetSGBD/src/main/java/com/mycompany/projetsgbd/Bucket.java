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
public class Bucket {
    private  int nb;
    private  int taille;
    private  Donnees Don [];
    private int nbdedonnees;//curseur pour placer les données.
    private int clefdehash;
    
    public void set(int num, int taille,int clef){
        this.nb=num;
        this.taille=taille;
        this.Don = new Donnees [taille];
        this.clefdehash = clef;
        this.nbdedonnees = 0;
    }
    public void integration(Donnees a){
        if (a.clef()==this.clefdehash){
            this.Don[nbdedonnees]= a;
            this.nbdedonnees = this.nbdedonnees +1;
        } 
    }
    
    public Donnees utilisation(int place){
       return this.Don[place];
    }
    
    public void affiche(){
        try{
            System.out.println("Bucket n:"+this.nb+" de taille:"+this.taille +" de clef " + this.clefdehash);
            for( int i = 0 ; i<taille; i++){
                this.Don[i].affiche();
                System.out.println("boucle jusqu'à " +i);
            }
        }catch(Exception e){System.out.println("bucket non def");}
    }
    
    public int taille(){
        return this.taille;
    }
    
    public int clef(){
        return this.clefdehash;
    }
    
    public int get(){
        //int tab [] = new int [] {nb , taille};
        return this.nb;
    }
}
