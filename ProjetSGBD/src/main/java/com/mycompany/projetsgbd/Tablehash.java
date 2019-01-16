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
    
     public Bucket researchclef (int clef){
        for (int i = 1 ; i<=this.taille ; i++)
        {
            if (this.espacealloue[this.taille-i]!=null){
                if (this.espacealloue[this.taille-i].clef() == clef) {
                    return this.espacealloue[this.taille-i];
                }
            }
        }
        System.out.println("création buffer");
        Bucket b = new Bucket();
        b.set(this.curseur, 1,clef);
        this.espacealloue[this.curseur] = b;
        this.curseur= this.curseur+1;
        return b;
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

