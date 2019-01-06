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
public class Memoirecentrale {
    private int nbbuffer;
    private Buffer[] Memoire;
    private Basededonnees base;
    
    public void set(int nombre,Basededonnees bd){
        this.nbbuffer = nombre;
        this.Memoire = new Buffer[nombre];
        this.base = bd;
    }
    
    public void composition(int i,Buffer buf){
        this.Memoire[i]= buf;
    }
    
    public Buffer utilisation(int i){
        return this.Memoire[i];
    }
    
    public int get(){
        return this.nbbuffer;
    }
    
    public void chargement (Table tab,Hashage H){
        int parcourtab = 0;
        while (parcourtab < tab.taille()){//parcours de la table
            for (int i=0 ; i < nbbuffer ;i++ ){//chargement des blocs dans les buffers
                try{
                    if (i!=0 && this.Memoire[(i-1)%(nbbuffer-1)].indiceseqrestante()!=0){//Vérification de si la sequence est entierement chargé
                        this.Memoire[i].chargementseq(tab.liaison(parcourtab), base,this.Memoire[(i-1)%(nbbuffer-1)].indiceseqrestante());
                    }
                    else{
                        this.Memoire[i].chargementseq(tab.liaison(parcourtab),base,0);
                        parcourtab++;
                        
                    }
                }catch(Exception e){System.out.println("chargement fail à l'étape "+i+" tab chargé jusqu'à la séquence "+parcourtab+ " sur une taille de tab de"+ tab.taille());}
            }
            //tout les buffers sont chargés, mais la table ne tient pas dans la memoire centrale, donc on hache les buffers puis on les reremplis
            H.fonctiondehachage();
        }
        H.fonctiondehachage(); //hachage en sortie de while pour finir la table
    }
    
      public void chargement (Table tab, Table tabdeux,Jointure J){
        int parcourtab = 0;
        while (parcourtab < tab.taille()){//pacours de la table
            for (int i=0 ; i < nbbuffer ;i++ ){//chargement des blocs dans les buffers
                if (this.Memoire[(i-1)%(nbbuffer-1)].indiceseqrestante()!=0){//Vérification de si la sequence est entierement chargé
                    this.Memoire[i].chargementseq(tab.liaison(parcourtab), base,this.Memoire[(i-1)%(nbbuffer-1)].indiceseqrestante());
                }
                else{
                    parcourtab++;
                    this.Memoire[i].chargementseq(tab.liaison(parcourtab),base,0);
                }
            }
            //tout les buffers sont chargés, mais la table ne tient pas dans la memoire centrale, donc on hache les buffers puis on les reremplis
            //jointure
        }
        //jointure //hachage en sortie de while pour finir la table
    }
}
