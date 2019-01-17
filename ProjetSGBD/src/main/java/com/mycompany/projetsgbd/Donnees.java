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
public class Donnees {
    private  int Cleprimaire;
    private  int[] premieredonnee;
    private  String[] deuxiemedonnee;
    private int clefhashage;
    
    public void set(int clef,int tailleint,int taillestring){
        this.Cleprimaire = clef;
        this.premieredonnee= new int [tailleint];
        this.deuxiemedonnee= new String [taillestring];
        this.clefhashage=0;
        
    };
    
    public void set(int clef,int[] tabint,String[] tabstring){
        this.Cleprimaire = clef;
        this.premieredonnee= new int [tabint.length] ;
        this.deuxiemedonnee=new String[tabstring.length] ;
        this.clefhashage=0;
        for(int i=0; i < tabint.length ; i++){
            this.premieredonnee[i]= tabint[i];
        }
        for(int i=0; i < tabstring.length ; i++){
            this.deuxiemedonnee[i]= tabstring[i];
        }
        
    };
    
    public int lecturedonneepremier (int rang){
        return this.premieredonnee[rang];
    }
    
    public String lecturedonneedeuxieme (int rang){
        return this.deuxiemedonnee[rang];
    }
    
    public int[] lectureentier (){
        return this.premieredonnee;
    }
    
    public String[] lecturestring (){
        return this.deuxiemedonnee;
    }
    
    public void insertiondonnee (int i, int donne){
        this.premieredonnee[i]= donne;
    }
    
    public void insertiondonnee (int i, String donne){
        this.deuxiemedonnee[i]= donne;
    }
    public int[] get(){
        int tab []= new int [3];
        int a=0 ;
        int b = 0;
        if (this.premieredonnee.length>0){
            a=1;
        }
        if (this.deuxiemedonnee.length>0){
            b=1;
        }
        tab = new int[] {this.Cleprimaire,a,b};
        return tab;
    }
    
    public void hasher(int nb){
        this.clefhashage=nb;
    }
    
    public int clef(){
       return this.clefhashage;
    }
    
    public void affiche(){
        System.out.println("donnée "+ this.Cleprimaire +" affiche: ");
        int tab [] = new int[3];
        tab = this.get();
        if (tab[1]==1){
            for( int i = 0 ; i<this.premieredonnee.length; i++){
                System.out.print(this.premieredonnee[i] + " ");
            }
        }
        if (tab[2]==1){
            for( int i = 0 ; i<this.deuxiemedonnee.length; i++){
                System.out.print(this.deuxiemedonnee[i]+" ");
            }
        }
        System.out.println();
    }
}
