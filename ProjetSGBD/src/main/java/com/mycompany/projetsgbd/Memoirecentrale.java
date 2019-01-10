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
                        System.out.println("charge buffer "+i);
                        this.Memoire[i].chargementseq(tab.liaison(parcourtab), base,this.Memoire[(i-1)%(nbbuffer-1)].indiceseqrestante());
                    }
                    else{
                        System.out.println("chargement buffer "+i);
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
    
    public Tablehash chargementbucket(Table T){
        Tablehash tabhash=new Tablehash();
        tabhash.set(T.get(), 100);
        int parcourstab=0;
        while (parcourstab < T.taille()){//parcours de la table
            for (int i=0 ; i < nbbuffer ;i++ ){//chargement des blocs dans les buffers
                try{
                    if (i!=0 && this.Memoire[(i-1)%(nbbuffer-1)].indiceseqrestante()!=0){//Vérification de si la sequence est entierement chargé
                        System.out.println("charge buffer "+i);
                        this.Memoire[i].chargementseq(T.liaison(parcourstab), base,this.Memoire[(i-1)%(nbbuffer-1)].indiceseqrestante());
                    }
                    else{
                        System.out.println("chargement buffer "+i);
                        this.Memoire[i].chargementseq(T.liaison(parcourstab),base,0);
                        parcourstab++;
                        
                    }
                }catch(Exception e){System.out.println("chargement fail à l'étape "+i+" tab chargé jusqu'à la séquence "+parcourstab+ " sur une taille de tab de"+ T.taille());}
            }
            //tout les buffers sont chargés, mais la table ne tient pas dans la memoire centrale, donc on hache les buffers puis on les reremplis
            for (int i = 0; i< nbbuffer; i++){
                try{
                    for (int j=0; j< Memoire[i].taille();j++){
                        Block bloc = Memoire[i].dechargement(j);
                        for (int parcour = 0; parcour<bloc.taille();parcour++){
                            Donnees donne = bloc.utilisation(parcour);
                            try{
                            Bucket buck=base.research2(donne.clef());
                            buck.integration(base.get2()+1,donne);

                            }catch(Exception e)
                                {
                                    Bucket buck = new Bucket();
                                    buck.set(base.get2(), 5, donne.clef());
                                    base.add2(buck);
                                    tabhash.integration( buck);
                                }
                            
                        }
                    }
                }catch(Exception e){}
            }
        }
        for (int i = 0; i< nbbuffer; i++){
            try{
                for (int j=0; j< Memoire[i].taille();j++){
                    Block bloc = Memoire[i].dechargement(j);
                    for (int parcour = 0; parcour<bloc.taille();parcour++){
                        Donnees donne = bloc.utilisation(parcour);
                        try{
                            Bucket buck=base.research2(donne.clef());
                            buck.integration(base.get2()+1,donne);
                        }catch(Exception e)
                        {
                            Bucket buck = new Bucket();
                            buck.set(base.get2(), 5, donne.clef());
                            base.add2(buck);
                            tabhash.integration( buck);
                        }    
                    }
                }
            }catch(Exception e){}
        }
        return tabhash;
    }
    
    public void remplissagebucket(Tablehash tabhash){
        for (int i = 0; i< nbbuffer; i++){
            try{
                for (int j=0; j< Memoire[i].taille();j++){
                    Block bloc = Memoire[i].dechargement(j);
                    for (int parcour = 0; parcour<bloc.taille();parcour++){
                        Donnees donne = bloc.utilisation(parcour);
                        try{
                            Bucket buck=base.research2(donne.clef());
                            buck.integration(base.get2()+1,donne);
                        }catch(Exception e)
                           {
                                Bucket buck = new Bucket();
                                buck.set(base.get2(), 5, donne.clef());
                                base.add2(buck);
                                tabhash.integration( buck);
                            }
                    }
                }
            }catch(Exception e){}
        }
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
