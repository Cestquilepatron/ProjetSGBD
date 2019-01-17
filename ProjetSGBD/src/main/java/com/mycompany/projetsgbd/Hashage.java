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
    private String nomhashage;
    private int cible ;
    private int rangcible;
    private int nb;
    
    public void set(Table nomtab,Memoirecentrale nommemoire,String nomhash,int ci ,int rangci,int n){
        this.mem=nommemoire;
        this.tab=nomtab;
        this.nomhashage= nomhash;
        this.cible=ci;
        this.rangcible=rangci;
        this.nb=n;
    }
    
    public Donnees hash(Donnees don){
        switch(this.nomhashage){
            case "modulo":
                if (this.cible != 2){
                    int num = don.lecturedonneepremier(this.rangcible);
                    int result = num % this.nb;
                    
                    don.hasher(result);
                    return don;
                }
                else{
                    String nom = don.lecturedonneedeuxieme(this.rangcible);
                    int taille = nom.length();
                    int result= taille%this.nb;
                    don.hasher(result);
                    return don;
                }
            case "pair":
                if (this.cible !=2){
                   int num = don.get()[0];
                   int result = num % 2;
                   don.hasher(result);
                   return don;
                }
                else{
                    String nom = don.lecturedonneedeuxieme(this.rangcible);
                    int taille = nom.length();
                    int result= taille%2;
                    don.hasher(result);
                    return don;
                }
            case "égalité":
                if (this.cible !=2){
                   int num = don.lecturedonneepremier(this.rangcible);
                   int result = num-this.nb;
                   don.hasher(result);
                   return don;
                }
                else{
                    int result;
                    String nom = don.lecturedonneedeuxieme(this.rangcible);
                    String comp = don.lecturedonneedeuxieme(this.nb);
                    boolean comparaison = nom.equals(comp);
                    if (comparaison){
                        result=1;
                    }
                    else{
                        result=0;
                    }
                    don.hasher(result);
                    return don;
                }   
            default:
                System.out.println("Erreur choix de Hashage");
                return don;
        }
    }
    
    public void fonctiondehachage (){
        for (int i=0; i<mem.get ();i++){
            try{
                Buffer buff=mem.utilisation(i);
                for (int j=0; j<buff.taille();j++){//Pour chaque buffer de la mémoire centrale, on
                    Block bloc = buff.dechargement(j);
                    for (int parcour = 0; parcour<bloc.taille();parcour++){
                        Donnees donne = bloc.utilisation(parcour);
                        donne=hash(donne);
                        
                    }
                }
            }catch(Exception e){/*System.out.println("Buffer" +i+" vide");*/}
        }
    }
    
    
}
