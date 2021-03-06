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
public class Buffer {
    private int id;
    private  int capacite;
    private int remplissage;
    private Block[] contenu;
    private Bucket contient;
    private boolean sequencefinie;//pour savoir si le buffer suivant doit charger la même sequence
    private int nbblocseq;//pour donner au buffer suivant à partir de quelle sequence, il doit charger
    
    public void set(int numero,int taille){
        this.id=numero;
        this.capacite=taille;
        this.contenu= new Block[taille];
        this.contient=new Bucket();
        this.sequencefinie = true;
        this.nbblocseq = 0;
    }
    
    public void chargement(int i ,Block bloc){
        this.contenu[i] = bloc;
    }
    
    public Block dechargement(int i ){
       return this.contenu[i];
    }
    
    public void chargement2(Bucket bloc){
        this.contient = bloc;
    }
    
    public Bucket dechargement2(){
       return this.contient;
    }
    
    
    public void chargementtablethash (int place,Tablehash table){
        this.contient=table.liaison(place);
    }
    
    public int remplis(){
        return this.remplissage;
    }
    
    public void chargementseq(Sequenceblock seq, Basededonnees Basede,int repriseseq){
        int [] tab = seq.get();
        int indice=tab[1];
        int taille = tab[2];
        if (taille<= this.capacite){//une sequence charger dans un buffer
            for (int i=0; i<taille;i++){
               this.contenu[i]= Basede.research(indice+i);
            }
            this.sequencefinie =true;
            this.nbblocseq= 0;
        }
        else{//une sequence qui ne tient pas dans un buffer
            if (repriseseq+this.capacite < taille){;//une sequence charger dans un buffer mais ou il reste des parties à charger
                for (int i=0; i<this.capacite;i++){
                    this.contenu[i]= Basede.research(indice+i+repriseseq);
                }
                this.sequencefinie =false;
                this.nbblocseq = repriseseq + this.capacite;
            }
            else{//fin de chargement d'une sequence
                for (int i=0; i<taille-repriseseq;i++){
                    try{
                    this.contenu[i]= Basede.research(indice+i+repriseseq);
                    }catch(Exception e){System.out.println(e);}
                }
                this.sequencefinie =true;
                this.nbblocseq = 0;
            }
        }
        
    }
    
    public int indiceseqrestante(){
        if (this.sequencefinie){
            return 0;
        }
        else {
            return this.nbblocseq;
        }
    }
    
    public boolean Seqfinie(){
        return this.sequencefinie;
    }
    
    public int taille(){
        return this.capacite;
    }
    
    public int get(){
        return this.id;
    }
    
    public void videBuff(){
        this.contenu= new Block[this.capacite];
        this.contient=new Bucket();
        this.sequencefinie = true;
        this.nbblocseq = 0;
    }
}
