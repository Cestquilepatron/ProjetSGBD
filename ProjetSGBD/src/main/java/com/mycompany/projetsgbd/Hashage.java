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
public class Hashage {
    private Table tab;
    private Memoirecentrale mem;
    
    public void set(Table nomtab,Memoirecentrale nommemoire){
        this.mem=nommemoire;
        this.tab=nomtab;   
    }
    
    public void hash(String nomhashage,Donnees don,int cible ,int rangcible,int nb){
        switch(nomhashage){
            case "modulo":
                if (cible != 2){
                    int num = don.lecturedonneepremier(rangcible);
                    int result = num % nb;
                    don.hasher(result);
                }
            case "pair":
                if (cible !=2){
                   int num = don.lecturedonneepremier(rangcible);
                   int result = num % 2;
                   don.hasher(result); 
                }
        }
    }
    
    public void fonctiondehachage (String s){
        for (int i=0; i<mem.get ();i++){
            try{
                Buffer buff=mem.utilisation(i);
                for (int j=0; j<buff.taille();j++){
                    Block bloc = buff.dechargement(j);
                    for (int parcour = 0; parcour<bloc.taille();parcour++){
                        Donnees donne = bloc.utilisation(parcour);
                        hash(s,donne,1,0,5);
                    }
                }
            }catch(Exception e){System.out.println("Buffer" +i+" vide");}
        }
    }
    
    
}
