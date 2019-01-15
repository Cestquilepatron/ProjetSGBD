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
public class Tablehash {
    private String nom;
    private int taille;
    private Bucket [] espacealloue;
    private int curseur;
    
    public void set(String appelation, int taille){
        this.nom=appelation;
        this.taille=taille;
        this.espacealloue = new Bucket [taille];
        this.curseur = 0;
    }
    
    
    
    public void integration(Bucket a){
        if (a.tableassocie().equals(this.nom)){
            this.espacealloue[this.curseur]= a;
            this.curseur = this.curseur+1;
        }   
    }
    
    public String get(){
        return nom;
    }
    
    public Bucket[] liaison(){
        return this.espacealloue;
    }
    
    public Bucket liaison(int i){
        return this.espacealloue[i];
    }
    
    public void affiche(){
        System.out.println("Table:"+this.nom+" de taille "+this.taille+"composé de ");
        try{
            for (int i=0;i<taille;i++){
                this.espacealloue[i].affiche();
            }
        }catch(Exception e){}
    }
    
    public int taille(){
        return this.taille;
    }
}

